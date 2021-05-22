import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class NachrichtTest {

    @Test
    void test_neueNachricht() throws InterruptedException {
        final String testNachricht = "Hallo an den Leser dieser Nachricht.";
        LocalDateTime start = LocalDateTime.now();
        Thread.sleep(1);
        Nachricht msg = new Nachricht(testNachricht);
        Thread.sleep(1);
        assertThat(msg).extracting(Nachricht::getText).isNotNull().isEqualTo(testNachricht);
        assertThat(msg).is(new Condition<>(n -> n.getZeitstempel().isBefore(LocalDateTime.now()), "1"));
        assertThat(msg).is(new Condition<>(n -> n.getZeitstempel().isAfter(start), "2"));
    }

    @Test
    void test_mock() {
        final String text = "Hello Mockito";
        final LocalDateTime zeitstempel = LocalDateTime.now();
        Nachricht nachricht = mock(Nachricht.class);
        doReturn(text).when(nachricht).getText();
        doReturn(zeitstempel).when(nachricht).getZeitstempel();
        assertThat(nachricht).isNotNull();
        assertThat(nachricht).extracting(Nachricht::getText).isEqualTo(text);
        assertThat(nachricht).extracting(Nachricht::getZeitstempel).isEqualTo(zeitstempel);
    }
}
