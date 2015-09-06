package com.sqatntu.stylechecker;

import com.sqatntu.stylechecker.JavaListener;
import com.sqatntu.stylechecker.JavaParser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by andyccs on 6/9/15.
 */
public class MethodListener implements JavaListener {

    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {

    }

    @Override
    public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {

    }

    @Override
    public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {

    }

    @Override
    public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {

    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {

    }

    @Override
    public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) {

    }

    @Override
    public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {

    }

    @Override
    public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {

    }

    @Override
    public void enterModifier(JavaParser.ModifierContext ctx) {

    }

    @Override
    public void exitModifier(JavaParser.ModifierContext ctx) {

    }

    @Override
    public void enterClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) {

    }

    @Override
    public void exitClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) {

    }

    @Override
    public void enterVariableModifier(JavaParser.VariableModifierContext ctx) {

    }

    @Override
    public void exitVariableModifier(JavaParser.VariableModifierContext ctx) {

    }

    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {

    }

    @Override
    public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {

    }

    @Override
    public void enterTypeParameters(JavaParser.TypeParametersContext ctx) {

    }

    @Override
    public void exitTypeParameters(JavaParser.TypeParametersContext ctx) {

    }

    @Override
    public void enterTypeParameter(JavaParser.TypeParameterContext ctx) {

    }

    @Override
    public void exitTypeParameter(JavaParser.TypeParameterContext ctx) {

    }

    @Override
    public void enterTypeBound(JavaParser.TypeBoundContext ctx) {

    }

    @Override
    public void exitTypeBound(JavaParser.TypeBoundContext ctx) {

    }

    @Override
    public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {

    }

    @Override
    public void exitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {

    }

    @Override
    public void enterEnumConstants(JavaParser.EnumConstantsContext ctx) {

    }

    @Override
    public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) {

    }

    @Override
    public void enterEnumConstant(JavaParser.EnumConstantContext ctx) {

    }

    @Override
    public void exitEnumConstant(JavaParser.EnumConstantContext ctx) {

    }

    @Override
    public void enterEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) {

    }

    @Override
    public void exitEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) {

    }

    @Override
    public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {

    }

    @Override
    public void enterTypeList(JavaParser.TypeListContext ctx) {

    }

    @Override
    public void exitTypeList(JavaParser.TypeListContext ctx) {

    }

    @Override
    public void enterClassBody(JavaParser.ClassBodyContext ctx) {

    }

    @Override
    public void exitClassBody(JavaParser.ClassBodyContext ctx) {

    }

    @Override
    public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx) {

    }

    @Override
    public void exitInterfaceBody(JavaParser.InterfaceBodyContext ctx) {

    }

    @Override
    public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {

    }

    @Override
    public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {

    }

    @Override
    public void enterMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {

    }

    @Override
    public void exitMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {

    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        String methodName = ctx.getChild(1).getText();
        if (methodName.matches("^([a-z])([a-zA-Z0-9])*")) {
           System.out.println("OK!");
        } else {
            System.out.println("Not OK!");
        }

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine() + ctx.getChild(0).getText().length() + 2;

        System.out.println("Line: " + line);
        System.out.println("Column: " + column);
        System.out.println("");
    }

    @Override
    public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {

    }

    @Override
    public void enterGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx) {

    }

    @Override
    public void exitGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx) {

    }

    @Override
    public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {

    }

    @Override
    public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {

    }

    @Override
    public void enterGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx) {

    }

    @Override
    public void exitGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx) {

    }

    @Override
    public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {

    }

    @Override
    public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {

    }

    @Override
    public void enterInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) {

    }

    @Override
    public void enterInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) {

    }

    @Override
    public void enterConstDeclaration(JavaParser.ConstDeclarationContext ctx) {

    }

    @Override
    public void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx) {

    }

    @Override
    public void enterConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {

    }

    @Override
    public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {

    }

    @Override
    public void enterInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void enterGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void exitGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void enterVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {

    }

    @Override
    public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {

    }

    @Override
    public void enterVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {

    }

    @Override
    public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {

    }

    @Override
    public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {

    }

    @Override
    public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {

    }

    @Override
    public void enterVariableInitializer(JavaParser.VariableInitializerContext ctx) {

    }

    @Override
    public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) {

    }

    @Override
    public void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx) {

    }

    @Override
    public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) {

    }

    @Override
    public void enterEnumConstantName(JavaParser.EnumConstantNameContext ctx) {

    }

    @Override
    public void exitEnumConstantName(JavaParser.EnumConstantNameContext ctx) {

    }

    @Override
    public void enterType(JavaParser.TypeContext ctx) {

    }

    @Override
    public void exitType(JavaParser.TypeContext ctx) {

    }

    @Override
    public void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {

    }

    @Override
    public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {

    }

    @Override
    public void enterPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {

    }

    @Override
    public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {

    }

    @Override
    public void enterTypeArguments(JavaParser.TypeArgumentsContext ctx) {

    }

    @Override
    public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) {

    }

    @Override
    public void enterTypeArgument(JavaParser.TypeArgumentContext ctx) {

    }

    @Override
    public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) {

    }

    @Override
    public void enterQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {

    }

    @Override
    public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {

    }

    @Override
    public void enterFormalParameters(JavaParser.FormalParametersContext ctx) {

    }

    @Override
    public void exitFormalParameters(JavaParser.FormalParametersContext ctx) {

    }

    @Override
    public void enterFormalParameterList(JavaParser.FormalParameterListContext ctx) {

    }

    @Override
    public void exitFormalParameterList(JavaParser.FormalParameterListContext ctx) {

    }

    @Override
    public void enterFormalParameter(JavaParser.FormalParameterContext ctx) {

    }

    @Override
    public void exitFormalParameter(JavaParser.FormalParameterContext ctx) {

    }

    @Override
    public void enterLastFormalParameter(JavaParser.LastFormalParameterContext ctx) {

    }

    @Override
    public void exitLastFormalParameter(JavaParser.LastFormalParameterContext ctx) {

    }

    @Override
    public void enterMethodBody(JavaParser.MethodBodyContext ctx) {

    }

    @Override
    public void exitMethodBody(JavaParser.MethodBodyContext ctx) {

    }

    @Override
    public void enterConstructorBody(JavaParser.ConstructorBodyContext ctx) {

    }

    @Override
    public void exitConstructorBody(JavaParser.ConstructorBodyContext ctx) {

    }

    @Override
    public void enterQualifiedName(JavaParser.QualifiedNameContext ctx) {

    }

    @Override
    public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) {

    }

    @Override
    public void enterLiteral(JavaParser.LiteralContext ctx) {

    }

    @Override
    public void exitLiteral(JavaParser.LiteralContext ctx) {

    }

    @Override
    public void enterAnnotation(JavaParser.AnnotationContext ctx) {

    }

    @Override
    public void exitAnnotation(JavaParser.AnnotationContext ctx) {

    }

    @Override
    public void enterAnnotationName(JavaParser.AnnotationNameContext ctx) {

    }

    @Override
    public void exitAnnotationName(JavaParser.AnnotationNameContext ctx) {

    }

    @Override
    public void enterElementValuePairs(JavaParser.ElementValuePairsContext ctx) {

    }

    @Override
    public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) {

    }

    @Override
    public void enterElementValuePair(JavaParser.ElementValuePairContext ctx) {

    }

    @Override
    public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) {

    }

    @Override
    public void enterElementValue(JavaParser.ElementValueContext ctx) {

    }

    @Override
    public void exitElementValue(JavaParser.ElementValueContext ctx) {

    }

    @Override
    public void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {

    }

    @Override
    public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) {

    }

    @Override
    public void enterAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) {

    }

    @Override
    public void exitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) {

    }

    @Override
    public void enterAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) {

    }

    @Override
    public void exitAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) {

    }

    @Override
    public void enterAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {

    }

    @Override
    public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) {

    }

    @Override
    public void enterAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) {

    }

    @Override
    public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) {

    }

    @Override
    public void enterAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) {

    }

    @Override
    public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) {

    }

    @Override
    public void enterAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) {

    }

    @Override
    public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) {

    }

    @Override
    public void enterAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) {

    }

    @Override
    public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) {

    }

    @Override
    public void enterDefaultValue(JavaParser.DefaultValueContext ctx) {

    }

    @Override
    public void exitDefaultValue(JavaParser.DefaultValueContext ctx) {

    }

    @Override
    public void enterBlock(JavaParser.BlockContext ctx) {

    }

    @Override
    public void exitBlock(JavaParser.BlockContext ctx) {

    }

    @Override
    public void enterBlockStatement(JavaParser.BlockStatementContext ctx) {

    }

    @Override
    public void exitBlockStatement(JavaParser.BlockStatementContext ctx) {

    }

    @Override
    public void enterLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) {

    }

    @Override
    public void exitLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) {

    }

    @Override
    public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {

    }

    @Override
    public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {

    }

    @Override
    public void enterStatement(JavaParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(JavaParser.StatementContext ctx) {

    }

    @Override
    public void enterCatchClause(JavaParser.CatchClauseContext ctx) {

    }

    @Override
    public void exitCatchClause(JavaParser.CatchClauseContext ctx) {

    }

    @Override
    public void enterCatchType(JavaParser.CatchTypeContext ctx) {

    }

    @Override
    public void exitCatchType(JavaParser.CatchTypeContext ctx) {

    }

    @Override
    public void enterFinallyBlock(JavaParser.FinallyBlockContext ctx) {

    }

    @Override
    public void exitFinallyBlock(JavaParser.FinallyBlockContext ctx) {

    }

    @Override
    public void enterResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {

    }

    @Override
    public void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) {

    }

    @Override
    public void enterResources(JavaParser.ResourcesContext ctx) {

    }

    @Override
    public void exitResources(JavaParser.ResourcesContext ctx) {

    }

    @Override
    public void enterResource(JavaParser.ResourceContext ctx) {

    }

    @Override
    public void exitResource(JavaParser.ResourceContext ctx) {

    }

    @Override
    public void enterSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {

    }

    @Override
    public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {

    }

    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {

    }

    @Override
    public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) {

    }

    @Override
    public void enterForControl(JavaParser.ForControlContext ctx) {

    }

    @Override
    public void exitForControl(JavaParser.ForControlContext ctx) {

    }

    @Override
    public void enterForInit(JavaParser.ForInitContext ctx) {

    }

    @Override
    public void exitForInit(JavaParser.ForInitContext ctx) {

    }

    @Override
    public void enterEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {

    }

    @Override
    public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {

    }

    @Override
    public void enterForUpdate(JavaParser.ForUpdateContext ctx) {

    }

    @Override
    public void exitForUpdate(JavaParser.ForUpdateContext ctx) {

    }

    @Override
    public void enterParExpression(JavaParser.ParExpressionContext ctx) {

    }

    @Override
    public void exitParExpression(JavaParser.ParExpressionContext ctx) {

    }

    @Override
    public void enterExpressionList(JavaParser.ExpressionListContext ctx) {

    }

    @Override
    public void exitExpressionList(JavaParser.ExpressionListContext ctx) {

    }

    @Override
    public void enterStatementExpression(JavaParser.StatementExpressionContext ctx) {

    }

    @Override
    public void exitStatementExpression(JavaParser.StatementExpressionContext ctx) {

    }

    @Override
    public void enterConstantExpression(JavaParser.ConstantExpressionContext ctx) {

    }

    @Override
    public void exitConstantExpression(JavaParser.ConstantExpressionContext ctx) {

    }

    @Override
    public void enterExpression(JavaParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(JavaParser.ExpressionContext ctx) {

    }

    @Override
    public void enterPrimary(JavaParser.PrimaryContext ctx) {

    }

    @Override
    public void exitPrimary(JavaParser.PrimaryContext ctx) {

    }

    @Override
    public void enterCreator(JavaParser.CreatorContext ctx) {

    }

    @Override
    public void exitCreator(JavaParser.CreatorContext ctx) {

    }

    @Override
    public void enterCreatedName(JavaParser.CreatedNameContext ctx) {

    }

    @Override
    public void exitCreatedName(JavaParser.CreatedNameContext ctx) {

    }

    @Override
    public void enterInnerCreator(JavaParser.InnerCreatorContext ctx) {

    }

    @Override
    public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) {

    }

    @Override
    public void enterArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) {

    }

    @Override
    public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) {

    }

    @Override
    public void enterClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) {

    }

    @Override
    public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) {

    }

    @Override
    public void enterExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) {

    }

    @Override
    public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) {

    }

    @Override
    public void enterNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) {

    }

    @Override
    public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) {

    }

    @Override
    public void enterTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void enterNonWildcardTypeArgumentsOrDiamond(JavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void exitNonWildcardTypeArgumentsOrDiamond(JavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) {

    }

    @Override
    public void enterSuperSuffix(JavaParser.SuperSuffixContext ctx) {

    }

    @Override
    public void exitSuperSuffix(JavaParser.SuperSuffixContext ctx) {

    }

    @Override
    public void enterExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) {

    }

    @Override
    public void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) {

    }

    @Override
    public void enterArguments(JavaParser.ArgumentsContext ctx) {

    }

    @Override
    public void exitArguments(JavaParser.ArgumentsContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
