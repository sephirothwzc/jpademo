package com.sephiroth.jpademo.controller;

import com.sephiroth.jpademo.base.BaseResult;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.model.SysUser.InCutUsePage;
import com.sephiroth.jpademo.model.SysUser.InManagerSysUser;
import com.sephiroth.jpademo.retention.RetentionPagination;
import com.sephiroth.jpademo.service.ServiceSysUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 17:41 2018/2/11
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/SysUser")
@Validated
public class SysUserController {

    @Autowired
    private ServiceSysUser serviceSysUser;

    @RequestMapping(value = "/manager")
    public BaseResult cutUserPage(@Valid InManagerSysUser param) {
        val pair = serviceSysUser.cutPage(param);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(new Runnable(){
            public List<EntitySysUser> rows = pair.getKey();
            public Long total = pair.getValue();
            public void run(){
            }
        });
        return baseResult;
    }

    @RequestMapping(value = "/item")
    public BaseResult item(String id) {
        return new BaseResult(serviceSysUser.findOne(id));
    }

    @RequestMapping(value = "/del")
    public BaseResult del(List<String> param) {
        serviceSysUser.delete(param);
        return new BaseResult(param.size());
    }

    @RequestMapping(value = "save")
    public BaseResult save(@Valid EntitySysUser param) {
        return new BaseResult(serviceSysUser.save(param));
    }
}
