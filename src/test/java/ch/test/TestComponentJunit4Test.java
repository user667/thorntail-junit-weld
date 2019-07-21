package ch.test;

import io.smallrye.config.inject.ConfigExtension;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class TestComponentJunit4Test {

    @Rule
    public WeldInitiator weld = WeldInitiator
            .from(WeldInitiator.createWeld()
                    .addExtensions(ConfigExtension.class)
                    .addBeanClass(TestComponent.class)
            )
            .inject(this)
            .build();

    @Inject
    private TestComponent testComponent;

    @Test
    public void givenMicroProfileConfig_whenInjectingAValue_thenICanUseItInJunitWeld() {
        assertEquals("quz", testComponent.getConfigValue());
    }
}
