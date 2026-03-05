package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web;


import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase;
import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase.CreateGuardianCommand;
import dev.weriton.stronghold.guardiansgate.domain.model.Guardian;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    public ResponseEntity<GuardianResponse> registerGuardian(@Valid @RequestBody RegisterGuardianRequest request) {

        CreateGuardianCommand command = mapper.toCommand(request);
        Guardian newGuardian = createGuardianUseCase.execute(command);
        GuardianResponse response = mapper.toResponse(newGuardian);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // --- Web DTOs (Records specific to this controller) ---

    public record RegisterGuardianRequest(
            @NotBlank(message = "The Guardian's name must not be blank")
            @Pattern(regexp = "^[a-zA-Z0-9_-]+$",
                    message = "The Guardian's name must only contain letters," +
                            " numbers, underscores or hyphens.")
            String name,

            @NotBlank(message = "The Guardian's rank must be provided")
            @Pattern(regexp = "^(NOVICE|ADEPT|EXPERT|MASTER|GRANDMASTER)$",
                    message = "Invalid rank. Acceptable values are: NOVICE, ADEPT, EXPERT, MASTER, GRANDMASTER.")
            String rank) {}

    public record GuardianResponse(String id, String name, String rank) {}
}
