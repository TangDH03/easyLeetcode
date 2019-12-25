package com.tangdh.easyLeetcode.Enum;

public enum Type {
    INT{
        @Override
        public Class getClazz() {
            return int.class;
        }
    },
    STRING{
        @Override
        public Class getClazz() {
            return String.class;
        }
    },
    CHAR{
        @Override
        public Class getClazz() {
            return char.class;
        }
    },
    FLOAT{
        @Override
        public Class getClazz(){
            return float.class;
        }
    },
    DOUBLE{
        @Override
        public Class getClazz(){
            return double.class;
        }
    },
    ERROR{
        @Override
        public Class getClazz() {
            return null;
        }
    };




    public abstract Class getClazz();

    public static Type getType(String name){
        switch (name){
            case "int":
                return INT;
            case "string":
                return STRING;
            case "char":
                return CHAR;
            case "float":
                return FLOAT;
            case "double":
                return DOUBLE;
        }
        return ERROR;
    }
}
