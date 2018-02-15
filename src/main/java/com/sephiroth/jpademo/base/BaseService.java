package com.sephiroth.jpademo.base;

import com.sephiroth.jpademo.entity.EntitySysUser;
import javafx.util.Pair;
import lombok.val;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 13:56 2018/2/15
 * @Modified By:
 */
public abstract class BaseService<T> {
    // entity   T
    // jpa      虚方法

    /**
     *  @Author: 吴占超
     *  @Description: 虚方法 获取当前对象jpa
     *  @Date:  14:27 2018/2/15
     *
     */
    public abstract BaseJpaRepository getBaseJpaRepository();

    /**
     *  @Author: 吴占超
     *  @Description: 条件分页
     *  @Date:  14:29 2018/2/15
     *  @param pagination
     *  @return
     */
    public Pair<List<T>,Long> cutPageCustomer(BasePagination pagination) {
        PageRequest pageRequest = pagination.getPageRequest();
        val page = getBaseJpaRepository().findAll(pagination.<T>getSpec(),pageRequest);
        return new Pair<List<T>,Long>(page.getContent(),page.getTotalElements());
    }

    /**
     *  @Author: 吴占超
     *  @Description: 保存 根据主键判断是否新增
     *  @Date:  14:33 2018/2/15
     *  @param item
     *  @return
     */
    public T save(T item) {
        return (T)getBaseJpaRepository().save(item);
    }

    /**
     *  @Author: 吴占超
     *  @Description: 根据对象删除
     *  @Date:  14:35 2018/2/15
     *  @param item
     *
     */
    public void delete(T item) {
        getBaseJpaRepository().delete(item);
    }
}
