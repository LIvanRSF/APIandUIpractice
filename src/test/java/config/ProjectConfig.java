package config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:remote.properties",
    "classpath:local.properties"
})
public interface ProjectConfig extends Config {

    String browser();

    String browserVersion();

    String browserSize();

    String remoteDriverUrl();
}
