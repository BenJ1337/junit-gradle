package benj1337;

import java.time.LocalDateTime;

public class Nachricht {

    private String text;
    private LocalDateTime zeitstempel;

    public Nachricht(String text) {
        this.text = text;
        this.zeitstempel = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(LocalDateTime zeitstempel) {
        this.zeitstempel = zeitstempel;
    }
}
