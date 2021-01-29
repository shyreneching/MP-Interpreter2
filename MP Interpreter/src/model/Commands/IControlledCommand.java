package model.Commands;

public interface IControlledCommand extends ICommand{
    enum ControlTypeEnum {
        IF_STATEMENT,
        DO_WHILE_LOOP,
        WHILE_LOOP,
        FOR_LOOP,
        FUNCTION_TYPE,
//        TRY_COMMAND
    }

    public abstract ControlTypeEnum getControlType();
    public abstract void addCommand(ICommand command);
}
