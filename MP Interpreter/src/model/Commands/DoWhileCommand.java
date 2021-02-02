package model.Commands;

import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser;
import model.Sematic.VariableSearcher;
import model.Utils.AssignmentUtils;
import model.Utils.LocalVarTracker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DoWhileCommand implements IControlledCommand {

    private TerminalNode variableUB;
    private PseudoCodeParser.ExpressionContext exprLB, arrAccess;
    private ArrayList<String> variables = new ArrayList<>();
    private boolean isUpto;

    private List<ICommand> dowhilestatement;

    public DoWhileCommand(TerminalNode variableUB, PseudoCodeParser.ExpressionContext exprLB, String iteration){
        this.variableUB = variableUB;
        this.exprLB = exprLB;

        if(iteration.equals("up to")){
            this.isUpto = true;
        }else{
            this.isUpto = false;
        }

        this.dowhilestatement = new ArrayList<ICommand>();
    }

    public DoWhileCommand(TerminalNode variableUB, PseudoCodeParser.ExpressionContext arrAccess, PseudoCodeParser.ExpressionContext exprLB, String iteration){
        this.variableUB = variableUB;
        this.exprLB = exprLB;
        this.arrAccess = arrAccess;

        if(iteration.equals("up to")){
            this.isUpto = true;
        }else{
            this.isUpto = false;
        }

        this.dowhilestatement = new ArrayList<ICommand>();
    }

    @Override
    public void execute() {
        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();

        LocalVarTracker.resetLocalVars(variables);

        try {
            do {
                for(ICommand command : this.dowhilestatement) {
                    executionMonitor.tryExecution();
                    command.execute();

                    LocalVarTracker.getInstance().populateLocalVars(command);

                    if (ExecutionManager.getInstance().isAborted())
                        break;
                }

                if (ExecutionManager.getInstance().isAborted())
                    break;

                executionMonitor.tryExecution();
                this.updateCommand(); //execute the update command
            } while(evaluateCondition());

        } catch(InterruptedException e) {
            System.out.println("Block interrupted! " +e.getMessage());
        }
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.WHILE_LOOP;
    }

    @Override
    public void addCommand(ICommand command) {
        this.dowhilestatement.add(command);
    }

    public boolean evaluateCondition() {
        int x;
        if(arrAccess == null){
            PseudoValue pseudoValue = VariableSearcher.searchVariable(variableUB.getText());
            if (pseudoValue == null || pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {
                return false;
            }
            if(pseudoValue.getPrimitiveType() != PseudoValue.PrimitiveType.INT){
                return false;
            } else {
                x = (int) pseudoValue.getValue();
            }
        } else {
            PseudoValue value = ExpressionCommand.searchValue(variableUB.getText());
            if (value != null) {
                if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                    PseudoArray pseudoArray = (PseudoArray) value.getValue();

                    ExpressionCommand exprCmd = new ExpressionCommand(arrAccess);
                    exprCmd.execute();

                    ExecutionManager.getInstance().setCurrentCheckedLineNumber(arrAccess.getStart().getLine());
                    PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());
                    if (arrayValue == null)
                        return false;

                    if (arrayValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
                        x = (int) arrayValue.getValue();
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        ExpressionCommand expressionCommand = new ExpressionCommand(exprLB);
        expressionCommand.execute();

        if(this.isUpto)
            return expressionCommand.getValueResult().intValue() >= x;
        else
            return expressionCommand.getValueResult().intValue() <= x;
    }

    public void updateCommand(){
        int x;
        if(this.isUpto)
            x = 1;
        else
            x = -1;
        if(arrAccess == null){
            PseudoValue pseudoValue = VariableSearcher.searchVariable(variableUB.getText());
            x = (int) pseudoValue.getValue() + x;
            AssignmentUtils.assignAppropriateValue(pseudoValue, new BigDecimal(x));
        } else {
            PseudoValue value = ExpressionCommand.searchValue(variableUB.getText());
            PseudoArray pseudoArray = (PseudoArray) value.getValue();

            ExpressionCommand exprCmd = new ExpressionCommand(arrAccess);
            exprCmd.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(arrAccess.getStart().getLine());
            PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());

            x = (int) arrayValue.getValue() + x;

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(arrAccess.getStart().getLine());

            //create a new array value to replace value at specified index
            PseudoValue newArrayValue = new PseudoValue(null, PseudoValue.convert(pseudoArray.getPrimitiveType()));
            newArrayValue.setValue(String.valueOf(x));
            pseudoArray.updateValueAt(newArrayValue, exprCmd.getValueResult().intValue());
        }
    }
}
