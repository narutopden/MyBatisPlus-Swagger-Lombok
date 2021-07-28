package com.topdent.swl.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Blue_Sky 7/28/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {
    private Integer code;
    private Object data;
    private String msg;

    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }

    public static JsonData buildSuccess(Object data){
        return new JsonData(0,data,null);
    }

    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }

    public static JsonData buildError(String msg, Integer code){
        return new JsonData(code,null, msg);
    }

}
