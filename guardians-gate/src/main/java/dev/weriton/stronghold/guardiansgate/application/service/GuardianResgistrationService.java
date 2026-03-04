package dev.weriton.stronghold.guardiansgate.application.service;

import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase;
import dev.weriton.stronghold.guardiansgate.application.port.out.SaveGuardianPort;
import dev.weriton.stronghold.guardiansgate.domain.Guardian;

import java.util.UUID;

/**
 * Application service orchestrating the registration of a new Guardian.
 * <p>
 * This class implements the inbound use case and coordinates between
 * the pure domain model and the outbound persistence ports.
 */
public class GuardianResgistrationService implements CreateGuardianUseCase {

    private final SaveGuardianPort saveGuardianPort;

    /**
     * Constructs the service utilizing constructor injection.
     * Framework annotations (e.g., \@Autowired) are strictly avoided here
     * to maintain environmental decoupling.
     *
     * @param saveGuardianPort The outbound port for Guardian persistence.
     */
    public GuardianResgistrationService(SaveGuardianPort saveGuardianPort) {
        this.saveGuardianPort = saveGuardianPort;
    }

    @Override
    public Guardian execute(CreateGuardianCommand command) {
        // 1. Generate system-assigned identity
        UUID newId = UUID.randomUUID();

        // 2. Instantiate the pure Domain Entity
        Guardian newGuardian = new Guardian(newId, command.name(), command.rank());

        // 3. Delegate persistence to the Outbound Port
        return saveGuardianPort.save(newGuardian);
    }
}
