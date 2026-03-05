package dev.weriton.stronghold.guardiansgate.application.port.in;

import dev.weriton.stronghold.guardiansgate.domain.model.Guardian;
import dev.weriton.stronghold.guardiansgate.domain.model.GuardianRank;

/**
 * Inbound port (Use Case) defining the contract for registering a new Guardian.
 * <p>
 * External adapters (such as REST Controllers) will invoke this interface
 * to execute the business logic, remaining completely decoupled from the implementation.
 */
public interface CreateGuardianUseCase {

    /**
     * Executes the creation of a Guardian based on the provided command.
     *
     * @param command The immutable data transfer object containing registration details.
     * @return The fully instantiated Guardian entity.
     */
    Guardian execute(CreateGuardianCommand command);

    /**
     * A Command object (DTO) encapsulating the required data to create a Guardian.
     * Implemented as a Java Record to guarantee absolute immutability.
     */
    record CreateGuardianCommand(String name, GuardianRank rank) {}
}
