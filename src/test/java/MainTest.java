import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    void test_helloWorld() {
        assertThat(Main.helloWorld()).isEqualTo("Hello World");
    }

}
