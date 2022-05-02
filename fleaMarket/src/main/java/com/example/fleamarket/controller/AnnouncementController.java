package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Announcement;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IAnnouncementService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class AnnouncementController {
    @Autowired
    IAnnouncementService iAnnouncementService;
    @ApiOperation("查询所有公告")
    @GetMapping("/getAllAnnouncement")
    public ResultVo all(int current,int size){
        Page<Announcement> page = new Page<>(current, size );
        return new ResultVo().setData(iAnnouncementService.findByPage(page,null));
    }
    @RequiresRoles("admin")
    @ApiOperation("增加公告")
    @GetMapping("/insert")
    public ResultVo insert(String context){
        return new ResultVo().setData(iAnnouncementService.insert(context));
    }
    @RequiresRoles("admin")
    @ApiOperation("删除公告")
    @GetMapping("/remove")
    public ResultVo remove(int announcementId){
        return new ResultVo().setData(iAnnouncementService.remove(announcementId));
    }
}
