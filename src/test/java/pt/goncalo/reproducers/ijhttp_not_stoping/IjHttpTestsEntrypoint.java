package pt.goncalo.reproducers.ijhttp_not_stoping;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pt.goncalo.reproducers.ijhttp_not_stoping.testcontainers.WithRedPanda;

@SpringBootApplication
@Import(
        WithRedPanda.class
)
public class IjHttpTestsEntrypoint {
    public static void main(String[] args) {
        IjhttpNotStopingApplication.main(args);
    }
}
