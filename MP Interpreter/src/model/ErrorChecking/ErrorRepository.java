package model.ErrorChecking;

import java.util.HashMap;

public class ErrorRepository {

    public final static int INCONSISTENT_CLASS_NAME = 1000;
    public final static int TYPE_MISMATCH = 2000;
    public final static int UNDECLARED_VARIABLE = 3000;
    public final static int UNDECLARED_FUNCTION = 3500;
    public final static int CONST_REASSIGNMENT = 3100;
    public final static int MULTIPLE_VARIABLE = 5000;
    public final static int MULTIPLE_FUNCTION = 5500;
    public final static int PARAMETER_COUNT_MISMATCH = 6000;
    public final static int RUNTIME_ARRAY_OUT_OF_BOUNDS = 7000;
//    public final static int RUNTIME_NEGATIVE_ARRAY_SIZE = 7001;
//    public final static int RUNTIME_ARITHMETIC_EXCEPTION = 7002;
    public final static int MISSING_THIS_KEYWORD = 8000;
    public final static int INVALID_INDEX_ASSIGN = 9001;
    public final static int NO_RETURN_STATEMENT = 9002;
    public final static int NOT_A_STATEMENT = 9004;
    public final static int RETURN_IN_VOID = 9000;


    private static ErrorRepository sharedInstance = null;

    private HashMap<Integer, String> errorMessageDictionary;

    private ErrorRepository() {
        this.errorMessageDictionary = new HashMap<>();
        this.populateErrorMessages();
    }

    private void populateErrorMessages() {
        this.errorMessageDictionary.put(ErrorRepository.INCONSISTENT_CLASS_NAME, "Inconsistent class name. ");
        this.errorMessageDictionary.put(TYPE_MISMATCH, "Type mismatch at line %d. ");
        this.errorMessageDictionary.put(UNDECLARED_VARIABLE, "Undeclared variable %s at line %d. ");
        this.errorMessageDictionary.put(UNDECLARED_FUNCTION, "Undeclared function %s at line %d. ");
        this.errorMessageDictionary.put(CONST_REASSIGNMENT, "Constant %s can no longer reassign a new value at line %d.");
        this.errorMessageDictionary.put(MULTIPLE_VARIABLE, "Duplicate declaration of variable %s at line %d. ");
        this.errorMessageDictionary.put(MULTIPLE_FUNCTION, "Duplicate method declaration %s at line %d. ");
        this.errorMessageDictionary.put(PARAMETER_COUNT_MISMATCH, "Argument size for method call %s at line %d does not match with its declaration. ");
//        this.errorMessageDictionary.put(RUNTIME_ARRAY_OUT_OF_BOUNDS, "Array out of bounds at line %d. Aborting operation. ");
//        this.errorMessageDictionary.put(RUNTIME_ARITHMETIC_EXCEPTION, "Arithmetic exception at line %d. Aborting operation. ");
//        this.errorMessageDictionary.put(RUNTIME_NEGATIVE_ARRAY_SIZE, "Negative array size at line %d. Aborting operation. ");
        this.errorMessageDictionary.put(MISSING_THIS_KEYWORD, "Missing 'this' keyword for method call %s line %d.");
        this.errorMessageDictionary.put(RETURN_IN_VOID, "You can't return a value in a void function at line %d.");
        this.errorMessageDictionary.put(INVALID_INDEX_ASSIGN, "Invalid index in array assignment at line %d.");
        this.errorMessageDictionary.put(NO_RETURN_STATEMENT, "No return statement in function %s at line %d.");
        this.errorMessageDictionary.put(NOT_A_STATEMENT, "%s is not a statement at line %d.");
    }

    public static String getErrorMessage(int errorCode) {
        return sharedInstance.errorMessageDictionary.getOrDefault(errorCode, "Error code "+errorCode+ " not found.");
    }

    public static void initialize() {
        sharedInstance = new ErrorRepository();
    }

    public static void reset() {
        sharedInstance.errorMessageDictionary.clear();
        sharedInstance.populateErrorMessages();
    }

}
