package dev.weriton.stronghold.guardiansgate.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GuardianTest {

    @Test
    @DisplayName("Given a valid name and rank, When intantiating, Then the Guardian is created")
    void shouldCreateValidGuardian() {
        UUID id = UUID.randomUUID();
        Guardian guardian = new Guardian(id, "Geralt", GuardianRank.MASTER);

        assertThat(guardian.getId()).isEqualTo(id);
        assertThat(guardian.getName()).isEqualTo("Geralt");
        assertThat(guardian.getRank()).isEqualTo(GuardianRank.MASTER);
    }

    @Test
    @DisplayName("Given a null name, When instantiating, Then throw IllegalArgumentException")
    void shouldRejectNullName() {
        assertThatThrownBy(() -> new Guardian(UUID.randomUUID(), null, GuardianRank.NOVICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Guardian Name cannot be null or blank");
    }

    @Test
    @DisplayName("Given an blank name, When instantiating, Then throw IllegalArgumentException")
    void shouldRejectBlankName() {
        assertThatThrownBy(() -> new Guardian(UUID.randomUUID()," ", GuardianRank.NOVICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Guardian Name cannot be null or blank");
    }
}
