package com.wmes.appserver.service;

import com.wmes.appserver.service.Result.DmLinkResultDto;
import com.wmes.appserver.service.Result.DynamicLinkInfo;
import com.wmes.appserver.service.Result.DynamicLinkInfoResultDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;


@Service
public class DynamicLinkService {

    private WebClient webClient;

    private static final String FIREBASE_SERVER_KEY = "AIzaSyCyYx2SPEvS2CvmlPuhn8Bi1d7EoR9nMFQ";
    private static final String FIREBASE_API_URL = "https://firebasedynamiclinks.googleapis.com";
    private static final String FIREBASE_API_URLAll = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks";


    private static final String PATH_FIREBASE_SEND = "/v1/shortLinks";

    public DynamicLinkService() {

        this.webClient = WebClient.builder()
            .baseUrl(FIREBASE_API_URL)
            .defaultHeaders(headers -> {
                headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
                headers.add(HttpHeaders.AUTHORIZATION, "key=" + FIREBASE_SERVER_KEY);
            })
            .build();
    }

    public Mono<DynamicLinkInfo> createLinks(DynamicLinkInfoResultDto dynamicLinkInfoResultDto) {
        return webClient.post()
            .uri(PATH_FIREBASE_SEND)
            .body(BodyInserters.fromObject(dynamicLinkInfoResultDto))
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException()))
            .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException()))
            .bodyToMono(new ParameterizedTypeReference<DynamicLinkInfo>() {
            });
    }

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URLAll, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }


    public boolean callCreateLink(DmLinkResultDto dynamicLinkInfoResultDto) {
        try {
            createLinks(
                DynamicLinkInfoResultDto.builder()
                    .dynamicLinkResultDto(dynamicLinkInfoResultDto.getDynamicLinkResultDto())
                    .suffixResultDto(dynamicLinkInfoResultDto.getSuffixResultDto())
                    .build())
                .doOnError(Throwable::printStackTrace)
                .subscribe();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
