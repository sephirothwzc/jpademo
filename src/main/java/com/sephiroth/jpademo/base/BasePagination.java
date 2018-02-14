package com.sephiroth.jpademo.base;

import com.github.wenhao.jpa.Specifications;
import com.sephiroth.jpademo.commtools.helper.StringHelper;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * @Author: 吴占超
 * @Description:
 * @Date: Create in 16:20 2018/2/11
 * @Modified By:
 */
@Data
public class BasePagination {

    // 页面大小 默认10
    public int pageSize = 10;

    // 页码 默认-1 显示所有 不分页
    public int pageNumber = -1;

    // 排序字段
    public String sortName;

    // asc desc
    public String sortOrder;

    /**
     *  @Author: 吴占超
     *  @Description: 获取排序
     *  @Date:  21:44 2018/2/11
     *
     */
    public Sort getSort() {
        Sort sort = new Sort(Sort.Direction.ASC.equals(this.sortOrder)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC,this.getSortName());
        return sort;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 获取分页对象
     *  @Date:  22:49 2018/2/11
     *
     */
    public PageRequest getPageRequest() {
        PageRequest pageRequest = null; // 没分页没排序
        if(!StringHelper.IsNullOrEmpty(this.getSortName()) &&
                this.getPageNumber() > -1) {
            // 有分页有排序
            pageRequest = new PageRequest(this.getPageNumber()-1
                    ,this.getPageSize()
                    ,this.getSort());
        } else if (this.getPageNumber() > -1) {
            // 有分页没排序
            pageRequest = new PageRequest(this.getPageNumber()-1
                    ,this.getPageSize());
        }
        return pageRequest;
    }

    /**
     *  @Author: 吴占超
     *  @Description: 获取当前自定义对象的动态查询条件
     *  @Date:  11:53 2018/2/14
     *
     */
    public  <T> Specification<T> getSpec() {
        val pros = this.getClass().getFields();
        val fields = Arrays.asList(pros);
        val sp = Specifications.<T>and();
        fields.forEach(p->{
            val rptemp = p.getAnnotation(RetentionPagination.class);
            if(rptemp == null) return;
            try{
                Object ovalue = p.get(this);
                String fieldname = rptemp.field();
                if(StringUtils.isEmpty(fieldname)) fieldname = p.getName();
                if(ovalue != null && !StringUtils.isEmpty(ovalue)){
                    switch (rptemp.scpeEnum()){
                        case like:
                            sp.like(fieldname,"%"+ovalue.toString()+"%");
                            break;
                        case notLike:
                            sp.notLike(fieldname,ovalue.toString());
                            break;
                        case eq:
                            sp.eq(fieldname,ovalue);
                            break;
                        case gt:
                            sp.gt(Objects.nonNull(ovalue),fieldname,ovalue.toString());
                            break;
                        case lt:
                            sp.lt(Objects.nonNull(ovalue),fieldname,ovalue.toString());
                            break;
                        case in:
                            if(p.getType() == String.class)
                                sp.in(Objects.nonNull(ovalue),fieldname,ovalue.toString().split(","));
                            else
                                sp.in(Objects.nonNull(ovalue),fieldname,ovalue);
                            break;
                        case notIn:
                            if(p.getType() == String.class)
                                sp.notIn(Objects.nonNull(ovalue),fieldname,ovalue.toString().split(","));
                            else
                                sp.notIn(Objects.nonNull(ovalue),fieldname,ovalue);
                            break;
                        case between:

                    }
                }
            }catch (Exception e) {

            }
        });
        return sp.build();
    }
}
