package model.Commands;

import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.Execution.MethodTracker;
import model.PseudoCodeParser;
import model.PseudoCodeParser.*;
import model.Sematic.IdentifierMapper;
import model.Utils.LocalVarTracker;

import java.util.ArrayList;
import java.util.List;

public class IFCommand implements IConditionalCommand  {

    private List<ICommand> positivestatements; //list of commands to execute if the condition holds true
    private List<ICommand> negativestatements; //list of commands to execute if the condition holds false

    private PseudoCodeParser.ExpressionContext conditionalExpr;
    private String modifiedConditionExpr;

    private boolean returned;

    private ArrayList<String> localVars = new ArrayList<>();

    public IFCommand(ExpressionContext conditionalExpr) {
        this.positivestatements = new ArrayList<ICommand>();
        this.negativestatements = new ArrayList<ICommand>();

        this.conditionalExpr = conditionalExpr;
    }

    @Override
    public void execute() {
        this.identifyVariables();

        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();

        try {
            if (evaluateCondition(this.conditionalExpr)) {
                for (ICommand command : this.positivestatements) {
                    executionMonitor.tryExecution();
                    command.execute();

                    LocalVarTracker.getInstance().populateLocalVars(command);

                    if (command instanceof ReturnCommand) {
                        returned = true;
                        break;
                    }

                    if (ExecutionManager.getInstance().isAborted())
                        break;
                }
            }
            else {
                for (ICommand command : this.negativestatements) {
                    executionMonitor.tryExecution();
                    command.execute();

                    LocalVarTracker.getInstance().populateLocalVars(command);

                    if (command instanceof ReturnCommand) {
                        returned = true;
                        break;
                    }
                    if (ExecutionManager.getInstance().isAborted())
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Block interrupted! " + e.getMessage());
        }
    }

    public void clearAllCommands() {
        this.positivestatements.clear();
        this.negativestatements.clear();
    }

    public int getPositiveCommandsCount() {
        return this.positivestatements.size();
    }

    public int getNegativeCommandsCount() {
        return this.negativestatements.size();
    }

    @Override
    public IControlledCommand.ControlTypeEnum getControlType() {
        return IControlledCommand.ControlTypeEnum.IF_STATEMENT;
    }

    @Override
    public void addPositiveCommand(ICommand command) {
        this.positivestatements.add(command);
    }

    @Override
    public void addNegativeCommand(ICommand command) {
        this.negativestatements.add(command);
    }

    public boolean isReturned() {
        return returned;
    }

    public void resetReturn(){
        this.returned = false;
    }

    public ArrayList<String> getLocalVars() {
        return localVars;
    }

    private void identifyVariables() {
        if(MethodTracker.getInstance().isInsideFunction()) {
            IdentifierMapper identifierMapper = new IdentifierMapper(this.conditionalExpr.getText(), MethodTracker.getInstance().getLatestFunction());
            identifierMapper.analyze(this.conditionalExpr);

            this.modifiedConditionExpr = identifierMapper.getModifiedExp();
        } else {
            this.modifiedConditionExpr = this.conditionalExpr.getText();
        }

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
