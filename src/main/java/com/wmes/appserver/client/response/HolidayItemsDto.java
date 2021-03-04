package com.wmes.appserver.client.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "body")
public class HolidayItemsDto {

    private List<HolidayItemDto> items;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<HolidayItemDto> getItems(){
        return items;
    }

    public void setItems(List<HolidayItemDto> items) {
        this.items = items;
    }
}
