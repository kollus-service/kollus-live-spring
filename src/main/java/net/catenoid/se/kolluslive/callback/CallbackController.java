package net.catenoid.se.kolluslive.callback;

import net.catenoid.se.kolluslive.config.KollusConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
