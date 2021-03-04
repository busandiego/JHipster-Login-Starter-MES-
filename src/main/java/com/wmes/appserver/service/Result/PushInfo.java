package com.wmes.appserver.service.Result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
public class PushInfo {

    private Long multicast_id;
    private boolean success;
    private boolean failure;
    private int canonical_ids;
    private List<Map<String, String>> results;

    public PushInfo() {
    }

}
