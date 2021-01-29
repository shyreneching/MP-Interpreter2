package model.SymbolTable.Scope;

import model.Item.PseudoValue;
import model.SymbolTable.SymbolTableManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Scope implements IScope{
    private IScope parentScope;
    private ArrayList<Scope> childScopeList = null;
    private HashMap<String, PseudoValue> localVariables = null;

    public Scope() {
        this.parentScope = null;
    }

    public Scope(IScope parentScope) {
        this.parentScope = parentScope;
    }

    public void initializeLocalVariableMap() {
        if(this.localVariables == null) {
            this.localVariables = new HashMap<String, PseudoValue>();
        }
    }

    public void initializeChildList() {
        if(this.childScopeList == null) {
            this.childScopeList = new ArrayList<Scope>();
        }
    }

    public void setParent(IScope parentScope) {
        this.parentScope = parentScope;
    }

    public void addChild(Scope localScope) {
        this.initializeChildList();

        this.childScopeList.add(localScope);
    }

    public boolean isParent() {
        return (this.parentScope == null);
    }

    public IScope getParent() {
        return this.parentScope;
    }

    public int getChildCount() {
        if(this.childScopeList != null)
            return this.childScopeList.size();
        else
            return 0;
    }

    public Scope getChildAt(int index) {
        if(this.childScopeList != null)
            return this.childScopeList.get(index);
        else
            return null;
    }

    @Override
    public PseudoValue searchVariableIncludingLocal(String identifier) {
        if(this.containsVariable(identifier)) {
            return this.localVariables.get(identifier);
        }
        else {
            System.out.println("Scope - " + identifier + " not found!");
            return null;
        }
    }

    public boolean containsVariable(String identifier) {
        if (this.localVariables != null && this.localVariables.containsKey(identifier)) {
            return true;
        } else {
            return false;
        }
    }

//    Adds an empty variable based from keywords
    public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
        this.initializeLocalVariableMap();

        PseudoValue pseudoValue = PseudoValue.createEmptyVariable(primitiveTypeString);
        this.localVariables.put(identifierString, pseudoValue);
    }


//    Adds an initialized variable based from keywords
    public void addInitializedVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
        this.initializeLocalVariableMap();

        this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
        PseudoValue pseudoValue = this.localVariables.get(identifierString);
        pseudoValue.setValue(valueString);
    }

    public void addFinalEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
        this.initializeLocalVariableMap();

        PseudoValue pseudoValue = PseudoValue.createEmptyVariable(primitiveTypeString);
        pseudoValue.makeConst();
        this.localVariables.put(identifierString, pseudoValue);
    }

    public void addFinalInitVariableFromKeyWords(String primitiveTypeString, String identifierString, String valueString) {
        this.initializeLocalVariableMap();

        this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
        PseudoValue pseudoValue = this.localVariables.get(identifierString);
        pseudoValue.setValue(valueString);
        pseudoValue.makeConst();
    }

    public void addPseudoValue(String identifier, PseudoValue pseudoValue) {
        this.initializeLocalVariableMap();
        this.localVariables.put(identifier, pseudoValue);
    }


//    Returns the depth of this scope.
    public int getDepth() {
        int depthCount = -1;

        Scope scope = (Scope) this;

        while(scope != null) {
            depthCount++;

            IScope abstractScope = scope.getParent();

            if(abstractScope instanceof SymbolTableManager)
                break;

            scope = (Scope) abstractScope;
        }

        return depthCount;
    }
}
