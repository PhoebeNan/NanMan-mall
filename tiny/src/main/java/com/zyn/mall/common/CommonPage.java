package com.zyn.mall.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 封装分页相关数据
 *
 * @author zhaoyanan
 * @create 2020-02-26-10:26
 */
@Data
public class CommonPage<T> {

    private Integer pageNum; //当前页
    private Integer pageSize; //每页的数量
    private Integer totalPage; //总页数
    private Long total; //总记录数
    private List<T> list; //结果集

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
}
