package com.zyn.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.zyn.mall.mbg.mapper.PmsBrandMapper;
import com.zyn.mall.mbg.model.PmsBrand;
import com.zyn.mall.mbg.model.PmsBrandExample;
import com.zyn.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoyanan
 * @create 2020-02-26-11:20
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    //1.获取所有品牌列表
    @Override
    public List<PmsBrand> getAllBrandList() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    //2.通过id查询品牌
    @Override
    public PmsBrand getBrandById(long brandId) {

        return pmsBrandMapper.selectByPrimaryKey(brandId);
    }

    //3.添加品牌
    @Override
    public int insertBrand(PmsBrand pmsBrand) {

        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    //4.修改品牌
    @Override
    public int updateBrand(long brandId, PmsBrand pmsBrand) {

        pmsBrand.setId(brandId);
        return pmsBrandMapper.updateByPrimaryKey(pmsBrand);
    }

    //5.删除品牌
    @Override
    public int deleteBrand(long brandId) {

        return pmsBrandMapper.deleteByPrimaryKey(brandId);
    }

    //6.查询品牌列表，返回分页列表
    @Override
    public List<PmsBrand> pageBrandList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
}
