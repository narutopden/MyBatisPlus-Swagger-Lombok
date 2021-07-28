package com.topdent.swl.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.topdent.swl.demo.mapper.BannerMapper;
import com.topdent.swl.demo.model.Banner;
import com.topdent.swl.demo.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerMapper bannerMapper;
    @Test
    public void contextLoads() {
        List<Banner> list = bannerService.list();
        log.info("the list of data:{}",list);
    }
    @Test
    public void selectById(){
        Banner banner = bannerMapper.selectById(1);
        log.info("this is select by id: {}",banner);
    }

    @Test
    public void selectByIds(){
        List<Banner> list = bannerMapper.selectBatchIds(Arrays.asList(1,2,3));
        log.info("this is select by id: {}",list);
    }

    @Test
    public void selectWrapper(){
        List<Banner> list = bannerMapper.selectList(new QueryWrapper<Banner>().eq("id",1));
        log.info("this is select by id: {}",list);
    }

    @Test
    public void deleteById(){
        int flage = bannerMapper.deleteById(12);
        log.info("deletion :{}",flage);
    }

    @Test
    public void deleteByMapper(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",11);
        map.put("img",532);
        int flage = bannerMapper.deleteByMap(map);
        log.info("deletion :{}",flage);
    }

    @Test
    public void testPage(){
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("weight",4);
        // 1st page and 3 rows of data
        Page<Banner> page = new Page<>(3,3);
        Page<Banner> bannerPage = bannerMapper.selectPage(page, null);
        log.info("total data :{}",bannerPage.getTotal());
        log.info("page records on current page :{}",bannerPage.getRecords());
        log.info("page num :{}",bannerPage.getCurrent());
        log.info("total pages :{}",bannerPage.getCurrent());
    }

    @Test
    public void listBannerSql(){
        List<Banner> list = bannerMapper.listBanner();
        log.info("the is data from sql mapper: {}",list);
    }

    /**
     * to select specific columns from db
     */
    @Test
    public void selectColumn(){
        List<Banner> list = bannerMapper.selectList(new QueryWrapper<Banner>().select("id","img"));
        log.info("specifig culoum : {}",list);

    }

    @Test
    public void optimisticLock(){
        Banner banner = new Banner();
        banner.setVersion(1);
        banner.setId(1);

        banner.setUrl("zzzzzkkk.com");
        bannerMapper.updateById(banner);
    }

    @Test
    public void deletedMark(){
        bannerMapper.deleteById(1);
    }
}
