package net.catenoid.se.kolluslive.api;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ServiceAccount extends ApiExecutor{

    /** Chatting Service List 채팅 서비스 리스트
     * service_account_key : 서비스 어카운트 키
     * **/
    public HashMap<String, Object> getChattingServiceList() throws Exception {
        String url = String.format("/%s/chatting-services", kollusConfig.getServiceAccount());

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

    /** Profile Group List 프로파일 그룹 리스트
     * service_account_key : 서비스 어카운트 키
     * **/
    public HashMap<String, Object> getProfileGroupList() throws Exception {
        String url = String.format("/%s/profile-groups", kollusConfig.getServiceAccount());

        return (HashMap<String, Object>) this.requestGet(url, null);
    }

}
