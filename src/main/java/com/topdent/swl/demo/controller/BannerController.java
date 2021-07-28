package com.topdent.swl.demo.controller;

import com.topdent.swl.demo.model.Banner;
import com.topdent.swl.demo.service.BannerService;
import com.topdent.swl.demo.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Blue_Sky 7/28/21
 */
@RestController
@RequestMapping("api/v1/banner")
@Api(tags = "Banner section", value = "banner controller")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ApiOperation("Banner list")
    @GetMapping("list")
    public JsonData list(){
        List<Banner> list = bannerService.list();
        return JsonData.buildSuccess(list);
    }
}
