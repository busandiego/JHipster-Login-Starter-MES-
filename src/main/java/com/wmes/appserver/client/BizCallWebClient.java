package com.wmes.appserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmes.appserver.client.response.bizcall.RequestBizCallInfo;
import com.wmes.appserver.client.response.bizcall.ResponseBizCallInfo;
import com.wmes.appserver.config.properties.BizCallServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@Slf4j
public class BizCallWebClient {

    private WebClient webClient;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    private static final String MAPPING_NUM = "/link/auto_expire_mapp.do";

    private String iid = "ghqsoojssidojq642fke";


    public BizCallWebClient(BizCallServerProperties properties, RestTemplateBuilder restTemplate) {

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

    public ResponseBizCallInfo mappingPhone(RequestBizCallInfo requestBizCallInfo) throws RestClientException {
        requestBizCallInfo.setIid(iid);

        //iid + rn MD5 암호화
        StringBuffer stringBuffer = new StringBuffer();

        String auth = iid + requestBizCallInfo.getRn();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(auth.getBytes());
            byte[] msgStr = messageDigest.digest();
            for (byte b : msgStr) {
                String tmpEncTxt = Integer.toHexString((int) b & 0x00ff);
                stringBuffer.append(tmpEncTxt);
            }
            auth = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            auth = "";
        }

        //MD5 암호화 Base64 인코딩
        byte[] targetBytes = auth.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodeByte = encoder.encode(targetBytes);
        auth = new String(encodeByte);

        requestBizCallInfo.setAuth(auth);
        String queryUrl = MAPPING_NUM + "?iid=" + requestBizCallInfo.getIid() + "&rn=" + requestBizCallInfo.getRn() + "&expire_hour=" + requestBizCallInfo.getExpire_hour() + "&auth=" + auth;
        HttpEntity<RequestBizCallInfo> request = new HttpEntity<>(requestBizCallInfo);
        return restTemplate.postForObject(queryUrl, request, ResponseBizCallInfo.class);
    }
}
