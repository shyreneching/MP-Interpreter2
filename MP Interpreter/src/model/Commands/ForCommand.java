package model.Commands;

import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.IdentifierMapper;
import model.Sematic.VariableSearcher;
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
//            while(evaluateCondition(variableUB, exprLB)) {
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
//            System.out.println("Block interrupted! " +e.getMessage());
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

//    public static boolean evaluateCondition(ForinitializerContext variableUB, ExpressionContext expressionContext) {
//        if(variableUB.expression() == null){
//            PseudoValue pseudoValue = VariableSearcher.searchVariable(exprCtx.getText());
////        System.out.println("Entering expression command " + exprCtx.getText());
////        System.out.println("Pseudo value: " + pseudoValue.getValue());
//            if (pseudoValue == null || pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {
//                return false;
//            }
//
//            try {
//
//                if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
//
//                } else {
//                    String s = pseudoValue.getValue().toString();
//                    if(s.equals("true") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
//                        s = "T";
//                    else if(s.equals("false") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
//                        s = "F";
//                    if(!map.containsKey(exprCtx.getText())){
//                        map.put(exprCtx.getText(), s);
//                    }
////                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
////                        pseudoValue.getValue().toString());
//                }
////            System.out.println("modified exp: " + modifiedExp);
//
//            } catch (NullPointerException e) {
//                if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
//                    if(!map.containsKey(exprCtx.getText())){
//                        map.put(exprCtx.getText(), "0");
//                    }
////                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
////                        "0");
//                }else {
//                    if(!map.containsKey(exprCtx.getText())){
//                        map.put(exprCtx.getText(), "null");
//                    }
////                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
////                        "null");
//                }
//
//            }
//        }
//
//        ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
//        expressionCommand.execute();
//
//        return expressionCommand.getValueResult().intValue() == 1;
//    }
}
