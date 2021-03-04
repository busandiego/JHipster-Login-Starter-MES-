package com.wmes.appserver.client.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@Getter @Setter
public class HolidayItemDto {

    private String locdate;
    private String dateKind;
    private String isHoliday;
    private String dateName;
    private int seq;


}
