package net.catenoid.se.kolluslive.api;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Statistics extends ApiExecutor{

    /** Live Statistics Broadcast Viewer During A Day 하루간 라이브 방송별 사용자 통계(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * broadcast_key (required) : 방송 키
     * duration_minute (required) : 구간간격 분, Available values : 5, 10, Default value : 5
     *
     * (----- query -----)
     * start_date (required) : 시작 일시, 하루 동안의 결과만 가능 ex) 2018-12-01 (UTC) or 2018-12-01T01:00:00+00:00
     * **/
    public HashMap<String, Object> getBroadcastsViewerADay(String broadcast_key, String duration_minute, String start_date) throws Exception {
        String url = String.format("/%s/broadcasts/%s/statistics/viewer/%smin-during-a-day", kollusConfig.getServiceAccount(), broadcast_key, duration_minute);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }

    /** Live Statistics Channel Viewer During A Day 하루간 라이브 채널별 사용자 통계(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * channel_key (required) : 채널 키
     * duration_minute (required) : 구간간격 분, Available values : 5, 10, Default value : 5
     *
     * (----- query -----)
     * start_date (required) : 시작 일시, 하루 동안의 결과만 가능 ex) 2018-12-01 (UTC) or 2018-12-01T01:00:00+00:00
     * **/
    public HashMap<String, Object> getChannelsViewerADay(String channel_key, String duration_minute, String start_date) throws Exception {
        String url = String.format("/%s/channels/%s/statistics/viewer/%smin-during-a-day", kollusConfig.getServiceAccount(), channel_key, duration_minute);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }

    /** Live Statistics Summary Daily 라이브 일별 통계 요약(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     *
     * (----- query -----)
     * start_date (required) : Start Date(Great Than Or Equal To, =<) ex) 2018-12-01 (UTC) or 2018-12-01T01:00:00+00:00
     * end_date (required) : End Date(Less Than, <) ex) 2019-01-01 (UTC) or 2019-01-01T01:00:00+00:00
     * **/
    public HashMap<String, Object> getLiveSummaryDaily(String start_date, String end_date) throws Exception {
        String url = String.format("/%s/statistics/summary-daily", kollusConfig.getServiceAccount());
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);
        if (end_date != null && !end_date.isEmpty()) query.add("end_date", end_date);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }

    /** Live Statistics Viewer During A Day 하루간 라이브 사용자 통계(GET)
     *
     * (----- path -----)
     * service_account_key (required) : 서비스 어카운트 키
     * duration_minute (required) : 구간간격 분, Available values : 5, 10, Default value : 5
     *
     * (----- query -----)
     * start_date (required) : 시작 일시, 하루 동안의 결과만 가능 ex) 2018-12-01 (UTC) or 2018-12-01T01:00:00+00:00
     * **/
    public HashMap<String, Object> getLiveViewerDuringADay( String duration_minute, String start_date) throws Exception {
        String url = String.format("/%s/statistics/viewer/%smin-during-a-day", kollusConfig.getServiceAccount(), duration_minute);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (start_date != null && !start_date.isEmpty()) query.add("start_date", start_date);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }

}
