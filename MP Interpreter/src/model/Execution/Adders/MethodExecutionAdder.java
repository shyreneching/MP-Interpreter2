package model.Execution.Adders;

import model.Commands.ICommand;
import model.Item.PseudoMethod;

public class MethodExecutionAdder implements IExecutionAdder{
    private PseudoMethod assignedPseudoFunction;

    public MethodExecutionAdder(PseudoMethod pseudoFunction) {
        this.assignedPseudoFunction = pseudoFunction;
    }

    @Override
    public void addCommand(ICommand command) {
        this.assignedPseudoFunction.addCommand(command);
    }

    public PseudoMethod getAssignedFunction() {
        return this.assignedPseudoFunction;
    }
}
