package it.pagopa.selfcare.product.web.config;

import it.pagopa.selfcare.commons.web.config.BaseWebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BaseWebConfig.class)
class WebConfig {
}
