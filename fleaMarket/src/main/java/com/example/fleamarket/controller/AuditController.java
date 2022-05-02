package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Announcement;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IAnnouncementService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class AuditController {
    @Autowired
    IAnnouncementService iAnnouncementService;
    @RequiresRoles("admin")
    @ApiOperation("查询所有审核记录")
    @GetMapping("/getAllAudit")
    public ResultVo all(int current,int size){
        Page<Announcement> page = new Page<>(current ,size );
        return new ResultVo().setData(iAnnouncementService.findByPage(page,null));
    }
    @RequiresRoles("admin")
    @ApiOperation("增加审核记录")
    @GetMapping("/insert")
    public ResultVo insert(String context){
        return new ResultVo().setData(iAnnouncementService.insert(context));
    }
}
