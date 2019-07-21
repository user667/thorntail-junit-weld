package ch.test;

import io.smallrye.config.inject.ConfigExtension;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(WeldJunit5AutoExtension.class)
public class TestComponentJunit5Test {

    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(
            WeldInitiator.createWeld().addExtensions(ConfigExtension.class).addBeanClass(TestComponent.class)
    ).build();

    @Inject
    TestComponent testComponent;

    @Test
    void givenMicroProfileConfig_whenInjectingAValue_thenICanUseItInJunitWeld() {
        assertEquals("quz", testComponent.getConfigValue());
    }
}
