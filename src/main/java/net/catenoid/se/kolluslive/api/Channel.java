package net.catenoid.se.kolluslive.api;

import net.catenoid.se.kolluslive.config.KollusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Component
public class Channel extends ApiExecutor {

    /** Channel List 채널 리스트
     * service_account_key : 서비스계정키
     * keyword : 키워드
     * order
     * per_page
     * live_status
     * shared_status
     * trashed
     * **/
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

    /** Create Channel 채널 생성
     * title : 채널명
     * customer_code : 고객코드
     * concurrently_viewer_limit : 동시 시청자수 제한
     * is_shared : 공개여부
     * live_media_profile_group_key : 라이브 인코딩 프로파일 그룹 키
     * meta_title_pattern : 메타 정보 제목
     * meta_description : 메타 정보 내용
     * recording_file_policy : 녹화파일 정책 0: Not Used, 1: Segment, 3: Segment + Duplidate Recording
     * recording_file_pattern : 녹화파일 저장 규칙
     * recording_file_segment_policy : 자동(세그멘트) 녹화파일 정책 1: By Size(4G), 2: By Duration
     * recording_file_segment_by_duration : 자동(세그멘트) 녹화파일 시간 (Minutes)
     * idle_screen_kind : 대기화면 설정 0: Poster, 1: Snapshot
     * media_player_policy : 미디어 플레이어 정책 0: Not Used, 1: Force Exclusive Player
     * use_chatting_service : 채팅 서비스 사용
     * chatting_service_id : 채팅 서비스 ID
     * chatting_info : 채팅 정보 (json 문자열)
     * use_duplicate_block : 중복차단 사용
     * use_capture_block : 캡쳐차단 사용
     * use_timeshift : 타임시프트 사용
     * **/
    public HashMap<String, Object> createChannels(String title, String customer_code, Integer concurrently_viewer_limit, Integer is_shared,
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

    /** Show Channel 채널 보기
     * service_account_key : 서비스계정키
     * channel_key : 채널키
     * **/
    public HashMap<String, Object> showChannels(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Update Channel 채널 수정
     * service_account_key : 서비스 어카운트 키
     * channel_key : 채널키
     * title : title
     * customer_code : 고객코드
     * concurrently_viewer_limit : 동시 시청자수 제한
     * is_shared : 공개여부
     * live_media_profile_group_key : 라이브 인코딩 프로파일 그룹 키
     * meta_title_pattern : 메타 정보 제목
     * meta_description : 메타 정보 내용
     * recording_file_policy : 녹화파일 정책 0: Not Used, 1: Segment, 3: Segment + Duplidate Recording
     * recording_file_pattern : 녹화파일 저장 규칙
     * recording_file_segment_policy : 자동(세그멘트) 녹화파일 정책 1: By Size(4G), 2: By Duration
     * recording_file_segment_by_duration : 자동(세그멘트) 녹화파일 시간 (Minutes)
     * media_player_policy : 미디어 플레이어 정책 0: Not Used, 1: Force Exclusive Player
     * use_chatting_service : 채팅 서비스 사용
     * chatting_service_id : 채팅 서비스 ID
     * chatting_info : 채팅 정보 (json 문자열)
     * use_duplicate_block : 중복차단 사용
     * use_capture_block : 캡쳐차단 사용
     * use_timeshift : 타임시프트 사용
     * idle_screen_kind : 대기화면 설정 0: Poster, 1: Snapshot
     * **/
    public HashMap<String, Object> updateChannels(String channel_key, String title, String customer_code, Integer concurrently_viewer_limit, Integer is_shared,
                                                  String live_media_profile_group_key, String meta_title_pattern, String meta_description,
                                                  Integer recording_file_policy, String recording_file_pattern, Integer recording_file_segment_policy,
                                                  Integer recording_file_segment_by_duration, Integer idle_screen_kind, Integer media_player_policy,
                                                  Integer use_chatting_service, Integer chatting_service_id, String chatting_info, Integer use_duplicate_block,
                                                  Integer use_capture_block, Integer use_timeshift) throws Exception {
        String url = String.format("/%s/channels/%s", kollusConfig.getServiceAccount(), channel_key);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        if (title != null && !title.isEmpty()) requestBody.add("title", title);

        return (HashMap<String, Object>) this.requestPut(url, null, requestBody);
    }

    /** Remove Channel 채널 삭제
     * service_account_key : 서비스 어카운트 키
     * channel_key : 채널키
     * **/
    public HashMap<String, Object> removeChannels(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestDelete(url);
    }

    /** Show Channel Chatting Info 채널 채팅 정보 보기
     * service_account_key : 서비스계정키
     * channel_key : 채널키
     * **/
    public HashMap<String, Object> showChannelsChattingInfo(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s/chatting-info", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Restore Channel 채널 복원
     * service_account_key : 서비스계정키
     * channel_key : 채널키
     * **/
    public HashMap<String, Object> restoreChannels(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s/restore", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestPut(url, null, null);
    }

    /** Trash Channel 채널 숨김
     * service_account_key : 서비스계정키
     * channel_key : 채널키
     * **/
    public HashMap<String, Object> trashChannels(String channel_key) throws Exception {
        String url = String.format("/%s/channels/%s/trash", kollusConfig.getServiceAccount(), channel_key);

        return (HashMap<String, Object>) this.requestPut(url, null, null);
    }


}
