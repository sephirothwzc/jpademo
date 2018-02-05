package com.sephiroth.jpademo.controller;

import com.sephiroth.jpademo.entity.E_SysDatadictionaries;
import com.sephiroth.jpademo.jpadao.JPA_SysDatadictionaries;
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
    private JPA_SysDatadictionaries jpa_datadictionaries;

    /**
     *  @Author: 吴占超
     *  @Description: 获取列表数据
     *  @Date:  11:15 2018/2/4
     *  @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<E_SysDatadictionaries> e_datadictionariesList() {
        return jpa_datadictionaries.findAll();
    }

    /**
     *  @Author: 吴占超
     *  @Description: 保存
     *  @Date:  11:16 2018/2/4
     *  @param entity
     *  @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public E_SysDatadictionaries save(E_SysDatadictionaries entity) {
        return jpa_datadictionaries.save(entity);
    }

    @RequestMapping(value = "/delete")
    public List<E_SysDatadictionaries> delete(String id) {
        jpa_datadictionaries.delete(id);
        return jpa_datadictionaries.findAll();
    }
}
