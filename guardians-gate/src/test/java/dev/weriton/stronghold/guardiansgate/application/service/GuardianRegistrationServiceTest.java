package dev.weriton.stronghold.guardiansgate.application.service;

import dev.weriton.stronghold.guardiansgate.application.port.in.CreateGuardianUseCase.CreateGuardianCommand;
import dev.weriton.stronghold.guardiansgate.application.port.out.SaveGuardianPort;
import dev.weriton.stronghold.guardiansgate.domain.model.Guardian;
import dev.weriton.stronghold.guardiansgate.domain.model.GuardianRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class GuardianRegistrationServiceTest {

    @Mock
    private SaveGuardianPort saveGuardianPort;

    @InjectMocks
    private GuardianRegistrationService guardianRegistrationService;

    @Test
    @DisplayName("Given valid command, When execute is called, Then Guardian is saved and returned")
    void shouldSuccessfullyRegisterANewGuardian() {

        // GIVEN (The Setup)
        String alias = "White_Wolf";
        GuardianRank rank = GuardianRank.MASTER;
        CreateGuardianCommand command = new CreateGuardianCommand(alias, rank);

        // BDDMockito uses "given().willAnswer()" instead of "when().thenAnswer()"
        given(saveGuardianPort.save(any(Guardian.class))).willAnswer(invocation -> invocation.getArgument(0));

        // WHEN (The Execution)
        Guardian registeredGuardian = guardianRegistrationService.execute(command);

        // THEN (The Verification)
        // AssertJ allows us to chain readable validation
        assertThat(registeredGuardian)
                .isNotNull()
                .satisfies(guardian -> {
                    assertThat(guardian.getId()).isNotNull();
                    assertThat(guardian.getName()).isEqualTo(alias);
                    assertThat(guardian.getRank()).isEqualTo(rank);
                });

        // BDDMockito uses "then().should()" instead of "verify()"
        then(saveGuardianPort).should().save(any(Guardian.class));
    }
}
