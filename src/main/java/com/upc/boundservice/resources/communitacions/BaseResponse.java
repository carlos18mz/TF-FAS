package com.upc.boundservice.resources.communitacions;

import com.upc.boundservice.resources.inputs.BookOutput;
import lombok.Data;

import java.util.List;

@Data
public class BaseResponse {
    public String title;
    public String message;
    public Integer status;

    public BaseResponse(String title, String message, Integer status){
        this.title = title;
        this.message = message;
        this.status = status;
    }

    public BaseResponse(String message)
    {
        this.message = message;
        this.status = 1;
    }

    public BaseResponse(){
        this.status = 1;
    }

    BookOutput bookOutput;

    List<BookOutput> bookOutputList;
}
