package net.catenoid.se.kolluslive.callback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catenoid.se.kolluslive.config.KollusConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/callback")
public class CallbackController {


    @Autowired
    private KollusConfig kollusConfig;

    @RequestMapping(method = RequestMethod.POST, path = "/live")
    public @ResponseBody String callbackLiveStatus(@RequestParam("version") String version,
                                     @RequestParam("service_account_key") String service_account_key,
                                     @RequestParam("channel_key") String channel_key,
                                     @RequestParam("stream_key") String stream_key,
                                     @RequestParam("broadcast_key") String broadcast_key,
                                     @RequestParam("braoadcast_state") String broadcast_state) {
        // 방송 상태에 따른 분기 처리
        switch(broadcast_state){
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
    public @ResponseBody String callbackRecodingStatus(
            @RequestParam("version") String version,
            @RequestParam("service_account_key") String service_account_key,
            @RequestParam("channel_key") String channel_key,
            @RequestParam("stream_key") String stream_key,
            @RequestParam("broadcast_key") String broadcast_key,
            @RequestParam("recording_file_id") int recording_file_id,
            @RequestParam("recording_file_filename") String recording_file_filename,
            @RequestParam("recording_file_kind") String recording_file_kind,
            @RequestParam("recording_file_transfer_result") int recording_file_transfer_result) {


        switch (recording_file_transfer_result){
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

}
