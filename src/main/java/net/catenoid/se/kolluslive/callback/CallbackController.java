package net.catenoid.se.kolluslive.callback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catenoid.se.kolluslive.config.KollusConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/live/callback")
public class CallbackController {


    @Autowired
    private KollusConfig kollusConfig;

    @RequestMapping(method = RequestMethod.POST, path = "/live")
    public @ResponseBody
    String callbackLiveStatus(@RequestParam("version") String version,
                              @RequestParam("service_account_key") String service_account_key,
                              @RequestParam("channel_key") String channel_key,
                              @RequestParam("stream_key") String stream_key,
                              @RequestParam("broadcast_key") String broadcast_key,
                              @RequestParam("braoadcast_state") String broadcast_state) {
        // 방송 상태에 따른 분기 처리
        switch (broadcast_state) {
            case "start": //방송시작
                break;
            case "stop": //방송종료
                break;
            case "pause": //방송송출 일시 정지 - 설정되어 있는 방송 단절 정책에 따라 단절 시간동안은 pause 상태
                break;
            case "resume": //방송송출 재시작 - 설정되어 있는 방송 단절 정책에 따라 단절 내에 방송 송출이 될경우의 상태
                break;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/recoding")
    public @ResponseBody
    String callbackRecodingStatus(
            @RequestParam("version") String version,
            @RequestParam("service_account_key") String service_account_key,
            @RequestParam("channel_key") String channel_key,
            @RequestParam("stream_key") String stream_key,
            @RequestParam("broadcast_key") String broadcast_key,
            @RequestParam("recording_file_id") int recording_file_id,
            @RequestParam("recording_file_filename") String recording_file_filename,
            @RequestParam("recording_file_kind") String recording_file_kind,
            @RequestParam("recording_file_transfer_result") int recording_file_transfer_result) {


        switch (recording_file_transfer_result) {
            case 0: // 전송 실패
                break;
            case 1: // 전송 성공
                break;
        }


        return null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/oauth")
    public String callbackOauthRedirect(@RequestParam("code") String code) {

        return null;
    }

    private final String md5(final String s){
        try{

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for(int i=0; i < messageDigest.length; i++){
                hexString.append(Integer.toString((messageDigest[i]&0xff) + 0x100, 16).substring(1));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/lms")
    public @ResponseBody
    String callbackLms(
            HttpServletRequest req,
            @RequestBody String strBody,
            @RequestParam("client_user_id") String client_user_id,
            @RequestParam("start_time") String start_at,
            @RequestParam("run_time") String run_time,
            @RequestParam("media_content_key") String media_content_key,
            @RequestParam("host_name") String host_name,
            @RequestParam("player_id") String player_id,
            @RequestParam("play_status") String player_status,
            @RequestParam("show_time") String show_time,
            @RequestParam("device") String device,
            @RequestParam("uv0") String uv0,
            @RequestParam("uv1") String uv1,
            @RequestParam("uv2") String uv2,
            @RequestParam("uv3") String uv3,
            @RequestParam("uv4") String uv4,
            @RequestParam("hash") String hash,
            @RequestParam("lms_data") String json_data) throws UnsupportedEncodingException {

//        System.out.println("=============================================");
//        System.out.println((new Date()).toString());
//        System.out.println("=============================================");
//        System.out.println("client_user_id: " +  client_user_id);
//        System.out.println("start_at: " +  start_at);
//        System.out.println("run_time: " +  run_time);
//        System.out.println("media_content_key: " +  media_content_key);
//        System.out.println("host_name: " +  host_name);
//        System.out.println("player_id: " +  player_id);
//        System.out.println("play_status: " +  player_status);
//        System.out.println("show_time: " +  show_time);
//        System.out.println("uv0: " +  uv0);
//        System.out.println("uv1: " +  uv1);
//        System.out.println("uv2: " +  uv2);
//        System.out.println("hash: " + hash);
//        System.out.println("json_data: " +  json_data);
//
//        //MD5 비교
//        //check_str = MD5함수(MD5함수(해쉬제외한바디전체) + "+eduwill-kollus");
//
//        System.out.println("=============================================");
//        System.out.println("POST DATA:");
//        System.out.println(strBody);
//        String initData = URLDecoder.decode(strBody.replace("&hash="+hash, ""), "utf-8");
//        String firstMd5 = md5(initData);
//        String secondMd5 = md5(firstMd5+"+hdyang2");
//        System.out.println("Lms Hash: " + hash);
//        System.out.println("Gen Hash: " + secondMd5);
//        System.out.format("Hash Equal: %s\n", hash.equals(secondMd5));
//        System.out.println("=============================================");


        System.out.println((new Date()).toString());
        System.out.format("%s/%s/%s/%s/%s\n", uv0,uv1,uv2,uv3,uv4);
        System.out.println(String.format("player_id/device/show_time/runtime/ %s/%s/%s/%s", player_id, device, show_time,run_time));
        System.out.println(json_data);

       return "";
    }

}
