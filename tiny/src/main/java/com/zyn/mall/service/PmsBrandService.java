package com.zyn.mall.service;

import com.zyn.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author zhaoyanan
 * @create 2020-02-26-11:19
 */
public interface PmsBrandService {

    /**
     * 获取所有品牌列表
     * @return
     */
    List<PmsBrand> getAllBrandList();

    /**
     * 通过id查询品牌
     * @param brandId
     * @return
     */
    PmsBrand getBrandById(long brandId);

    /**
     * 添加品牌
     * @param pmsBrand
     * @return
     */
    int insertBrand(PmsBrand pmsBrand);

    /**
     * 修改品牌
     * @param brandId
     * @param pmsBrand
     * @return
     */
    int updateBrand(long brandId, PmsBrand pmsBrand);

    /**
     * 删除品牌
     * @param brandId
     * @return
     */
    int deleteBrand(long brandId);

    /**
     * //6.查询品牌列表，返回分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> pageBrandList(Integer pageNum, Integer pageSize);
}
