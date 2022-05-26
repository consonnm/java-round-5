package com.example.fleamarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fleamarket.entity.Announcement;
import com.example.fleamarket.response.ResultVo;
import com.example.fleamarket.service.IAnnouncementService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value ="/announcement")
public class AnnouncementController {
    @Autowired
    IAnnouncementService iAnnouncementService;
    @ApiOperation("查询所有公告")
    @GetMapping("/getAllAnnouncement")
    public ResultVo all(@ApiParam("当前页")int current,@ApiParam("大小") int size){
        log.info("查询所有公告");
        Page<Announcement> page = new Page<>(current, size );
        return new ResultVo().setData(iAnnouncementService.findByPage(page,null));
    }
    @RequiresRoles("admin")
    @ApiOperation("增加公告")
    @GetMapping("/insert")
    public ResultVo insert(@ApiParam("公告内容")String context,@ApiParam("公告主题")String topic,@ApiParam("公告时间") String time){
        log.info("增加公告");
        return new ResultVo().setData(iAnnouncementService.insert(context,topic,time));
    }
    @RequiresRoles("admin")
    @ApiOperation("删除公告")
    @GetMapping("/remove")
    public ResultVo remove(@ApiParam("公告id")int announcementId){
        log.info("删除公告");
        return new ResultVo().setData(iAnnouncementService.remove(announcementId));
    }
}
