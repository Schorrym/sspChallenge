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
    public ObjektTyp erzeugeObjektTypComputer() {
        Random r = new Random();
        int computerObjektCode = r.ints(1, (3 + 1)).limit(1).findFirst().getAsInt();
        LOG.debug("erzeugeObjektTypComputer() -- erzeugtes Integer: " + computerObjektCode);

        return ObjektTyp.values()[computerObjektCode-1];
    }


}
