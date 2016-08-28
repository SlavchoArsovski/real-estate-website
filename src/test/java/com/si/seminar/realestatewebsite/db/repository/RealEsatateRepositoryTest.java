//package com.si.seminar.realestatewebsite.db.repository;
//
//import java.util.List;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.netcetera.girders.persistence.abstraction.jpa.GirdersPersistenceAbstractionJpaComponents;
//import com.netcetera.girders.persistence.datasource.embedded.GirdersPersistenceDataSourceEmbeddedComponents;
//import com.netcetera.girders.test.db.AbstractXmlDbTestCase;
//import com.netcetera.std.transact.secure.gateway.persistence.datamodel.Registration;
//
//import static org.hamcrest.Matchers.comparesEqualTo;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertThat;
//
///**
// * Contains tests for {@link RegistrationRepositoryImpl}.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//public class RegistrationRepositoryTest extends AbstractXmlDbTestCase {
//
//  /**
//   * Configuration for the test.
//   */
//  @Configuration
//  @ComponentScan(
//      basePackageClasses = {
//          GirdersPersistenceDataSourceEmbeddedComponents.class,
//          GirdersPersistenceAbstractionJpaComponents.class })
//  @EnableJpaRepositories(basePackageClasses = TransaktSimulatorRepositoryComponents.class)
//  @EnableTransactionManagement
//  static class TestConfiguration {
//
//    private static final String CONFIG_TEST_PROPERTIES = "config-test.properties";
//
//    /**
//     * Configure property placeholder configurer.
//     *
//     * @return {@link PropertyPlaceholderConfigurer}.
//     */
//    @Bean
//    public PropertyPlaceholderConfigurer dbPropertiesConfigurer() {
//
//      PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
//
//      configurer.setLocations(new Resource[]{new ClassPathResource(CONFIG_TEST_PROPERTIES)});
//      configurer.setIgnoreUnresolvablePlaceholders(true);
//
//      return configurer;
//    }
//  }
//
//  @Autowired
//  private RegistrationRepository registrationRepository;
//
//  /**
//   * Test.
//   */
//  @Test
//  public void shouldRetreiveRealEstateByDigitalId() {
//
//    // Given
//    Long digitalId = Long.valueOf(1000);
//
//    // When
//    Registration registration = registrationRepository.findOne(digitalId);
//
//    // Then
//    assertThat(registration.getDigitalId(), comparesEqualTo(digitalId));
//    assertThat(registration.getRegistrationStatus(), comparesEqualTo("SUCCESSFUL"));
//    assertThat(registration.getSignupCode(), comparesEqualTo("1234567890"));
//    assertThat(registration.getSubjectId(), comparesEqualTo("100000"));
//    assertThat(registration.getCallbackUrl(), comparesEqualTo("http://none"));
//  }
//
//}
