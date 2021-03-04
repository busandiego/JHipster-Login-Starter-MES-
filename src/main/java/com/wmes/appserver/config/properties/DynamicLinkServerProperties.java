package com.wmes.appserver.config.properties;

import com.wmes.appserver.config.constant.PropertiesKey;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;


@Configuration
@ConfigurationProperties(prefix = PropertiesKey.KEY_DYNAMICLINK_SERVER)
@Data
public class DynamicLinkServerProperties {

    private String scheme;
    private String host;
    private int port;

    public String toUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .build().toString();
    }



}
