package com.sephiroth.jpademo.service;

import com.sephiroth.jpademo.base.BasePagination;
import com.sephiroth.jpademo.entity.EntitySysUser;
import com.sephiroth.jpademo.jpadao.JpaSysUser;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description: 用户服务
 * @Date: Create in 17:14 2018/2/11
 * @Modified By:
 */
@Service
public class ServiceSysUser {

    @Autowired
    private JpaSysUser jpaSysUser;

    /**
     *  @Author: 吴占超
     *  @Description: 用户分页管理
     *  @Date:  17:18 2018/2/11
     *
     */
    public Pair<List<EntitySysUser>,Long> cutPage(BasePagination param) {
        PageRequest pageRequest = param.getPageRequest();
        //执行分页
        Page page = jpaSysUser.findAll(pageRequest);
        return new Pair<List<EntitySysUser>,Long>(page.getContent(),page.getTotalElements());
    }
}
