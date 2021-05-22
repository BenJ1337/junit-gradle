package benj1337;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test_helloWorld() {
        Assertions.assertThat(Main.helloWorld()).isEqualTo("Hello World");
    }

}
