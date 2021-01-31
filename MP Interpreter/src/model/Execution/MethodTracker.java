package model.Execution;

import model.Item.PseudoMethod;

import java.util.Stack;

public class MethodTracker {

    private static MethodTracker sharedInstance = null;
    private Stack<PseudoMethod> callStack;

    public static MethodTracker getInstance() {
        return sharedInstance;
    }

    private MethodTracker() {
        this.callStack = new Stack<PseudoMethod>();
    }

    public static void initialize() {
        sharedInstance = new MethodTracker();
    }

    public static void reset() { }

    public void reportEnterFunction(PseudoMethod pseudoMethod) {
        this.callStack.push(pseudoMethod);
    }

    public void reportExitFunction() {
        this.callStack.pop();
    }

    public PseudoMethod getLatestFunction() {
        return this.callStack.peek();
    }

    public boolean isInsideFunction() {
        return (this.callStack.size() != 0);
    }

}
