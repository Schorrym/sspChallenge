package de.mariokramer.sspChallenge.model;

import de.mariokramer.sspChallenge.NoSuchObjectException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SspChallengeService {

    private static final Log LOG = LogFactory.getLog(SspChallengeService.class);

    /**
     * Ermittelt das Spielergebnis anhand der eingehenden Paramtern
     * @param objektTypSpieler
     * @param objektTypComputer
     * @return
     */
    public SpielErgebnis ermittleErgebnis(ObjektTyp objektTypSpieler, ObjektTyp objektTypComputer) {
        LOG.debug("ermittleErgebnis() -- Start");

        if(objektTypSpieler.equals(objektTypComputer)){
            return SpielErgebnis.unentschieden;
        }else {
            switch (objektTypSpieler.name()) {
                case "Schere":
                    if (objektTypComputer.equals(ObjektTyp.Papier)) {
                        return SpielErgebnis.gewonnen;
                    }
                    return SpielErgebnis.verloren;
                case "Stein":
                    if (objektTypComputer.equals(ObjektTyp.Schere)) {
                        return SpielErgebnis.gewonnen;
                    }
                    return SpielErgebnis.verloren;
                case "Papier":
                    if (objektTypComputer.equals(ObjektTyp.Schere)) {
                        return SpielErgebnis.verloren;
                    }
                    return SpielErgebnis.gewonnen;
                case "Brunnen":
                    if (objektTypComputer.equals(ObjektTyp.Papier)){
                        return SpielErgebnis.verloren;
                    }
                    return SpielErgebnis.gewonnen;
            }
        }
        throw new NoSuchObjectException();
    }

    /**
     * Generiert einen Zufälligen Objektyp der Menge{Schere, Stein, Papier, Brunnen}
     * @return
     */
    public ObjektTyp erzeugeObjektTypComputer() {
        Random r = new Random();
        int computerObjektCode = r.ints(1, (4 + 1)).limit(1).findFirst().getAsInt();
        LOG.debug("erzeugeObjektTypComputer() -- erzeugtes Integer: " + computerObjektCode);

        return ObjektTyp.values()[computerObjektCode-1];
    }


}
