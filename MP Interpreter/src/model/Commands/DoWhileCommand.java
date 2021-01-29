package model.Commands;

import java.util.ArrayList;
import java.util.List;

public class DoWhileCommand implements IControlledCommand {

    private Object variableUB;
    private Object exprLB;

    private List<ICommand> dowhilestatement;

    public DoWhileCommand(Object variableUB, Object exprLB){
        this.variableUB = variableUB;
        this.exprLB = exprLB;

        this.dowhilestatement = new ArrayList<ICommand>();
    }

    @Override
    public ControlTypeEnum getControlType() {
        return null;
    }

    @Override
    public void addCommand(ICommand command) {

    }

    @Override
    public void execute() {

    }
}
