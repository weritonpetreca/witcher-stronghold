package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence.repository;

import dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence.entity.GuardianJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuardianRepository extends JpaRepository<GuardianJpaEntity, UUID> {
}
