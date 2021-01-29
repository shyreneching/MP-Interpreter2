package model.Commands;

import java.util.ArrayList;
import java.util.List;

public class WhileCommand implements IControlledCommand  {

    private Object variableUB;
    private Object exprLB;

    private List<ICommand> whilestatement;


    public WhileCommand(Object variableUB, Object exprLB){
        this.variableUB = variableUB;
        this.exprLB = exprLB;

        this.whilestatement = new ArrayList<ICommand>();
    }

    @Override
    public void execute() {

    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.WHILE_LOOP;
    }

    @Override
    public void addCommand(ICommand command) {
        this.whilestatement.add(command);
    }
}
