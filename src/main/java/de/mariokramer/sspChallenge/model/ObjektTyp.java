package de.mariokramer.sspChallenge.model;

import de.mariokramer.sspChallenge.NoSuchObjectException;

/**
 * Repräsentiert die drei möglichen Objekte
 */
public enum ObjektTyp {
    Schere(1),
    Stein(2),
    Papier(3),
    Brunnen(4);

    private final int objektCode;

    ObjektTyp(int i) {
        this.objektCode = i;
    }

    public int getObjektCode() {
        return this.objektCode;
    }

    public static ObjektTyp sucheObjektTyp(String suchWort) {
        for (ObjektTyp objektTyp : ObjektTyp.values()) {
            if (objektTyp.name().compareToIgnoreCase(suchWort) == 0) {
                return objektTyp;
            }
        }
        throw new NoSuchObjectException("Kein Objekt namens '" + suchWort + "' gefunden");
    }

}
