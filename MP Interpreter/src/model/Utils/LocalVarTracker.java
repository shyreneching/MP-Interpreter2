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

            if (command instanceof MappingCommand) {
                sessions.peek().add(((MappingCommand) command).getIdentifierString());
            } else if (command instanceof AssignmentCommand) {
                if (!((AssignmentCommand) command).isLeftHandArrayAccessor())
                    sessions.peek().add(((AssignmentCommand) command).getLeftHandExprCtx().getText());
            }/* else if (command instanceof IncDecCommand) {
                sessions.peek().add(((IncDecCommand) command).getIdentifierString());
            } else if (command instanceof ForCommand) {
                sessions.peek().addAll(((ForCommand) command).getLocalVars());

                resetLocalVars(((ForCommand) command).getLocalVars());
            } else if (command instanceof WhileCommand) {

                if (command instanceof DoWhileCommand) {
                    sessions.peek().addAll(((DoWhileCommand) command).getLocalVars());
                } else {
                    sessions.peek().addAll(((WhileCommand) command).getLocalVars());
                }

                resetLocalVars(((WhileCommand) command).getLocalVars());


            } else if (command instanceof IfCommand) {
                sessions.peek().addAll(((IfCommand) command).getLocalVars());

                resetLocalVars(((IfCommand) command).getLocalVars());
            }*/

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
