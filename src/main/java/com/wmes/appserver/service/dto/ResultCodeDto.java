package com.wmes.appserver.service.dto;

import lombok.Data;

import static com.wmes.appserver.config.Common.Message.MESSAGE_SUCCESS;
import static com.wmes.appserver.config.Common.StatusCode.STATUS_SUCCESS;

@Data
public class ResultCodeDto {
    private int code;
    private String message;

    public ResultCodeDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultCodeDto() {
        this.code = STATUS_SUCCESS;
        this.message = MESSAGE_SUCCESS;
    }
}

