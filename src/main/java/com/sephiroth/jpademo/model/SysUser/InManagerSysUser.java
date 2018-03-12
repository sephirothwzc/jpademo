package com.sephiroth.jpademo.model.SysUser;


import com.sephiroth.jpademo.base.jpa.BasePagination;
import com.sephiroth.jpademo.retention.RetentionPagination;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class InManagerSysUser  extends BasePagination {

  @RetentionPagination
  private String id;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.gteq)
  private java.sql.Timestamp createdate;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.lteq)
  private java.sql.Timestamp createdate1;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.gteq)
  private java.sql.Timestamp updatedate;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.lteq)
  private java.sql.Timestamp updatedate1;

  @RetentionPagination
  private String createby;

  @RetentionPagination
  private String updateby;

  @RetentionPagination
  private String enableflag;

  @RetentionPagination
  private String userName;

  @RetentionPagination
  private String userCode;

  @RetentionPagination
  private String password;

  @RetentionPagination
  private String remark;

  @RetentionPagination
  private String salt;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.gteq)
  private java.sql.Timestamp lastLogin;

  @RetentionPagination(scpeEnum = RetentionPagination.ScpeEnum.lteq)
  private java.sql.Timestamp lastLogin1;


}
