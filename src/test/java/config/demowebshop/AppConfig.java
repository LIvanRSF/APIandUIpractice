package config.demowebshop;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:app.properties"
})

public interface AppConfig extends Config {

    String webBaseURL();
    String apiBaseURI();
    String userLogin();
    String userPassword();
}
