package it.pagopa.selfcare.product.connector.dao.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(DaoConfig.class)
public class DaoTestConfig {
}