package net.catenoid.se.kolluslive.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

public class Channel {
    private String key;
    private Map<String, WebSocketSession> users;

    private Channel(String key){
        this.key = key;
        users = new HashMap<String, WebSocketSession>();
    }

    public static Channel create(String key){
        return new Channel(key);
    }


}
