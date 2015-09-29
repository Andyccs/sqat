export default function submitSourceCode(request, response) {
  let sourceCode = request.body.sourceCode;

  setTimeout(() => {
    response.setHeader('Content-Type', 'application/json');
    // Send a dummy data back
    response.send(JSON.stringify([{
      lineNumber: 1,
      columnNumber: 10,
      reportMessage: 'use javascript',
      suggestion: 'npm install all',
    }]));
  }, 500);
}
