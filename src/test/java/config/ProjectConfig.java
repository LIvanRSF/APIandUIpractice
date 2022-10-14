package config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:remote.properties",
    "classpath:local.properties"
})
public interface ProjectConfig extends Config {

    String browser();

    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();
}
