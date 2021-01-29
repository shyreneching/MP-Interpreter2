package model.SymbolTable.Scope;

import model.Item.PseudoValue;

public interface IScope {
    public abstract PseudoValue searchVariableIncludingLocal(String identifier);
    public abstract boolean isParent();
}
