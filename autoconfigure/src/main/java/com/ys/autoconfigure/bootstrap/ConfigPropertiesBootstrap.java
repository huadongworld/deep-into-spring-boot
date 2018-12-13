package com.ys.autoconfigure.bootstrap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author HuaDong
 * @date 2018/12/13 9:34
 */
@Component
@ConfigurationProperties(prefix = "server")
public class ConfigPropertiesBootstrap {

    private String platform;

    private List<String> headCode;

    private List<String> domain;

    private Map<String, String> relate;

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<String> getHeadCode() {
        return headCode;
    }

    public void setHeadCode(List<String> headCode) {
        this.headCode = headCode;
    }

    public Map<String, String> getRelate() {
        return relate;
    }

    public void setRelate(Map<String, String> relate) {
        this.relate = relate;
    }
}
