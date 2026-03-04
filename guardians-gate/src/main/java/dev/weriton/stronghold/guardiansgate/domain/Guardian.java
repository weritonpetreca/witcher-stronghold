package dev.weriton.stronghold.guardiansgate.domain;

import java.util.UUID;

/**
 * The core domain entity representing a Guardian.
 * <p>
 * This entity is isolated from all framework dependencies to ensure
 * business rules remain decoupled from infrastructure adapters.
 */
public class Guardian {

    private final UUID id;
    private final String name;
    private final GuardianRank rank;

    public Guardian(UUID id, String name, GuardianRank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GuardianRank getRank() {
        return rank;
    }
}
