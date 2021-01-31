package model.SymbolTable;

import model.Commands.MethodList;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.SymbolTable.Scope.IScope;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;

import java.util.HashMap;

public class SymbolTableManager implements IScope {

//    private HashMap<String, MethodScope> scopeTable;
    private HashMap<String, PseudoMethod> methodsTable;
    private static Scope parentScope;
    private static SymbolTableManager sharedInstance = null;

    public static SymbolTableManager getInstance() {
        return sharedInstance;
    }

    private SymbolTableManager() {
        this.methodsTable = new HashMap<String, PseudoMethod>();
    }

    public static void initialize(){
        sharedInstance = new SymbolTableManager();
    }

    static void destroy(){
        sharedInstance = null;
    }

    public static void reset() {
        sharedInstance.methodsTable.clear();
    }

    public static void setParentScope(Scope scope) {
        parentScope = scope;
    }

    public Scope getParentScope() {
        return parentScope;
    }

    @Override
    public boolean isParent() {
        return true;
    }

    public void addPseudoMethod(String identifier, PseudoMethod pseudoMethod) {
        this.methodsTable.put(identifier, pseudoMethod);
        System.out.println("Created method " +identifier+ " with return type " + pseudoMethod.getReturnType());
        MethodList.getInstance().addMethodName(identifier); //idk what this does
    }

    public PseudoMethod getMethod(String identifier) {
        if(this.containsMethod(identifier)) {
            return this.methodsTable.get(identifier);
        }
        else {
            System.out.println("SymbolTableManager - " +identifier+ " function is not found.");
            return null;
        }
    }

    public boolean containsMethod(String identifier) {
        return this.methodsTable.containsKey(identifier);
    }

    @Override
    public PseudoValue searchVariableIncludingLocal(String identifier) {
        return ScopeCreator.searchVariableInLocalIterative(identifier, this.parentScope);
    }

}
