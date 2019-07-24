package net.catenoid.se.kolluslive.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class FrontController {
    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(){
        return "home";
    }
    @RequestMapping(value = "/popup", method = RequestMethod.GET)
    public ModelAndView popup(@RequestParam(value = "path", required = true)String path) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView("popup");
        mav.addObject("path", URLDecoder.decode(path, "utf8"));
        return mav;
    }
}
