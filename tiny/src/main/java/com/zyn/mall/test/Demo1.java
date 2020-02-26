package com.zyn.mall.test;

import com.zyn.mall.common.ResultCode;
import org.junit.Test;

/**
 * @author zhaoyanan
 * @create 2020-02-26-8:09
 */
public class Demo1 {

    @Test
    public void demo2(){
        //ordinal返回枚举变量的序号
        for(ResultCode color: ResultCode.values()) {
            System.out.println(color+",ordinal:"+color.ordinal()+",name:"+color.name());
        }
    }

    @Test
   public void demo1(){
        A a = new B();
        a.result();
    }
}
