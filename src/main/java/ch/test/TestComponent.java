package ch.test;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TestComponent {

    @Inject
    @ConfigProperty(name = "foo.bar")
    private String configValue;

    public String getConfigValue() {
        return configValue;
    }
}
