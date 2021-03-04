package com.wmes.appserver.service.dto;

import static com.wmes.appserver.config.Common.Message.MESSAGE_SUCCESS;
import static com.wmes.appserver.config.Common.StatusCode.STATUS_SUCCESS;

public class ResultDto extends ResultCodeDto{
    private Object contents;

    public ResultDto() {
        super(STATUS_SUCCESS, MESSAGE_SUCCESS);
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
            "contents=" + contents +
            '}';
    }
}

