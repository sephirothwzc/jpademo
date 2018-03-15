package com.sephiroth.jpademo.base;

import com.sephiroth.jpademo.base.jpa.BaseEntity;
import com.sephiroth.jpademo.base.jpa.BaseJpaRepository;
import com.sephiroth.jpademo.base.jpa.BasePagination;
import javafx.util.Pair;
import lombok.val;
import org.springframework.data.domain.PageRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 13:56 2018/2/15
 * @Modified By:
 */
public abstract class BaseService<T extends BaseEntity> {
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
    public Pair<List<T>,Long> cutPage(BasePagination pagination) {
        PageRequest pageRequest = pagination.getPageRequest();
        val page = getBaseJpaRepository().findAll(pagination.<T>getSpec(),pageRequest);
        return new Pair<List<T>,Long>(page.getContent(),page.getTotalElements());
    }

    public List<T> findAll() {
        return getBaseJpaRepository().findAll();
    }

    /**
     *  @Author: 吴占超
     *  @Description: 根据主键获取
     *  @Date:  10:51 2018/3/8
     *  @param id
     */
    public T findOne(String id) { return (T)getBaseJpaRepository().findOne(id); }

    /**
     *  @Author: 吴占超
     *  @Description: 保存 根据主键判断是否新增
     *  @Date:  14:33 2018/2/15
     *  @param item
     *  @return
     */
    public T save(T item) {
        if(item.getId()!=null) {
            item.setCreatedate(new Timestamp(System.currentTimeMillis()));
            item.setEnableflag("1");
        }
        item.setUpdatedate(new Timestamp(System.currentTimeMillis()));
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

    public void delete(String id) {
        getBaseJpaRepository().delete(id);
    }

    public void delete(List<String> listid) {
        val entitys = listid.stream().map(p-> this.defaultT(p)).collect(Collectors.toList());
        getBaseJpaRepository().deleteInBatch(entitys);
    }

    /**
     *  @Author: 吴占超
     *  @Description: 创建当前泛型对象实例
     *  @Date:  15:40 2018/3/15
     *
     */
    private T defaultT(String id) {
        try{
            ParameterizedType st = (ParameterizedType)this.getClass().getGenericSuperclass();
            Type tArgs = st.getActualTypeArguments()[0];
            Class myclass = Class.forName(tArgs.getTypeName());
            val temp = (T)myclass.newInstance();
            temp.setId(id);
            return temp;
        } catch (Exception e){
            return null;
        }
    }
}
