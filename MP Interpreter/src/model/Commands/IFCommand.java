package model.Commands;

import model.PseudoCodeParser;
import model.PseudoCodeParser.*;

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

    public boolean evaluate() {
        int value = 0;

        //replace value in look up table
        // evaluate expreassion

       return (value == 1);

    }

    @Override
    public void execute() {
        if(evaluate()){
            for (ICommand command : this.positivestatements) {
                command.execute();
            }
        } else {
            for (ICommand command : this.negativestatements) {
                command.execute();

            }
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
}
