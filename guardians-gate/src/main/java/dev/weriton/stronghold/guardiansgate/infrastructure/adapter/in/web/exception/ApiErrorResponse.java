package dev.weriton.stronghold.guardiansgate.infrastructure.adapter.in.web.exception;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Standardized JSON structure for all API errors, ensuring consistent
 * error contract consumption for frontend clients and API gateways.
 */
public record ApiErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        List<String> details
) {
}
