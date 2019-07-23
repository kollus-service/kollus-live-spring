package net.catenoid.se.kolluslive.api;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Syndication extends ApiExecutor{

    /** Syndication List 신디케이션 리스트(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     * **/
    public HashMap<String, Object> getSyndicationList(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s/syndications", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Create Syndication 신디케이션 생성(POST)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     *
     * (----- Request Body -----)
     * title (required) : 제목
     * link (required) : 링크
     * stream_name (required) : 스트림키
     * status (required) : 사용여부
     * **/
    public HashMap<String, Object> createSyndication(String channel_key, String title, String link, String stream_name, Integer status) throws Exception {
        String url = String.format("/%s/channels/%s/syndications", kollusConfig.getServiceAccount(), channel_key);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        if (title != null && !title.isEmpty()) requestBody.add("title", title);
        if (link != null && !link.isEmpty()) requestBody.add("link", link);
        if (stream_name != null && !stream_name.isEmpty()) requestBody.add("stream_name", stream_name);
        if (status != null && status >= 0) requestBody.add("status", status.toString());

        return (HashMap<String, Object>) this.requestPost(url, null, requestBody);
    }

    /** Show Syndication 신디케이션 보기(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     * syndication_id (required) : 신디케이션 ID
     * **/
    public HashMap<String, Object> showSyndication(String channel_key, Integer syndication_id) throws Exception {
        String url = String.format("/%s/channels/%s/syndications/%s", kollusConfig.getServiceAccount(), channel_key, syndication_id);

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Update Syndication 신디케이션 수정(PUT)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     * syndication_id (required) : 신디케이션 ID
     *
     * (----- Request Body -----)
     * title : 제목
     * link : 링크
     * stream_name : 스트림키
     * status : 사용여부
     * **/
    public HashMap<String, Object> updateSyndication(String channel_key, Integer syndication_id, String title, String link, String stream_name, Integer status) throws Exception {
        String url = String.format("/%s/channels/%s/syndications/%s", kollusConfig.getServiceAccount(), channel_key, syndication_id);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        if (title != null && !title.isEmpty()) requestBody.add("title", title);
        if (link != null && !link.isEmpty()) requestBody.add("link", link);
        if (stream_name != null && !stream_name.isEmpty()) requestBody.add("stream_name", stream_name);
        if (status != null && status >= 0) requestBody.add("status", status.toString());

        return (HashMap<String, Object>) this.requestPut(url, null, requestBody);
    }

    /** Remove Syndication 신디케이션 삭제(DELETE)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     * syndication_id (required) : 신디케이션 ID
     * **/
    public HashMap<String, Object> removeSyndication(String channel_key, Integer syndication_id) throws Exception {
        String url = String.format("/%s/channels/%s/syndications/%s", kollusConfig.getServiceAccount(), channel_key, syndication_id);

        return (HashMap<String, Object>) this.requestDelete(url);
    }

}
