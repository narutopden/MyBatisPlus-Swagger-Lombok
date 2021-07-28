package com.topdent.swl.demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Blue_Sky 7/28/21
 */
@ApiModel(value="save new user")
@Data
public class SaveUserRequest {
    @ApiModelProperty(value = "user id")
    private int id;
    @ApiModelProperty(value = "email address", required = true,example = "tenxin@gmail.com")
    private String email;
    @ApiModelProperty(value = "phone number",required = true)
    private String phone;

    private String name;

}
