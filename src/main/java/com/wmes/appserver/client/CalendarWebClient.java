package com.wmes.appserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmes.appserver.config.properties.DynamicLinkServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class CalendarWebClient {

    private WebClient webClient;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    private static final String PATH_ORDER = "/B090041/openapi/service/SpcdeInfoService";
    private static final String PATH_REVOKE = "/order/revoke/";

    private String serviceKey = "B1Abzf5SiAw4vLFt2Sj7%2F2G2pdJAUE6nN96uqyX%2FQUncQyLXFJLJ7Ug3u9xk5SojY4WxQrdUh34kFhM8PrclrQ%3D%3D";
    private String url =  "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService";


    public CalendarWebClient(DynamicLinkServerProperties properties, RestTemplateBuilder restTemplate) {

        this.webClient = WebClient.builder()
                .baseUrl(properties.toUrl())
//                .defaultHeaders(headers -> headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .build();


        this.restTemplate = restTemplate
                .rootUri(properties.toUrl())
                .additionalMessageConverters(new ByteArrayHttpMessageConverter())
                .build();

    }

}
