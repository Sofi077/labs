package org.example2;


public class Peeler implements Startable {
    private final Peelable peelable;
    public Peeler() {
        this.peelable = null;
    }
    public Peeler(Peelable peelable) {
        this.peelable = peelable;
    }
    public void start() {
        peelable.peel();
    }
    public void stop() { }
}