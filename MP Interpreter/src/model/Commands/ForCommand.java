package model.Commands;

import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.PseudoCodeParser.*;
import model.Sematic.IdentifierMapper;
import model.Utils.LocalVarTracker;

import java.util.ArrayList;
import java.util.List;

public class ForCommand implements IControlledCommand  {

    private ForinitializerContext variableUB;
    private ExpressionContext exprLB;

    private List<ICommand> forstatement;
    private ArrayList<String> variables = new ArrayList<>();

    private boolean isUpto;

    public ForCommand(ForinitializerContext variableUB, ExpressionContext exprLB, String iteration){
        this.variableUB = variableUB;
        this.exprLB = exprLB;

        if(iteration.equals("up to")){
            this.isUpto = true;
        }else{
            this.isUpto = false;
        }

        this.forstatement = new ArrayList<ICommand>();
    }

    @Override
    public void execute() {
//        this.identifyVariables();

//        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
//
//        LocalVarTracker.resetLocalVars(variables);
//
//        try {
//            //evaluate the given condition
//            while(evaluateCondition()) {
//                for(ICommand command : this.commandSequences) {
//                    executionMonitor.tryExecution();
//                    command.execute();
//
//                    LocalVarTracker.getInstance().populateLocalVars(command);
//
//                    if (ExecutionManager.getInstance().isAborted())
//                        break;
//                }
//
//                if (ExecutionManager.getInstance().isAborted())
//                    break;
//
//                executionMonitor.tryExecution();
//                this.updateCommand.execute(); //execute the update command
//                this.identifyVariables(); //identify variables again to detect changes to such variables used.
//            }
//
//        } catch(InterruptedException e) {
//            System.out.println(TAG + ": " + "Monitor block interrupted! " +e.getMessage());
//        }
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.FOR_LOOP;
    }

    @Override
    public void addCommand(ICommand command) {
        this.forstatement.add(command);
    }

    public static boolean evaluateCondition(ExpressionContext expressionContext) {
        if(expressionContext.getText().equals("T")) {
            return true;
        }
        else if(expressionContext.getText().equals("F")) {
            return false;
        }

        ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
        expressionCommand.execute();

        return expressionCommand.getValueResult().intValue() == 1;
    }
}
