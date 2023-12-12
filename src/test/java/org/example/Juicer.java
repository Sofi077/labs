package org.example;
import javax.inject.Inject;
public class Juicer {
    private final Peelable peelable;
    private final Peeler peeler;
    @Inject
    public Juicer(Peelable peelable, Peeler peeler) {
        this.peelable = peelable;
        this.peeler = peeler;
    }
}
