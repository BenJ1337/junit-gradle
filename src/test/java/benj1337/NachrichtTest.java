package benj1337;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class NachrichtTest {

    @Test
    void test_neueNachricht() throws InterruptedException {
        final String testNachricht = "Hallo an den Leser dieser benj1337.Nachricht.";
        LocalDateTime start = LocalDateTime.now();
        Thread.sleep(1);
        Nachricht msg = new Nachricht(testNachricht);
        Thread.sleep(1);
        Assertions.assertThat(msg).extracting(Nachricht::getText).isNotNull().isEqualTo(testNachricht);
        Assertions.assertThat(msg).is(new Condition<>(n -> n.getZeitstempel().isBefore(LocalDateTime.now()), "1"));
        Assertions.assertThat(msg).is(new Condition<>(n -> n.getZeitstempel().isAfter(start), "2"));
    }

    @Test
    void test_mock() {
        final String text = "Hello Mockito";
        final LocalDateTime zeitstempel = LocalDateTime.now();
        Nachricht nachricht = mock(Nachricht.class);
        doReturn(text).when(nachricht).getText();
        doReturn(zeitstempel).when(nachricht).getZeitstempel();
        Assertions.assertThat(nachricht).isNotNull();
        Assertions.assertThat(nachricht).extracting(Nachricht::getText).isEqualTo(text);
        Assertions.assertThat(nachricht).extracting(Nachricht::getZeitstempel).isEqualTo(zeitstempel);
    }
}
