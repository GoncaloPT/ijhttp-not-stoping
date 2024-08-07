package pt.goncalo.reproducers.ijhttp_not_stoping.testcontainers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.redpanda.RedpandaContainer;


/**
 * RedPanda is a Kafka alternative that is faster and more efficient.
 */
@TestConfiguration
public class WithRedPanda {
    private static String SPRING_KAFKA_BOOTSTRAP_SERVERS = "spring.kafka.bootstrap-servers";
    private static String SPRING_KAFKA_SCHEMA_REGISTRY_URL = "spring.kafka.schema.registry.url";
    private RedpandaContainer redPanda = new RedpandaContainer("docker.redpanda.com/redpandadata/redpanda:v24.1.10");

    @Bean
    RedpandaContainer redPandaContainer() {
        redPanda.addEnv("allow.auto.create.topics", "true");
        redPanda.start();
        setupRequiredEnv(redPanda);
        return redPanda;
    }

    /**
     * Setup the required environment variables for our application to start.
     */
    private void setupRequiredEnv(RedpandaContainer redPanda) {
        System.setProperty(SPRING_KAFKA_BOOTSTRAP_SERVERS, redPanda.getBootstrapServers());
        System.setProperty(SPRING_KAFKA_SCHEMA_REGISTRY_URL, redPanda.getSchemaRegistryAddress());
    }
}
