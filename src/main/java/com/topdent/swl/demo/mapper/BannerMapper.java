package com.topdent.swl.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.topdent.swl.demo.model.Banner;

import java.util.List;

/**
 * @author Blue_Sky 7/28/21
 */
public interface BannerMapper extends BaseMapper<Banner> {
    List<Banner> listBanner();
}
