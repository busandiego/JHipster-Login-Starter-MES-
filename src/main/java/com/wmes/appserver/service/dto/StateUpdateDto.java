package com.wmes.appserver.service.dto;


import com.wmes.appserver.domain.enumeration.StateApplyAffiliate;
import lombok.Data;

@Data
public class StateUpdateDto {

    private Long[] ids;
    private StateApplyAffiliate stateName;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public StateApplyAffiliate getStateName() {
        return stateName;
    }

    public void setStateName(StateApplyAffiliate stateName) {
        this.stateName = stateName;
    }
}
