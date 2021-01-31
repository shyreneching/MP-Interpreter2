package model.Utils;

import model.Commands.AssignmentCommand;
import model.Commands.ICommand;

import java.util.ArrayList;
import java.util.Stack;

public class LocalVarTracker {
    private static LocalVarTracker sharedInstance = null;
    private Stack<ArrayList<String>> sessions;

    public static LocalVarTracker getInstance() {
        return sharedInstance;
    }

    public static void initialize() {
        sharedInstance = new LocalVarTracker();
    }

    public static void reset() {
        sharedInstance = new LocalVarTracker();
    }

    public LocalVarTracker () {
        sessions = new Stack<ArrayList<String>>();
    }

    public void populateLocalVars(ICommand command) {

        if (!sessions.isEmpty()) {
            if (command instanceof AssignmentCommand) {
                if (!((AssignmentCommand) command).isLeftHandArrayAccessor())
                    sessions.peek().add(((AssignmentCommand) command).getLeftHandExpr().getText());
            }

        }

    }

    public static void resetLocalVars(ArrayList<String> localVars) {
        localVars.clear();
    }

    public void startNewSession() {
        sessions.push(new ArrayList<String>());
    }

    public ArrayList<String> getCurrentSession() {
        return sessions.peek();
    }

    public ArrayList<String> endCurrentSession() {
        return sessions.pop();
    }
}
