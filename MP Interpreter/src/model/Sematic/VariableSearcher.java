package model.Sematic;

import model.Execution.MethodTracker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;

public class VariableSearcher {

    public static PseudoValue searchVariable(String identifierString) {
        PseudoValue pseudoValue = null;

        if(MethodTracker.getInstance().isInsideFunction()) {
            pseudoValue = searchVariableInFunction(MethodTracker.getInstance().getLatestFunction(), identifierString);
        }

//        if(pseudoValue == null) {
//            ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
//            pseudoValue = searchVariableInClassIncludingLocal(classScope, identifierString);
//        }

        return pseudoValue;
    }

    public static PseudoValue searchVariableInFunction(PseudoMethod pseudoMethod, String identifierString) {
        PseudoValue pseudoValue = null;

        if(pseudoMethod.hasParameter(identifierString)) {
            pseudoValue = pseudoMethod.getParameter(identifierString);
        }
        else {
            pseudoValue = ScopeCreator.searchVariableInLocalIterative(identifierString, pseudoMethod.getParentLocalScope());
        }

        return pseudoValue;
    }

//    public static BaracoValue searchVariableInClassIncludingLocal(ClassScope classScope, String identifierString) {
//        return classScope.searchVariableIncludingLocal(identifierString);
//    }
//
//    public static BaracoValue searchVariableInClass(ClassScope classScope, String identifierString) {
//        return classScope.searchVariable(identifierString);
//    }
}
