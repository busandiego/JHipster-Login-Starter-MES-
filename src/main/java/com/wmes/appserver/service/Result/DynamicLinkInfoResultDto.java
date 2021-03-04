package com.wmes.appserver.service.Result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DynamicLinkInfoResultDto<T> {
    private T dynamicLinkResultDto;
    private T suffixResultDto;
}
