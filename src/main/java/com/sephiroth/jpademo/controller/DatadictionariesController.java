package com.sephiroth.jpademo.controller;

import com.sephiroth.jpademo.entity.EntitySysDatadictionaries;
import com.sephiroth.jpademo.jpadao.JpaSysDatadictionaries;
import com.sephiroth.jpademo.service.ServiceSysDatadictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 10:36 2018/2/4
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/datadictionaries")
public class DatadictionariesController {

    @Autowired
    private ServiceSysDatadictionaries serviceSysDatadictionaries;

    /**
     *  @Author: 吴占超
     *  @Description: 获取列表数据
     *  @Date:  11:15 2018/2/4
     *  @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<EntitySysDatadictionaries> e_datadictionariesList() {
        return serviceSysDatadictionaries.findAll();
    }

    /**
     *  @Author: 吴占超
     *  @Description: 保存
     *  @Date:  11:16 2018/2/4
     *  @param entity
     *  @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public EntitySysDatadictionaries save(EntitySysDatadictionaries entity) {
        return serviceSysDatadictionaries.save(entity);
    }

    @RequestMapping(value = "/delete")
    public List<EntitySysDatadictionaries> delete(String id) {
        serviceSysDatadictionaries.delete(id);
        return serviceSysDatadictionaries.findAll();
    }
}
