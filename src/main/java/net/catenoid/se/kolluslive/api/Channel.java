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

    /** Create Channel 채널 생성 **/
    public HashMap<String, Object> getChannels(String title, String customer_code, Integer concurrently_viewer_limit, Integer is_shared,
                                               String live_media_profile_group_key, String meta_title_pattern, String meta_description,
                                               Integer recording_file_policy, String recording_file_pattern, Integer recording_file_segment_policy,
                                               Integer recording_file_segment_by_duration, Integer idle_screen_kind, Integer media_player_policy,
                                               Integer use_chatting_service, Integer chatting_service_id, String chatting_info, Integer use_duplicate_block,
                                               Integer use_capture_block, Integer use_timeshift) throws Exception {
        String url = String.format("/%s/channels", kollusConfig.getServiceAccount());
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        if (title != null && !title.isEmpty()) requestBody.add("title", title);
        if (customer_code != null && !customer_code.isEmpty()) requestBody.add("customer_code", customer_code);
        if (concurrently_viewer_limit != null && concurrently_viewer_limit > 0) requestBody.add("concurrently_viewer_limit", concurrently_viewer_limit.toString());

        return (HashMap<String, Object>) this.requestPost(url, null, requestBody);

    }
}
