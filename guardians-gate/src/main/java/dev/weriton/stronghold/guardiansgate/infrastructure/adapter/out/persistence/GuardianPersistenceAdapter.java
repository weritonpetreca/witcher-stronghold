package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence;

import dev.weriton.stronghold.guardiansgate.application.port.out.SaveGuardianPort;
import dev.weriton.stronghold.guardiansgate.domain.model.Guardian;
import dev.weriton.stronghold.guardiansgate.domain.model.GuardianRank;
import dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence.entity.GuardianJpaEntity;
import dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence.repository.GuardianRepository;
import org.springframework.stereotype.Component;

/**
 * Secondary adapter implementing the outbound port for Guardian persistence.
 * Responsible for mapping pure domain entities to JPA entities and vice versa.
 */
@Component
public class GuardianPersistenceAdapter implements SaveGuardianPort {

    private final GuardianRepository guardianRepository;

    public GuardianPersistenceAdapter(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    @Override
    public Guardian save(Guardian guardian) {
        // 1. Map Domain Entity to JPA Entity
        GuardianJpaEntity jpaEntity = new GuardianJpaEntity(
                guardian.getId(),
                guardian.getName(),
                guardian.getRank().name()
        );

        // 2. Persist to Database
        GuardianJpaEntity savedEntity = guardianRepository.save(jpaEntity);

        // 3. Map JPA Entity back to Domain Entity
        return new Guardian(
                savedEntity.getId(),
                savedEntity.getName(),
                GuardianRank.valueOf(savedEntity.getRank())
        );
    }
}
