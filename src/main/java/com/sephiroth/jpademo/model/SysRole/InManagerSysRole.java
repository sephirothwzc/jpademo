package com.sephiroth.jpademo.model.SysRole;


import com.sephiroth.jpademo.base.jpa.BasePagination;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class InManagerSysRole  extends BasePagination {

  @RetentionPagination
  public String id;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.ge)
  public java.sql.Timestamp createdate;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.le)
  public java.sql.Timestamp createdate1;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.ge)
  public java.sql.Timestamp updatedate;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.le)
  public java.sql.Timestamp updatedate1;

  @RetentionPagination
  public String createby;

  @RetentionPagination
  public String updateby;

  @RetentionPagination
  public String enableflag;

  @RetentionPagination
  public String bdcode;

  @RetentionPagination
  public String companyno;

  @RetentionPagination
  public String roleCode;

  @RetentionPagination
  public String roleName;

  @RetentionPagination
  public String remark;

  @RetentionPagination
  public String pid;


}
