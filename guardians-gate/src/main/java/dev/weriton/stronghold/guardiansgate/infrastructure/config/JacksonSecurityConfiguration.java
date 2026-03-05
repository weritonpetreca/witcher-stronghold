package dev.weriton.stronghold.guardiansgate.infrastructure.config;

import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.cfg.CoercionAction;
import tools.jackson.databind.cfg.CoercionInputShape;
import tools.jackson.databind.type.LogicalType;

/**
 * Infrastructure configuration for strict JSON serialization/deserialization.
 * Enforces zero-trust data parsing by disabling implicit type coercion using Jackson 3.
 */
@Configuration
public class JacksonSecurityConfiguration {

    @Bean
    public JsonMapperBuilderCustomizer strictCoercionCustomizer() {
        // We configure the Builder directly, adhering to Jackson 3's immutability rules
        return builder -> {
            builder.withCoercionConfig(LogicalType.Textual, cfg -> {
                cfg.setCoercion(CoercionInputShape.Integer, CoercionAction.Fail);
                cfg.setCoercion(CoercionInputShape.Float, CoercionAction.Fail);
                cfg.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail);
            });
        };
    }
}