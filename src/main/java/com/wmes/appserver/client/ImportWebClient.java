package com.wmes.appserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmes.appserver.client.response.importpg.RequestTokenInfo;
import com.wmes.appserver.client.response.importpg.ResponseImpTokenInfo;
import com.wmes.appserver.config.properties.ImportServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class ImportWebClient {

    private WebClient webClient;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    private static final String BASEURL = "https://api.iamport.kr";

    private static final String GETTOKEN = "/users/getToken";
    private static final String GETPAYMENTS = "/payments";

    private String rest_api_key = "9467438260271722";
    private String rest_api_secret = "4eO1TQbQhOBHatYPvdzCYNOo5iol7KzbZocTfoJwckdmNbcipMUnzJLE1a08VAkUZxOeVxL8RYvFaHYA";


    public ImportWebClient(ImportServerProperties properties, RestTemplateBuilder restTemplate) {

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

    public ResponseImpTokenInfo getToken() throws RestClientException {
        RequestTokenInfo requestTokenInfo = new RequestTokenInfo();
        requestTokenInfo.setImp_key(rest_api_key);
        requestTokenInfo.setImp_secret(rest_api_secret);
        HttpEntity<RequestTokenInfo> request = new HttpEntity<>(requestTokenInfo);
        return restTemplate.postForObject(GETTOKEN, request, ResponseImpTokenInfo.class);
    }

    public ResponseEntity<ResponseImpTokenInfo> getPayments(String impUid, String token) throws RestClientException {
        String paymentUrl = GETPAYMENTS+"/"+1;
        HttpHeaders request = new HttpHeaders();
        request.set("Authorization", "Bearer "+token);
        HttpEntity<String> entity = new HttpEntity<String>(request);
        return restTemplate.exchange(paymentUrl, HttpMethod.GET, entity, ResponseImpTokenInfo.class);
    }
}
