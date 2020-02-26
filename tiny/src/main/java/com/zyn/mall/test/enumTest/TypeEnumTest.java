package com.zyn.mall.test.enumTest;

import org.junit.Test;

/**
 * @author zhaoyanan
 * @create 2020-02-26-9:19
 */
public class TypeEnumTest {

    @Test
    public void fun2(){
        TypeEnum2.ONE.setTypeName("改变的值one");
        String typeName = TypeEnum2.ONE.getTypeName();
        String value = TypeEnum2.ONE.getValue();
        System.out.println(typeName);
        System.out.println(value);

    }

    @Test
    public void fun1(){
        TypeEnum eum = TypeEnum.getFromTypeEum("third");
        System.out.println(TypeEnum.valueOf("ONE"));
        System.out.println(eum.getTypeName()+"-----"+eum.ordinal()+"-----"+eum.name());
    }
}
