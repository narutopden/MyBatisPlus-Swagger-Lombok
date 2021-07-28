package com.topdent.swl.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
//@Builder User user = User.Builder()
//                         .id(1)
//                         .img("aaa")
//                         .url("bbbb")
//                         .weight("cccc")
//                         .build();
// builder mode
@Data
@TableName("banner")
public class Banner {

  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;
  private String img;
  private String url;
  private Integer weight;
  @Version  // add this to active Optimistic Lock
  private Integer version;
  @TableLogic   //logic deletion
  private Integer deleted;

  @TableField(exist = false)
  private Date creationDate;




}
