package dev.weriton.stronghold.guardiansgate.application.port.out;

import dev.weriton.stronghold.guardiansgate.domain.Guardian;

/**
 * Outbound port defining the contract for Guardian persistence.
 * <p>
 * This interface allows the application layer to save domain entities
 * without coupling to a specific database technology or framework.
 */
public interface SaveGuardianPort {

    /**
     * Persists the given Guardian entity to the underlying storage mechanism.
     *
     * @param guardian The core domain entity to be saved.
     * @return The persisted Guardian.
     */
    Guardian save(Guardian guardian);
}
