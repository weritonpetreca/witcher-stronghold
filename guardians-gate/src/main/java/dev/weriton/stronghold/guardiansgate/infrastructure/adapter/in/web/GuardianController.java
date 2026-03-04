package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web;


import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase;
import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase.CreateGuardianCommand;
import dev.weriton.stronghold.guardiansgate.domain.Guardian;
import dev.weriton.stronghold.guardiansgate.domain.GuardianRank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Primary adapter handling HTTP REST requests for Guardian operations.
 * This controller acts strictly as an HTTP endpoint, delegating mapping
 * and business logic to their respective components.
 */
@RestController
@RequestMapping("/api/v1/guardians")
public class GuardianController {

    private final CreateGuardianUseCase createGuardianUseCase;
    private final GuardianWebMapper mapper;

    public GuardianController(CreateGuardianUseCase createGuardianUseCase, GuardianWebMapper mapper) {
        this.createGuardianUseCase = createGuardianUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<GuardianResponse> registerGuardian(@RequestBody RegisterGuardianRequest request) {

        CreateGuardianCommand command = mapper.toCommand(request);
        Guardian newGuardian = createGuardianUseCase.execute(command);
        GuardianResponse response = mapper.toResponse(newGuardian);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // --- Web DTOs (Records specific to this controller) ---

    public record RegisterGuardianRequest(String name, String rank) {}

    public record GuardianResponse(String id, String name, String rank) {}
}
