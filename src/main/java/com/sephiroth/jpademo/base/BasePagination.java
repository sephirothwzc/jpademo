package com.sephiroth.jpademo.base;

import com.sephiroth.jpademo.commtools.helper.StringHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
}
