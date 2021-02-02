package model.Item;

import model.Commands.ICommand;
import model.Commands.IControlledCommand;
import model.Commands.IFCommand;
import model.Commands.ReturnCommand;
import model.ErrorChecking.TypeChecker;
import model.Execution.ExecutionManager;
import model.Execution.ExecutionMonitor;
import model.Execution.MethodTracker;
import model.PseudoCodeParser;
import model.Sematic.VariableSearcher;
import model.SymbolTable.Scope.Scope;
import model.Utils.LocalVarTracker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PseudoMethod implements IControlledCommand {
    public enum MethodType {
        BOOL_TYPE,
        INT_TYPE,
        FLOAT_TYPE,
        STRING_TYPE,
        CHAR_TYPE,
        VOID_TYPE
    }

    private String methodName;
    private List<ICommand> commandSequences;
    private Scope parentScope;
    private LinkedHashMap<String, PseudoValue> parameterValues;
    private PseudoValue returnValue;
    private MethodType returnType = MethodType.VOID_TYPE;
    private boolean hasValidReturns = true;

    public PseudoMethod() {
        this.commandSequences = new ArrayList<ICommand>();
        this.parameterValues = new LinkedHashMap<String, PseudoValue>();
//        this.parameterReferences = new LinkedHashMap<String, ClassScope>();
    }

    public void setParentScope(Scope scope) {
        this.parentScope = scope;
    }

    public Scope getParentScope() {
        return this.parentScope;
    }

    public void setReturnType(MethodType methodType) {
        this.returnType = methodType;


        switch(this.returnType) {
            case BOOL_TYPE:
                this.returnValue = new PseudoValue(true, "bool");
                setValidReturns(false);
                break;
            case INT_TYPE:
                this.returnValue = new PseudoValue(0, "int");
                setValidReturns(false);
                break;
            case FLOAT_TYPE:
                this.returnValue = new PseudoValue(0.0, "float");
                setValidReturns(false);
                break;
            case STRING_TYPE:
                this.returnValue = new PseudoValue("", "String");
                setValidReturns(false);
                break;
            case CHAR_TYPE:
                this.returnValue = new PseudoValue(0, "char");
                setValidReturns(false);
                break;
            default:
                break;
        }
    }

    public boolean hasValidReturns(){
        return this.hasValidReturns;
    }

    public void setValidReturns(boolean b) {
        hasValidReturns = b;
    }

    public MethodType getReturnType() {
        return this.returnType;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return this.methodName;
    }

//    public void mapParameterByValue(String... values) {
//        for(int i = 0; i < values.length; i++) {
//            PseudoValue pseudoValue = this.getParameterAt(i);
//            pseudoValue.setValue(values[i]);
//        }
//    }

    public void mapParameterByValueAt(String value, int index) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        PseudoValue pseudoValue = this.getParameterAt(index);
        pseudoValue.setValue(value);
    }

    public void mapArrayAt(PseudoValue pseudoValue, int index, String identifier) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        PseudoArray pseudoArray = (PseudoArray) pseudoValue.getValue();

        PseudoArray newArray = new PseudoArray(pseudoArray.getPrimitiveType(), identifier);
        PseudoValue newValue = new PseudoValue(newArray, "array");

        newArray.initializeSize(pseudoArray.getSize());

        for(int i = 0; i < newArray.getSize(); i++) {
            newArray.updateValueAt(pseudoArray.getValueAt(i), i);
        }

        this.parameterValues.put(this.getParameterKeyAt(index), pseudoValue);

    }

    public int getParameterValueSize() {
        return this.parameterValues.size();
    }

    public void verifyParameterByValueAt(PseudoCodeParser.ExpressionContext blkCtx, int index) {
        if(index >= this.parameterValues.size()) {
            return;
        }

        PseudoValue pseudoValue = this.getParameterAt(index);
        TypeChecker typeChecker = new TypeChecker(pseudoValue, blkCtx);
        typeChecker.verify();
    }

    public LinkedHashMap<String, PseudoValue> getParameterValues() {
        return parameterValues;
    }

    public void addParameter(String identifierString, PseudoValue pseudoValue) {
        this.parameterValues.put(identifierString, pseudoValue);
        System.out.println(this.methodName + " added an empty parameter " +identifierString+ " type " + pseudoValue.getPrimitiveType());
    }

    public boolean hasParameter(String identifierString) {
        return this.parameterValues.containsKey(identifierString);
    }

    public PseudoValue getParameter(String identifierString) {
        if(this.hasParameter(identifierString)) {
            return this.parameterValues.get(identifierString);
        }
        else {
            System.out.println("PseudoMethod - " + identifierString + " not found in parameter list");
            return null;
        }
    }

    public PseudoValue getParameterAt(int index) {
        int i = 0;

        for(PseudoValue pseudoValue : this.parameterValues.values()) {
            if(i == index) {
                return pseudoValue;
            }

            i++;
        }

        System.out.println("PseudoMethod - " + index + " has exceeded parameter list.");
        return null;
    }

    private String getParameterKeyAt(int index) {
        int i = 0;

        for(String key : this.parameterValues.keySet()) {
            if(i == index) {
                return key;
            }

            i++;
        }

        System.out.println("PseudoMethod - " + index + " has exceeded parameter list.");
        return null;
    }

    public PseudoValue getReturnValue() {
        if(this.returnType == MethodType.VOID_TYPE) {
            System.out.println(this.methodName + " is a void function. Null value is returned");
            return null;
        }
        else {
            return this.returnValue;
        }
    }

    @Override
    public void addCommand(ICommand command) {
        this.commandSequences.add(command);
        //Console.log("Command added to " +this.functionName);
    }

    public void execute() {
        ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
        MethodTracker.getInstance().reportEnterFunction(this);

        LocalVarTracker.getInstance().startNewSession();

        try {
            for(ICommand command : this.commandSequences) {
                executionMonitor.tryExecution();
                command.execute();

                LocalVarTracker.getInstance().populateLocalVars(command);

                if (command instanceof ReturnCommand) {
                    break;
                } else if (command instanceof IFCommand) {
                    if (((IFCommand) command).isReturned()) {
                        ((IFCommand) command).resetReturn();
                        break;
                    }
                }

                if (ExecutionManager.getInstance().isAborted())
                    break;
            }
        } catch(InterruptedException e) {
            System.out.println("PseudoMethod - " + "Monitor block interrupted! " +e.getMessage());
        }

        MethodTracker.getInstance().reportExitFunction();
        this.popBackParameters();
        this.popBackLocalVars();

        LocalVarTracker.getInstance().endCurrentSession();

        //LocalVarTracker.resetLocalVars(localVars);
    }

    private void popBackParameters() {
        for (PseudoValue bV : this.parameterValues.values()) {
//            if(bV.getPrimitiveType() != PseudoValue.PrimitiveType.ARRAY)
//                bV.popBack();
        }
    }

    private void popBackLocalVars() {
        for(String s : LocalVarTracker.getInstance().getCurrentSession()) {

            PseudoValue value = VariableSearcher.searchVariableInFunction(this, s);

            if (value != null) {

//                if (value.stackSize() > 1) { // prevent from reaching null
//                    if (value.getPrimitiveType() != PseudoValue.PrimitiveType.ARRAY)
//                        value.popBack();
//                }

            }

        }
    }

    @Override
    public ControlTypeEnum getControlType() {
        return ControlTypeEnum.FUNCTION_TYPE;
    }

    public static MethodType identifyFunctionType(String primitiveTypeString) {

        if(primitiveTypeString.equals("bool")) {
            return MethodType.BOOL_TYPE;
        }
//        else if(primitiveTypeString)) {
//            return MethodType.CHAR_TYPE;
//        }
        else if(primitiveTypeString.equals("float")) {
            return MethodType.FLOAT_TYPE;
        }
        else if(primitiveTypeString.equals("int")) {
            return MethodType.INT_TYPE;
        }
        else if(primitiveTypeString.equals("String")) {
            return MethodType.STRING_TYPE;
        }

        return MethodType.VOID_TYPE;
    }
}
