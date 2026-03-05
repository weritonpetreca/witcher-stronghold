package dev.weriton.stronghold.guardiansgate.infrastructure.config;

import dev.weriton.stronghold.guardiansgate.application.port.out.SaveGuardianPort;
import dev.weriton.stronghold.guardiansgate.application.service.GuardianRegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Infrastructure configuration responsible for instantiating pure domain/application
 * services as Spring Beans. This preserves the framework-agnostic nature of the inner hexagon.
 */
@Configuration
public class GuardianBeanConfiguration {

    /**
     * Wires the outbound persistence port into the application service.
     *
     * @param saveGuardianPort The Spring-managed adapter implementation.
     * @return The pure Java application service.
     */
    @Bean
    public GuardianRegistrationService createGuardianUseCase(SaveGuardianPort saveGuardianPort) {
        return new GuardianRegistrationService(saveGuardianPort);
    }
}
