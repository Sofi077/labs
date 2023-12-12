package org.example2;
import javax.inject.Inject;

public class Juicer {
    private final Peelable peelable;
    private final Peeler peeler;

    public Juicer() {
        this.peelable = null;
        this.peeler = null;
    }
    public Juicer(Peelable peelable, Peeler peeler) {
        this.peelable = peelable;
        this.peeler = peeler;
    }
}
