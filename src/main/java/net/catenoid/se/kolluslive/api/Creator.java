package net.catenoid.se.kolluslive.api;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Creator extends ApiExecutor{

    /** Creator List 크리에이터 리스트
     * service_account_key : 서비스 어카운트 키
     * channel_key : 채널 키
     * keyword : 검색어
     * **/
    public HashMap<String, Object> getCreatorList(String channel_key, String keyword) throws Exception {
        String url = String.format("/%s/channels/%s/creators", kollusConfig.getServiceAccount(), channel_key);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (keyword != null && !keyword.isEmpty()) query.add("keyword", keyword);

        return (HashMap<String, Object>) this.requestGet(url, query);
    }
}
