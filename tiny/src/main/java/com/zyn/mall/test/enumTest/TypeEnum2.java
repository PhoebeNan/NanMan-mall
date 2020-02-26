package com.zyn.mall.test.enumTest;

/**
 * @author zhaoyanan
 * @create 2020-02-26-9:10
 */
public enum TypeEnum2 {

    ONE("one","1"),
    TWO("two","2"),
    THIRD("third","3");

    private String typeName;
    private String value;

    TypeEnum2(String typeName,String value){
        this.typeName = typeName;
        this.value = value;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

