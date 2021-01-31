package model.SymbolTable.Scope;

import model.Item.PseudoValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScopeCreator {
    private static ScopeCreator sharedInstance = null;
    private Scope activeScope = null;

    public static ScopeCreator getInstance() {
        return sharedInstance;
    }

    private ScopeCreator() { }

    public static void initialize() {
        sharedInstance = new ScopeCreator();
    }

    public static void reset() {
        sharedInstance.activeScope = null;
    }

    public Scope openScope() {
        if(this.activeScope == null) {
            this.activeScope = new Scope();
        }
        else {
            Scope childLocalScope = new Scope();
            childLocalScope.setParent(this.activeScope);
            this.activeScope.addChild(childLocalScope);
            this.activeScope = childLocalScope;
        }

        return this.activeScope;
    }

    public void setActiveScope(Scope scope) {
        this.activeScope = scope;
    }

    public Scope getActiveScope() {
        return activeScope;
    }

    public void closeScope() {
        if(this.activeScope.getParent() != null && this.activeScope.getParent() instanceof Scope) {
            this.activeScope = (Scope) this.activeScope.getParent();
        }
        else if(this.activeScope.getParent() == null) {
            System.out.println("ScopeCreator - " + "Cannot change parent. Current active scope no longer has a parent.");
        }
        else {
            System.out.println("ScopeCreator - " + "Cannot change parent. Current active scope's parent is now the SymbolTableManager.");
        }
    }

    public static PseudoValue searchVariableInLocalIterative(String identifier, Scope scope) {

        if(scope == null) {
            System.out.println("ScopeCreator - " + identifier + " not found in any scope!");
            return null;
        }

        Stack<Scope> stack = new Stack<Scope>();

        stack.push(scope);

        List<Scope> discoveredScopes = new ArrayList<Scope>();
        Scope scope1;

        while(!stack.isEmpty()) {
            scope1 = stack.pop();

            if(scope1.containsVariable(identifier)) {
                return scope1.searchVariableIncludingLocal(identifier);
            }

            if(!discoveredScopes.contains(scope1)) {
                discoveredScopes.add(scope1);

                for(int i = 0; i < scope1.getChildCount(); i++) {
                    Scope childScope = scope1.getChildAt(i);
                    stack.push(childScope);
                }
            }
        }

        System.out.println("ScopeCreator - " + identifier + " not found in any scope!");
        return null;
    }
}
