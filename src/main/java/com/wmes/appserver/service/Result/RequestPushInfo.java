package com.wmes.appserver.service.Result;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPushInfo<T> {

    private String to;
    private T data;

}
