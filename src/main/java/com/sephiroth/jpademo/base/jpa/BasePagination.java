package com.sephiroth.jpademo.base.jpa;

import com.github.wenhao.jpa.Specifications;
import com.sephiroth.jpademo.commtools.helper.StringHelper;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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
     * @Author: 吴占超
     * @Description: 获取排序
     * @Date: 21:44 2018/2/11
     */
    public Sort getSort() {
        Sort sort = new Sort(Sort.Direction.ASC.equals(this.sortOrder)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC, this.getSortName());
        return sort;
    }

    /**
     * @Author: 吴占超
     * @Description: 获取分页对象
     * @Date: 22:49 2018/2/11
     */
    public PageRequest getPageRequest() {
        PageRequest pageRequest = null; // 没分页没排序
        if (!StringHelper.IsNullOrEmpty(this.getSortName()) &&
                this.getPageNumber() > -1) {
            // 有分页有排序
            pageRequest = new PageRequest(this.getPageNumber() - 1
                    , this.getPageSize()
                    , this.getSort());
        } else if (this.getPageNumber() > -1) {
            // 有分页没排序
            pageRequest = new PageRequest(this.getPageNumber() - 1
                    , this.getPageSize());
        }
        return pageRequest;
    }

    /**
     * @Author: 吴占超
     * @Description: 获取当前自定义对象的动态查询条件
     * @Date: 11:53 2018/2/14
     */
    public <T> Specification<T> getSpec() {
        val pros = this.getClass().getFields();
        val fields = Arrays.asList(pros);
        val sp = Specifications.<T>and();
        fields.stream()
                .map(p -> {
                    FieldSuper fs = new FieldSuper();
                    try {
                        fs.setRptemp(p.getAnnotation(RetentionPagination.class));
                        fs.setOvalue(p.get(this));
                        fs.setClassSimpleName(p.getType().getSimpleName());
                        if (fs.getRptemp() != null) {
                            fs.setFieldname(StringUtils.isEmpty(fs.getRptemp().field()) ? p.getName() : fs.getRptemp().field());
                        }
                    } catch (Exception e) {
                    } finally {
                        return fs;
                    }
                })
                .filter(p -> p.getRptemp() != null && p.getOvalue() != null && !StringUtils.isEmpty(p.getOvalue()))
                .forEach(p -> {
                    switch (p.getRptemp().scpeEnum()) {
                        case like:
                            sp.like(p.getFieldname(), "%" + p.getOvalue().toString() + "%");
                            break;
                        case notLike:
                            sp.notLike(p.getFieldname(), "%" + p.getOvalue().toString() + "%");
                            break;
                        case eq:
                            sp.eq(p.getFieldname(), p.getOvalue());
                            break;
                        case gt:
                            sp.gt(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString());
                            break;
                        case lt:
                            sp.lt(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString());
                            break;
                        case gteq:
                            sp.gt(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString());
                            sp.eq(p.getFieldname(), p.getOvalue());
                            break;
                        case lteq:
                            sp.lt(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString());
                            sp.eq(p.getFieldname(), p.getOvalue());
                            break;
                        case in:
                            if (p.getClassSimpleName() == String.class.getSimpleName())
                                sp.in(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString().split(","));
                            else
                                sp.in(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue());
                            break;
                        case notIn:
                            if (p.getClassSimpleName() == String.class.getSimpleName())
                                sp.notIn(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue().toString().split(","));
                            else
                                sp.notIn(Objects.nonNull(p.getOvalue()), p.getFieldname(), p.getOvalue());
                            break;
                    }
                });

        return sp.build();
    }

    @Data
    private class FieldSuper {
        /**
         * @Author: 吴占超
         * @Description: 条件用 对象 属性字段名
         * @Date: 16:53 2018/3/12
         */
        public String fieldname;

        /**
         * @Author: 吴占超
         * @Description: 属性值
         * @Date: 16:55 2018/3/12
         */
        public Object ovalue;

        /**
         * @Author: 吴占超
         * @Description: 属性类名称
         * @Date: 16:57 2018/3/12
         */
        public String classSimpleName;

        /**
         * @Author: 吴占超
         * @Description: 判断用条件注解对象
         * @Date: 16:57 2018/3/12
         */
        public RetentionPagination rptemp;

    }
}
