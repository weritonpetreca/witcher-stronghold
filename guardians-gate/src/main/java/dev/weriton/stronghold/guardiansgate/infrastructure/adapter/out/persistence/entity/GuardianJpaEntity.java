package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

/**
 * The persistence-specific entity representing a Guardian in the database.
 * This class is strictly utilized by the infrastructure layer and must not
 * leak into the core domain.
 */
@Entity
@Table(name = "guardians")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GuardianJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false)
    private String rank;
}
