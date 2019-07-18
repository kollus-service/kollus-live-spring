package net.catenoid.se.kolluslive;

import net.catenoid.se.kolluslive.api.Channel;
import net.catenoid.se.kolluslive.config.KollusConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "net.catenoid.se.kolluslive.*")
public class KollusLiveApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private Channel channel;

    @Test
    public void apitest(){

        HashMap<String, Object> result = null;
        try {
            result = channel.getChannels(null, null, null, null, null, null);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println(result);
    }

}
