/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.sqatntu;

import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.proto.ErrorOuterClass;
import com.sqatntu.stylechecker.proto.StyleCheckGrpc;
import com.sqatntu.stylechecker.proto.StyleCheckOuterClass.StyleCheckReply;
import com.sqatntu.stylechecker.proto.StyleCheckOuterClass.StyleCheckReport;
import com.sqatntu.stylechecker.proto.StyleCheckOuterClass.StyleCheckRequest;
import com.sqatntu.stylechecker.report.ReportContent;
import com.sqatntu.stylechecker.report.StyleReport;
import io.grpc.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * SQATServer class for Style Checker
 */
class SQATServer {

  /* The PORT on which the server should run */
  private static Logger LOG = new Logger(StyleCheckImpl.class.getSimpleName());
  private static final int PORT = 50051;

  private ServerImpl server;

  public SQATServer() {
    LOG.setLevel(Logger.Level.ALL);
  }

  public void start() throws Exception {
    server = NettyServerBuilder.forPort(PORT)
        .addService(StyleCheckGrpc.bindService(new StyleCheckImpl()))
        .build()
        .start();

    LOG.i("Server started, listening on " + PORT);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the LOG may have been reset by its JVM shutdown hook.
        LOG.e("*** shutting down gRPC server since JVM is shutting down");
        SQATServer.this.stop();
        LOG.e("*** server shut down");
      }
    });
  }

  public void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  private class StyleCheckImpl implements StyleCheckGrpc.StyleCheck {
    public StyleCheckImpl() {
      LOG.setLevel(Logger.Level.ALL);
    }

    @Override
    public void check(StyleCheckRequest request, StreamObserver<StyleCheckReply> responseObserver) {
      String sourceCode = request.getSourceCode();
      String configuration = request.getConfiguration();

      StyleChecker checker = new StyleChecker();
      StyleReport styleReport;
      try {
        styleReport = checker.checkSourceCode(sourceCode, configuration);

        List<ReportContent> contents = styleReport.getReportContents();

        List<StyleCheckReport> reports = new ArrayList<>();
        for (ReportContent content : contents) {
          StyleCheckReport report = StyleCheckReport.newBuilder()
              .setLineNumber(content.getLineNumber())
              .setColumnNumber(content.getColumnNumber())
              .setReportMessage(content.getMessage())
              .setSuggestion(content.getSuggestion())
              .build();
          reports.add(report);
        }

        StyleCheckReply reply = StyleCheckReply.newBuilder()
            .addAllReports(reports)
            .build();
        responseObserver.onValue(reply);
        responseObserver.onCompleted();
      } catch (StyleCheckerException e) {
        ErrorOuterClass.Error error = ErrorOuterClass.Error.newBuilder()
            .setCode(500)
            .setMessage(e.getMessage())
            .build();
        StyleCheckReply reply = StyleCheckReply.newBuilder()
            .setError(error)
            .build();
        responseObserver.onValue(reply);
        responseObserver.onCompleted();
      }
    }
  }
}
