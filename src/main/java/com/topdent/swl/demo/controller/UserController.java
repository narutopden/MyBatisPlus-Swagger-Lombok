package com.topdent.swl.demo.controller;

import com.topdent.swl.demo.model.User;
import com.topdent.swl.demo.request.SaveUserRequest;
import com.topdent.swl.demo.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blue_Sky 7/28/21
 */
@RestController
@RequestMapping("api/v1/user")
@Api(tags = "user section", value = "user controller")
public class UserController {

    @ApiOperation("user list table")
    @GetMapping("list")
    public JsonData list(){
        User user1 = User.builder().name("tenzin").mail("topdent.yahoo.com").slogan("cool cool cool").build();
        User user2 = User.builder().name("tsering").mail("sonam.yahoo.com").slogan("good beginning is half done").build();
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        return JsonData.buildSuccess(list);
    }

    @ApiIgnore   // hide from swagger UI
    @ApiOperation("user detail")
    @GetMapping("detail")
    public JsonData detail(@ApiParam(name = "id",value = "user id",example = "1",required = true)int id){
        return  JsonData.buildSuccess();
    }

    @ApiOperation("User Login")
    @PostMapping("login")
    @ApiResponses({
            @ApiResponse(responseCode = "302",description = "parameter error"),
            @ApiResponse(responseCode = "402",description = "no permission")

    })
    public JsonData login(
            @ApiParam(name = "phone", value = "phone number",example = "13888888888")
            @RequestParam("phone") String phone,

            @ApiParam(name = "pwd", value = "password",example = "123456")
            @RequestParam("pwd")String pwd){

        return JsonData.buildSuccess();
    }

    @ApiOperation("Delete User by there ID")
    @DeleteMapping("/delete/{id}")
    public JsonData deleteById(@PathVariable int id) {
        return JsonData.buildSuccess();
    }
    @ApiOperation("Save new User")
    @PostMapping("save")
    //public JsonData saveUser(SaveUserRequest saveUserRequest){
    public JsonData saveUser(@RequestBody SaveUserRequest saveUserRequest){
        return JsonData.buildSuccess();
    }

}
