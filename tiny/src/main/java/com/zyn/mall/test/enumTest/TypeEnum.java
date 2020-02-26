package com.zyn.mall.test.enumTest;

/**
 * @author zhaoyanan
 * @create 2020-02-26-9:10
 */
public enum TypeEnum {

    ONE("one"),
    TWO("two"),
    THIRD("third");

    private String typeName;

    TypeEnum(String typeName){
        System.out.println("jvm加载枚举类");
        this.typeName = typeName;
    }

    /**
     * 根据传入的类型名称，返回类型的枚举实例
     */
    public static TypeEnum getFromTypeEum(String typeName){

        for (TypeEnum typeEnum : TypeEnum.values()) {
            if(typeEnum.getTypeName().equals(typeName)){
                return typeEnum;
            }
        }
        return null;
    }

    public String getTypeName(){
        return this.typeName;
    }
}

