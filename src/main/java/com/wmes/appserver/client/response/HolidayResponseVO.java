package com.wmes.appserver.client.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "response")
@Getter @Setter
public class HolidayResponseVO {

    private Map<String, String> header;
    private HolidayItemsDto body;

    @Override
    public String toString() {
        return "HolidayResponseVO [header="+header+", body="+body+"]";
    }
}
