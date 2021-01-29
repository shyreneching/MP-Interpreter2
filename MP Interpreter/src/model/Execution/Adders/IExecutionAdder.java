package model.Execution.Adders;

import model.Commands.ICommand;

public interface IExecutionAdder {
    public abstract void addCommand(ICommand command);
}
