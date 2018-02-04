package com.sephiroth.jpademo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: 吴占超
 * @Description: 数据字典
 * @Date: Create in 10:42 2018/2/4
 * @Modified By:
 */

@Entity
@Table(name = "sys_datadictionaries")
public class E_datadictionaries implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "createtime")
    private Timestamp createtime;

    @Column
    private Timestamp updatetime;

    @Column
    private String createby;

    @Column
    private String updateby;

    @Column
    private String enableflag;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String pid;

    @Column
    private String remark;

    @Column
    private String value;

    @Column
    private String sortnum;

    @Column
    private String displaytxt;

    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false, length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSortnum() {
        return sortnum;
    }

    public void setSortnum(String sortnum) {
        this.sortnum = sortnum;
    }

    public String getDisplaytxt() {
        return displaytxt;
    }

    public void setDisplaytxt(String displaytxt) {
        this.displaytxt = displaytxt;
    }

    public String getEnableflag() {
        return enableflag;
    }

    public void setEnableflag(String enableflag) {
        this.enableflag = enableflag;
    }
}
