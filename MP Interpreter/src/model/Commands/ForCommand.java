package model.Commands;

import model.PseudoCodeParser.*;

import java.util.ArrayList;
import java.util.List;

public class ForCommand implements IControlledCommand  {

    private ForinitializerContext variableUB;
    private ExpressionContext exprLB;

    private List<ICommand> forstatement;

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
