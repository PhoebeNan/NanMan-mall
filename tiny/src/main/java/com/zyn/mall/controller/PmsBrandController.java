package com.zyn.mall.controller;

import com.zyn.mall.common.CommonResult;
import com.zyn.mall.mbg.model.PmsBrand;
import com.zyn.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhaoyanan
 * @create 2020-02-26-11:19
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("pmsBrand")
@CrossOrigin
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);

    //6.查询品牌列表，返回分页列表
    @ApiOperation("查询品牌列表，返回分页列表")
    @GetMapping("pageBrandList") //Integer pageNum; //当前页   Integer pageSize; //每页的数量
    public CommonResult<List<PmsBrand>> pageBrandList(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "1") @ApiParam("每页数量") Integer pageSize) {

        List<PmsBrand> commonResult = pmsBrandService.pageBrandList(pageNum, pageSize);
        return CommonResult.success(commonResult);
    }

    //5.删除品牌
    @ApiOperation("删除品牌")
    @DeleteMapping("deleteBrand/{brandId}")
    public CommonResult deleteBrand(@PathVariable long brandId) {

        String flag = "delete";
        int resCount = pmsBrandService.deleteBrand(brandId);
        return resCount(resCount, null, flag);
    }

    //4.修改品牌
    @ApiOperation("修改品牌")
    @PostMapping("updateBrand/{brandId}")
    public CommonResult updateBrand(@PathVariable long brandId, @RequestBody PmsBrand pmsBrand) {

        String flag = "update";
        int resCount = pmsBrandService.updateBrand(brandId, pmsBrand);
        return resCount(resCount, pmsBrand, flag);
    }

    //3.添加品牌
    @ApiOperation("添加品牌")
    @PostMapping("insertBrand")
    public CommonResult insertBrand(@RequestBody PmsBrand pmsBrand) {

        String flag = "insert";
        int resCount = pmsBrandService.insertBrand(pmsBrand);
        return resCount(resCount, pmsBrand, flag);
    }

    //2.通过id查询品牌
    @ApiOperation("通过id查询品牌")
    @GetMapping("getBrandById/{brandId}")
    public CommonResult<PmsBrand> getBrandById(@PathVariable long brandId) {

        PmsBrand pmsBrand = pmsBrandService.getBrandById(brandId);
        return CommonResult.success(pmsBrand);
    }

    //1.获取所有品牌列表
    @ApiOperation("获取所有品牌列")
    @GetMapping("getAllBrandList")
    public CommonResult<List<PmsBrand>> getAllBrandList() {

        List<PmsBrand> pmsBrandList = pmsBrandService.getAllBrandList();

        return CommonResult.success(pmsBrandList);
    }

    //封装操作数据库之后的返回结果代码
    private CommonResult resCount(int count, PmsBrand pmsBrand, String flag) {
        CommonResult commonResult = null;
        if (count == 1) {
            switch (flag) {
                case "isnert":
                    logger.debug("添加品牌成功:", pmsBrand);
                    commonResult = CommonResult.success(pmsBrand);
                    break;
                case "update":
                    logger.debug("修改品牌成功:", pmsBrand);
                    commonResult = CommonResult.success(pmsBrand);
                    break;
                case "delete":
                    logger.debug("删除品牌成功:", pmsBrand);
                    commonResult = CommonResult.success(pmsBrand);
                    break;
            }
        } else {
            logger.debug("操作失败:", pmsBrand);
            commonResult = CommonResult.failure();
        }
        return commonResult;
    }
}
