package model.Utils;

import model.Item.PseudoValue;
import model.PseudoCodeLexer;

import java.math.BigDecimal;

public class AssignmentUtils {
    public static void assignAppropriateValue(PseudoValue pseudoValue, BigDecimal evaluationValue) {
        if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
            pseudoValue.setValue(Integer.toString(evaluationValue.intValue()));
        }
        else if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.FLOAT) {
            pseudoValue.setValue(Double.toString(evaluationValue.doubleValue()));
        }
        else if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN) {
            int result = evaluationValue.intValue();

            if(result == 1) {
                pseudoValue.setValue("T");
            }
            else {
                pseudoValue.setValue("F");
            }
        }
        else {
            System.out.println("AssignmentUtils: DID NOT FIND APPROPRIATE TYPE!!");
        }
    }

    public static void assignAppropriateValue(PseudoValue pseudoValue, String stringValue) {
        if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING ||
                pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.CHAR) {
            pseudoValue.setValue(stringValue);
        }
    }

    public static void assignAppropriateValue(PseudoValue pseudoValue, BigDecimal evaluationValue, int tokenSign) {
        if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
            int toAssignValue = evaluationValue.intValue();
            int finalValue = Integer.parseInt(pseudoValue.getValue().toString());

            if (tokenSign == PseudoCodeLexer.ADD) {
                finalValue += toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.SUB) {
                finalValue -= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.MUL) {
                finalValue *= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.DIV) {
                finalValue /= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.MOD) {
                finalValue %= toAssignValue;
            }

            pseudoValue.setValue(finalValue + "");
        }
        else if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.FLOAT) {
            pseudoValue.setValue(Double.toString(evaluationValue.doubleValue()));

            double toAssignValue = evaluationValue.intValue();
            double finalValue = Double.parseDouble(pseudoValue.getValue().toString());

            if (tokenSign == PseudoCodeLexer.ADD) {
                finalValue += toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.SUB) {
                finalValue -= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.MUL) {
                finalValue *= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.DIV) {
                finalValue /= toAssignValue;
            }
            else if (tokenSign == PseudoCodeLexer.MOD) {
                finalValue %= toAssignValue;
            }

            pseudoValue.setValue(finalValue + "");
        }
        /*else if(pseudoMethod.getPrimitiveType() == PseudoValue.PrimitiveType.BOOL) {
            int result = evaluationValue.intValue();

            if(result == 1) {
                pseudoMethod.setValue(RecognizedKeywords.BOOLEAN_TRUE);
            }
            else {
                pseudoMethod.setValue(RecognizedKeywords.BOOLEAN_FALSE);
            }
        }*/
    }

    public static void addAssignAppropriateValue(PseudoValue pseudoValue, String stringValue) {
        if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
            String toAddValue = stringValue;
            String originalValue = pseudoValue.getValue().toString();

            pseudoValue.setValue(toAddValue + originalValue);
        }
    }
}
