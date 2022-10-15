package config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:${host}.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("100")
    String browserVersion();

    @DefaultValue("1024x768")
    String browserSize();

    String remoteDriverUrl();
}
