package net.catenoid.se.kolluslive.api;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Broadcast extends ApiExecutor{

    /** Broadcast List 브로드캐스트 리스트 **/
    public HashMap<String, Object> getBroadcastsList(String keyword, String order, Integer per_page, String start_date,
                                                     String end_date) throws Exception {
        String url = String.format("/%s/broadcasts", kollusConfig.getServiceAccount());
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (keyword != null && !keyword.isEmpty()) query.add("keyword", keyword);
        if (order != null && !order.isEmpty()) query.add("order", order);
        if (per_page != null && per_page > 0) query.add("per_page", per_page.toString());
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);
        if (end_date != null && !end_date.isEmpty()) query.add("end_date", end_date);
        return (HashMap<String, Object>) this.requestGet(url, query);
    }

    /** Show Broadcast 브로드캐스트 보기 **/
    public HashMap<String, Object> getShowBroadcasts(String broadcast_key) throws Exception {
        if (broadcast_key == null && broadcast_key.isEmpty()) return null;
        String url = String.format("/%s/broadcasts/%s", kollusConfig.getServiceAccount(), broadcast_key);

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Update Broadcast 브로드캐스트 수정 **/
    public HashMap<String, Object> getUpdateBroadcasts(String broadcast_key, String title) throws Exception {
        String url = String.format("/%s/broadcasts/%s", kollusConfig.getServiceAccount(), broadcast_key);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        if (title != null && !title.isEmpty()) requestBody.add("title", title);

        return (HashMap<String, Object>) this.requestPost(url, null, requestBody);
    }

    /** Remove Broadcast 브로드캐스트 삭제 **/
    public HashMap<String, Object> getDeleteBroadcasts(String broadcast_key, String title) throws Exception {
        String url = String.format("/%s/broadcasts/%s", kollusConfig.getServiceAccount(), broadcast_key);

        return (HashMap<String, Object>) this.requestDelete(url);
    }

    /** Start Duplicate Recording 자동 저장 시작 **/
    public HashMap<String, Object> getStartBroadcastsRecording(String broadcast_key) throws Exception {
        String url = String.format("/%s/broadcasts/%s/duplicate-recording", kollusConfig.getServiceAccount(), broadcast_key);

        return (HashMap<String, Object>) this.requestPost(url, null, null);
    }

    /** Stop Duplicate Recording 자동 저장 종료 **/
    public HashMap<String, Object> getStopBroadcastsRecording(String broadcast_key, String title) throws Exception {
        String url = String.format("/%s/broadcasts/%s/duplicate-recording", kollusConfig.getServiceAccount(), broadcast_key);

        return (HashMap<String, Object>) this.requestDelete(url);
    }

    /** Broadcast List 브로드캐스트 리스트 **/
    public HashMap<String, Object> getChannelBroadcastsList(String channel_key, String keyword, String order, Integer per_page, String start_date,
                                                            String end_date) throws Exception {
        String url = String.format("/%s/channels/%s/broadcasts", kollusConfig.getServiceAccount(), channel_key);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (keyword != null && !keyword.isEmpty()) query.add("keyword", keyword);
        if (order != null && !order.isEmpty()) query.add("order", order);
        if (per_page != null && per_page > 0) query.add("per_page", per_page.toString());
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);
        if (end_date != null && !end_date.isEmpty()) query.add("end_date", end_date);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }

}