package model.Commands;

import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.IdentifierMapper;
import model.Sematic.VariableSearcher;
import model.Utils.AssignmentUtils;
import model.Utils.LocalVarTracker;

import java.math.BigDecimal;
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
        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();

        LocalVarTracker.resetLocalVars(variables);

        try {
            init(variableUB);
            while(evaluateCondition(variableUB, exprLB)) {
                for(ICommand command : this.forstatement) {
                    executionMonitor.tryExecution();
                    command.execute();

                    LocalVarTracker.getInstance().populateLocalVars(command);

                    if (ExecutionManager.getInstance().isAborted())
                        break;
                }

                if (ExecutionManager.getInstance().isAborted())
                    break;

                executionMonitor.tryExecution();
                this.updateCommand(variableUB); //execute the update command
            }

        } catch(InterruptedException e) {
            System.out.println("Block interrupted! " +e.getMessage());
        }
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.FOR_LOOP;
    }

    @Override
    public void addCommand(ICommand command) {
        this.forstatement.add(command);
    }

    public void init(ForinitializerContext variableUB){
        ExpressionCommand exprCmd = new ExpressionCommand(variableUB.customAssignError().expression());
        exprCmd.execute();

        int x = exprCmd.getValueResult().intValue();

        if(variableUB.expression() == null){
            PseudoValue pseudoValue = VariableSearcher.searchVariable(variableUB.Identifier().getText());
            AssignmentUtils.assignAppropriateValue(pseudoValue, new BigDecimal(x));
        } else {
            PseudoValue value = ExpressionCommand.searchValue(variableUB.Identifier().getText());
            PseudoArray pseudoArray = (PseudoArray) value.getValue();

            ExpressionCommand expressionCommand = new ExpressionCommand(variableUB.expression());
            expressionCommand.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(variableUB.customAssignError().expression().getStart().getLine());

            //create a new array value to replace value at specified index
            PseudoValue newArrayValue = new PseudoValue(null, PseudoValue.convert(pseudoArray.getPrimitiveType()));
            newArrayValue.setValue(String.valueOf(x));
            pseudoArray.updateValueAt(newArrayValue, expressionCommand.getValueResult().intValue());
        }
    }

    public void updateCommand(ForinitializerContext variableUB){
        int x;
        if(this.isUpto)
            x = 1;
        else
            x = -1;
        if(variableUB.expression() == null){
            PseudoValue pseudoValue = VariableSearcher.searchVariable(variableUB.Identifier().getText());
            x = (int) pseudoValue.getValue() + x;
            AssignmentUtils.assignAppropriateValue(pseudoValue, new BigDecimal(x));
        } else {
            PseudoValue value = ExpressionCommand.searchValue(variableUB.Identifier().getText());
            PseudoArray pseudoArray = (PseudoArray) value.getValue();

            ExpressionCommand exprCmd = new ExpressionCommand(variableUB.expression());
            exprCmd.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(variableUB.getStart().getLine());
            PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());

            x = (int) arrayValue.getValue() + x;

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(variableUB.expression().getStart().getLine());

            //create a new array value to replace value at specified index
            PseudoValue newArrayValue = new PseudoValue(null, PseudoValue.convert(pseudoArray.getPrimitiveType()));
            newArrayValue.setValue(String.valueOf(x));
            pseudoArray.updateValueAt(newArrayValue, exprCmd.getValueResult().intValue());
        }
    }

    public boolean evaluateCondition(ForinitializerContext variableUB, ExpressionContext expressionContext) {
        int x;
        if(variableUB.expression() == null){
            PseudoValue pseudoValue = VariableSearcher.searchVariable(variableUB.Identifier().getText());
            if (pseudoValue == null || pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {
                return false;
            }
            if(pseudoValue.getPrimitiveType() != PseudoValue.PrimitiveType.INT){
                return false;
            } else {
                x = (int) pseudoValue.getValue();
            }
        } else {
            PseudoValue value = ExpressionCommand.searchValue(variableUB.Identifier().getText());
            if (value != null) {
                if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                    PseudoArray pseudoArray = (PseudoArray) value.getValue();

                    ExpressionCommand exprCmd = new ExpressionCommand(variableUB.expression());
                    exprCmd.execute();

                    ExecutionManager.getInstance().setCurrentCheckedLineNumber(variableUB.getStart().getLine());
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

        ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
        expressionCommand.execute();

        if(this.isUpto)
            return expressionCommand.getValueResult().intValue() <= x;
        else
            return expressionCommand.getValueResult().intValue() >= x;
    }
}
