package net.catenoid.se.kolluslive.api;

import net.catenoid.se.kolluslive.config.KollusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Channel extends ApiExecutor {


    public HashMap<String, Object> getChannels(String keyword, String order, Integer per_page, String live_status,
                                               String shared_status, Integer trashed) throws Exception {
        String url = String.format("/%s/channels", kollusConfig.getServiceAccount());
        MultiValueMap<String, String> query = new LinkedMultiValueMap<String, String>();
        if (keyword != null && !keyword.isEmpty()) query.add("keyword", keyword);
        if (order != null && !order.isEmpty()) query.add("order", order);
        if (per_page != null && per_page > 0) query.add("per_page", per_page.toString());
        if (live_status != null && !live_status.isEmpty()) query.add("live_staus", live_status);
        if (shared_status != null && !shared_status.isEmpty()) query.add("shared_status", shared_status);
        if (trashed != null && trashed > 0) query.add("trashed", trashed.toString());
        return (HashMap<String, Object>) this.requestGet(url, query);

    }
}
