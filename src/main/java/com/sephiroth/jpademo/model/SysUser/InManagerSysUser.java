package com.sephiroth.jpademo.model.SysUser;


import com.sephiroth.jpademo.base.jpa.BasePagination;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class InManagerSysUser  extends BasePagination {

  @RetentionPagination
  public String id;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.ge)
  public java.sql.Timestamp createdate;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.le,
  field = "createdate")
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
  public String userName;

  @RetentionPagination
  public String userCode;

  @RetentionPagination
  public String password;

  @RetentionPagination
  public String remark;

  @RetentionPagination
  public String salt;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.ge)
  public java.sql.Timestamp lastLogin;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.le)
  public java.sql.Timestamp lastLogin1;


}
