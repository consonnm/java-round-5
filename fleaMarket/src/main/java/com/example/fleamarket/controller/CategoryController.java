package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Category;
import com.example.fleamarket.entity.Collection;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.ICategoryService;
import com.example.fleamarket.service.ICollectionService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(value ="/catgory")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
    @ApiOperation("查询所有分类")
    @GetMapping("/getAllFollow")
    public ResultVo all(int current,int size){
        Page<Category> page = new Page<>(current,size);
        return new ResultVo().setData(iCategoryService.findByPage(page,null));
    }
    @RequiresRoles("admin")
    @ApiOperation("增加分类")
    @GetMapping("/insert")
    public ResultVo insert(String name){
        return new ResultVo().setData(iCategoryService.insert(name));
    }
    @RequiresRoles("admin")
    @ApiOperation("删除分类")
    @GetMapping("/remove")
    public ResultVo remove(int id){
        return new ResultVo().setData(iCategoryService.remove(id));
    }
}
