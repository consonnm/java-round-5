package com.example.fleamarket.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.fleamarket.entity.Goods;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IGoodService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value ="/good")
public class GoodController {
    @Autowired
    IGoodService iGoodService;
    @ApiOperation("模糊查询商品")
    @GetMapping("/getGood")
    public ResultVo list(@ApiParam("商品名称") String goodName){
        log.info("模糊查询商品");
        return new ResultVo().setData(iGoodService.list(new LambdaQueryWrapper<Goods>()
                .like(Goods::getGoodName,goodName))
        );
    }
    @ApiOperation("查询所有商品")
    @GetMapping("/getAllGood")
    public ResultVo all(){
        log.info("查询所有商品");
        return new ResultVo().setData(iGoodService.list()
        );
    }
    @ApiOperation("根据类别查询商品")
    @GetMapping("/getGoodBySort")
    public ResultVo sort(@ApiParam("商品类别") String goodSort){
        log.info("根据类别查询商品");
        return new ResultVo().setData(iGoodService.list(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getGoodSort,goodSort))
        );
    }
    @ApiOperation("根据id查询商品的详细信息")
    @GetMapping("/getGoodById")
    public ResultVo list(@ApiParam("商品id") int goodId){
        log.info("根据id查询商品的详细信息");
        return new ResultVo().setData(iGoodService.queryById(goodId));
    }
    @ApiOperation("商品基础信息修改")
    @GetMapping("/baseMessageUpdate")
    public ResultVo baseUpdate(String goodName,String summary,String detail){
        log.info("商品基础信息修改");
        return new ResultVo().setData(iGoodService.update(goodName,summary,detail));
    }
    @ApiOperation("查询所有未审核商品")
    @GetMapping("/select")
    public ResultVo select(){
        log.info("查询所有未审核商品");
        return new ResultVo().setData(iGoodService.list(new LambdaQueryWrapper<Goods>()
                .eq(Goods::getApproved,false))
        );
    }
    @ApiOperation("商品图片修改接口")
    @GetMapping("/photoUpdate")
    public ResultVo photoUpdate(MultipartFile file,int goodId){
        log.info("商品图片修改接口");
        return new ResultVo().setData(iGoodService.updatePhoto(file,goodId));
    }
}
