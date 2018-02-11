package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_logger")
@Data
public class EntityTLogger implements Serializable {

  
  /**
   * null
   */
  @Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;
  
  /**
   * null
   */
  @Column(name = "createdate")
  private java.sql.Timestamp createdate;
  
  /**
   * null
   */
  @Column(name = "updatedate")
  private java.sql.Timestamp updatedate;
  
  /**
   * null
   */
  @Column(name = "createby")
  private String createby;
  
  /**
   * null
   */
  @Column(name = "updateby")
  private String updateby;
  
  /**
   * null
   */
  @Column(name = "enableflag")
  private String enableflag;
  
  /**
   * 业务编码
   */
  @Column(name = "bdcode")
  private String bdcode;
  
  /**
   * 公司代码
   */
  @Column(name = "companyno")
  private String companyno;
  
  /**
   * null
   */
  @Column(name = "ali_id")
  private long aliId;
  
  /**
   * null
   */
  @Column(name = "clientip")
  private String clientip;
  
  /**
   * null
   */
  @Column(name = "ali_uri")
  private String aliUri;
  
  /**
   * null
   */
  @Column(name = "ali_type")
  private String aliType;
  
  /**
   * null
   */
  @Column(name = "ali_method")
  private String aliMethod;
  
  /**
   * null
   */
  @Column(name = "ali_paramdata")
  private String aliParamdata;
  
  /**
   * null
   */
  @Column(name = "session_id")
  private String sessionId;
  
  /**
   * null
   */
  @Column(name = "ali_datetime")
  private java.sql.Timestamp aliDatetime;
  
  /**
   * null
   */
  @Column(name = "ali_return_time")
  private java.sql.Timestamp aliReturnTime;
  
  /**
   * null
   */
  @Column(name = "ali_return_data")
  private String aliReturnData;
  
  /**
   * null
   */
  @Column(name = "http_status_code")
  private String httpStatusCode;
  
  /**
   * null
   */
  @Column(name = "ali_time_consuming")
  private long aliTimeConsuming;
  
  /**
   * 登陆用户
   */
  @Column(name = "token_user")
  private String tokenUser;

}
