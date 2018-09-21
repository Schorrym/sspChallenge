package de.mariokramer.model;

import de.mariokramer.sspChallenge.NoSuchObjectException;

import java.util.Random;

public class SspChallengeCore {

    /**
     * Ermittelt das Spielergebnis anhand der eingehenden Paramtern
     * @param objektTypSpieler
     * @param objektTypComputer
     * @return
     */
    public static SpielErgebnis ermittleErgebnis(ObjektTyp objektTypSpieler, ObjektTyp objektTypComputer) {
        if(objektTypSpieler.equals(objektTypComputer)){
            return SpielErgebnis.unentschieden;
        }else {
            switch (objektTypSpieler.getObjektCode()) {
                case 1:
                    if (objektTypComputer.getObjektCode() == 2) {
                        return SpielErgebnis.verloren;
                    }
                    return SpielErgebnis.gewonnen;
                case 2:
                    if (objektTypComputer.getObjektCode() == 1) {
                        return SpielErgebnis.gewonnen;
                    }
                    return SpielErgebnis.verloren;
                case 3:
                    if (objektTypComputer.getObjektCode() == 2) {
                        return SpielErgebnis.gewonnen;
                    }
                    return SpielErgebnis.verloren;
            }
        }
        throw new NoSuchObjectException();
    }

    /**
     * Generiert einen Zufälligen Objektyp der Menge{Schere, Stein, Papier}
     * @return
     */
    public static ObjektTyp erzeugeObjektTypComputer() {
        Random r = new Random();
        int computerObjektCode = r.ints(1, (3 + 1)).limit(1).findFirst().getAsInt();

        switch (computerObjektCode) {
            case 1:
                return ObjektTyp.Schere;
            case 2:
                return ObjektTyp.Stein;
            case 3:
                return ObjektTyp.Papier;
        }
        throw new NoSuchObjectException();
    }


}
