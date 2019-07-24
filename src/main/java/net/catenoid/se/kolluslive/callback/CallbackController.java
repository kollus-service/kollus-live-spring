package net.catenoid.se.kolluslive.callback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catenoid.se.kolluslive.config.KollusConfig;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method= RequestMethod.POST, path = "/live")
    public String callbackLiveStatus(){

        return null;
    }
    @RequestMapping(method= RequestMethod.POST, path = "/recoding")
    public String callbackRecodingStatus(){

        return null;
    }
    @RequestMapping(method= RequestMethod.GET, path = "/oauth")
    public String callbackOauthRedirect(){

        return null;
    }

}
