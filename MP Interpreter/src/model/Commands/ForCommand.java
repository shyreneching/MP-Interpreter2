package model.Commands;

import java.util.ArrayList;
import java.util.List;

public class ForCommand implements IControlledCommand  {

    private Object variableUB;
    private Object exprLB;

    private List<ICommand> forstatement;

    public ForCommand(Object variableUB, Object exprLB){
        this.variableUB = variableUB;
        this.exprLB = exprLB;

        this.forstatement = new ArrayList<ICommand>();
    }

    @Override
    public void execute() {


    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.FOR_LOOP;
    }

    @Override
    public void addCommand(ICommand command) {
        this.forstatement.add(command);
    }
}
