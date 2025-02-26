package fr.cesi.ms_user.config;

import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RestController
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${user.params.x}")
    private String x;
    @Value("${user.params.y}")
    private String y;

    @Autowired
    private UserConfigParams userConfigParams;

    @GetMapping("/testConfig1")
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }
/*
    @GetMapping("/testConfig2")
    public UserConfigParams configTest2() {
        return userConfigParams;
    }*/
    @GetMapping("/testConfig2")
    public Map<String, String> configTest2() {
        return Map.of("x", x, "y", y);
    }
}
