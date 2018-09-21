package de.mariokramer.sspChallenge.model;

/**
 * Repräsentiert die drei möglichen Objekte
 */
public enum ObjektTyp {
    Schere(1),
    Stein(2),
    Papier(3);

    private final int objektCode;

    ObjektTyp(int i) {
        this.objektCode = i;
    }

    public int getObjektCode() {
        return this.objektCode;
    }

}
