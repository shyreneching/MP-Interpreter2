package model.Item;

import model.Execution.ExecutionManager;

public class PseudoArray {

    private PseudoValue[] array;
    private PseudoValue.PrimitiveType arrayPrimitiveType;
    private String arrayIdentifier;
    private boolean finalFlag = false;

    public PseudoArray(PseudoValue.PrimitiveType primitiveType, String identifier) {
        this.arrayPrimitiveType = primitiveType;
        this.arrayIdentifier = identifier;
    }

    public void setPrimitiveType(PseudoValue.PrimitiveType primitiveType) {
        this.arrayPrimitiveType = primitiveType;
    }

    public PseudoValue.PrimitiveType getPrimitiveType() {
        return this.arrayPrimitiveType;
    }

    public void markFinal() {
        this.finalFlag = true;
    }

    public boolean isFinal() {
        return this.finalFlag;
    }

    public void initializeSize(int size) {
        try {
            this.array = new PseudoValue[size];
        } catch (NegativeArraySizeException ex) {
            this.array = null;

            //StatementControlOverseer.getInstance().setCurrentCatchClause(IAttemptCommand.CatchTypeEnum.NEGATIVE_ARRAY_SIZE);
            ExecutionManager.getInstance().setCurrentCatchType(IAttemptCommand.CatchTypeEnum.NEGATIVE_ARRAY_SIZE);
        }
        //System.out.println(TAG + ": Mobi array initialized to size " +this.baracoValueArray.length);
    }

    public int getSize() {
        return this.array.length;
    }

    public void updateValueAt(PseudoValue pseudoValue, int index) {
        if(index >= this.array.length || index <= -1) {
            //System.out.println("ERROR: " + String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
            ExecutionManager.getInstance().setCurrentCatchType(IAttemptCommand.CatchTypeEnum.ARRAY_OUT_OF_BOUNDS);

            return;
        }
        this.array[index] = pseudoValue;
    }

    public PseudoValue getValueAt(int index) {
        if(index >= this.array.length || index <= -1) {
//            System.out.println("ERROR: " + String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
            ExecutionManager.getInstance().setCurrentCatchType(IAttemptCommand.CatchTypeEnum.ARRAY_OUT_OF_BOUNDS);

            return null;
        }
        else {
            return this.array[index];
        }
    }

    public static PseudoArray createArray(String primitiveTypeString, String arrayIdentifier) {

        PseudoValue.PrimitiveType primitiveType = PseudoValue.PrimitiveType.NOT_YET_IDENTIFIED;

        if(primitiveTypeString.equals("bool"))
            primitiveType = PseudoValue.PrimitiveType.BOOL;
        else if(primitiveTypeString.equals("float")) {
            primitiveType = PseudoValue.PrimitiveType.FLOAT;
        }
        else if(primitiveTypeString.equals("int")) {
            primitiveType = PseudoValue.PrimitiveType.INT;
        }
        else if(primitiveTypeString.equals("String")) {
            primitiveType = PseudoValue.PrimitiveType.STRING;
        }

        PseudoArray pseudoArray = new PseudoArray(primitiveType, arrayIdentifier);

        return pseudoArray;
    }

}
