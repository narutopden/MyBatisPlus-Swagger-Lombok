package com.topdent.swl.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.topdent.swl.demo.mapper.BannerMapper;
import com.topdent.swl.demo.model.Banner;
import com.topdent.swl.demo.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Blue_Sky 7/28/21
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<Banner> list() {
        return bannerMapper.selectList(new QueryWrapper<>());
    }
}
