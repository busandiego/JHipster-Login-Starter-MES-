package com.wmes.appserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmes.appserver.config.properties.DynamicLinkServerProperties;
import com.wmes.appserver.service.Result.DynamicLinkInfo;
import com.wmes.appserver.service.Result.RequestDmInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class DynamicLinkWebClient {

    private WebClient webClient;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    private static final String PATH_CREATE = "/v1/shortLinks";

    private String serviceKey = "AIzaSyCyYx2SPEvS2CvmlPuhn8Bi1d7EoR9nMFQ";
    private String url =  "https://firebasedynamiclinks.googleapis.com";


    public DynamicLinkWebClient(DynamicLinkServerProperties properties, RestTemplateBuilder restTemplate) {

        this.webClient = WebClient.builder()
                .baseUrl(properties.toUrl())
//                .defaultHeaders(headers -> headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .build();

//        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//
//        interceptors.add(new HeaderRequestInterceptor("Authorization", "key="+ serviceKey));
//        interceptors.add(new HeaderRequestInterceptor("Content-Type","application/json"));

        this.restTemplate = restTemplate
                .rootUri(properties.toUrl())
//                .additionalInterceptors(interceptors)
                .additionalMessageConverters(new ByteArrayHttpMessageConverter())
                .build();


    }

    public DynamicLinkInfo createLink(RequestDmInfo requestDmInfo) throws RestClientException {
        HttpEntity<RequestDmInfo> request = new HttpEntity<>(requestDmInfo);
        return restTemplate.postForObject(PATH_CREATE+"?key="+serviceKey, request, DynamicLinkInfo.class);
    }
}
