package model.Item;

public class PseudoValue {

    public enum PrimitiveType {
        NOT_YET_IDENTIFIED,
        BOOLEAN,
        CHAR,
        INT,
//        BYTE,
//        SHORT,
//        LONG,
        FLOAT,
        DOUBLE,
        STRING
//        ARRAY
    }

    private Object value;
    private PrimitiveType type = PrimitiveType.NOT_YET_IDENTIFIED;
    private boolean constFlag = false;

    public PseudoValue(Object value, String primitiveType){
        PrimitiveType pt = convert(primitiveType);

        if(checkType(value, pt)){
            this.value = value;
            this.type = pt;
        }else {
            System.out.println("Mismatched type error");
        }
    }

    public static PrimitiveType convert(String primitiveType){
        switch (primitiveType.toLowerCase()){
            case "bool":
                return PrimitiveType.BOOLEAN;
            case "char":
                return PrimitiveType.CHAR;
            case "int":
                return PrimitiveType.INT;
//            case "byte":
//                return PrimitiveType.BYTE;
//            case "short":
//                return PrimitiveType.SHORT;
//            case "long":
//                return PrimitiveType.LONG;
            case "float":
                return PrimitiveType.FLOAT;
            case "double":
                return PrimitiveType.DOUBLE;
            case "String":
                return PrimitiveType.STRING;
//            case "array":
//                return PrimitiveType.ARRAY;
            default:
                return PrimitiveType.NOT_YET_IDENTIFIED;
        }

    }

    public boolean checkType(Object value, PrimitiveType primitiveType) {
        switch (primitiveType) {
            case BOOLEAN:
                return value instanceof Boolean;
            case CHAR:
                return value instanceof Character;
            case INT:
                return value instanceof Integer;
//            case BYTE:
//                return value instanceof Byte;
//            case SHORT:
//                return value instanceof Short;
//            case LONG:
//                return value instanceof Long;
            case FLOAT:
                return value instanceof Float;
            case DOUBLE:
                return value instanceof Double;
            case STRING:
                return value instanceof String;
//            case ARRAY:
//                return value instanceof Object;
            default:
                return false;
        }
    }

    public void setPrimitiveType(PrimitiveType type) {
        this.type = type;
    }

    public void reset() {
        this.value = null;
    }

    public void makeConst() {
        this.constFlag = true;
    }

    public boolean isConst() {
        return this.constFlag;
    }

    public void setValue(String value) {

        if(this.type == PrimitiveType.NOT_YET_IDENTIFIED) {
            System.out.println("Primitive type not yet identified!");
        }
        else if(this.type == PrimitiveType.STRING) {
            value.replace("\"", "");

            this.value = value.replace("\"", "");
        }
//        else if(this.type == PrimitiveType.ARRAY) {
//            System.out.println(this.primitiveType + " is an array. Cannot directly change value.");
//        }
        else {
            //attempts to type cast the value
            this.value = this.attemptTypeCast(value);
        }
    }

    private Object attemptTypeCast(String value) {
        switch(this.type) {
            case CHAR: return Character.valueOf(value.charAt(0));
            case BOOLEAN: return Boolean.valueOf(value);
            case INT:
                String s = value;

                if(s.contains(".")) {
                    String[] split = s.split("[.]");
                    return Integer.valueOf(split[0]);
                } else {
                    return Integer.valueOf(value);
                }
            case FLOAT:
                String str = value;

                if(str.contains("f")){
                    return Double.valueOf(str.substring(0, str.length() - 1));
//                } else {
//                    return Double.valueOf(value);
                }
            case DOUBLE: return Double.valueOf(value);
            case STRING: return value;
            default: return null;
        }
    }

    public Object getValue() {
        return this.value;
    }

    public PrimitiveType getPrimitiveType() {
        return this.type;
    }

    public static PseudoValue createEmptyVariable(String primitiveType) {
        PseudoValue pseudoValue = new PseudoValue(null, primitiveType);

        return pseudoValue;
    }
}
