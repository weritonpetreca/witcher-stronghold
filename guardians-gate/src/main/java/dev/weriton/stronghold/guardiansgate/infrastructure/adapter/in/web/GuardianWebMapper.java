package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web;

import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase.CreateGuardianCommand;
import dev.weriton.stronghold.guardiansgate.domain.Guardian;
import dev.weriton.stronghold.guardiansgate.domain.GuardianRank;
import dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web.GuardianController.GuardianResponse;
import dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web.GuardianController.RegisterGuardianRequest;
import org.springframework.stereotype.Component;

/**
 * Assembler responsible for translating between external Web DTOs
 * and internal Application Commands/Domain Entities.
 */
@Component
class GuardianWebMapper {

    CreateGuardianCommand toCommand(RegisterGuardianRequest request) {
        return new CreateGuardianCommand(
                request.name(),
                GuardianRank.valueOf(request.rank().toUpperCase())
        );
    }

    GuardianResponse toResponse(Guardian guardian) {
        return new GuardianResponse(
                guardian.getId().toString(),
                guardian.getName(),
                guardian.getRank().name()
        );
    }
}
