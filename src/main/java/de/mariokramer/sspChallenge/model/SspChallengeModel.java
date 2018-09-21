package de.mariokramer.sspChallenge.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hält die zu einem Spiel gehörenden Objekte
 */
@Component
public class SspChallengeModel {

    private ObjektTyp objektTypSpieler;
    private ObjektTyp objektTypComputer;
    private SpielErgebnis spielErgebnis;

    @Autowired
    private SspChallengeService sspChallengeService;

    /**
     * Startet ein Spiel mit gegebenem Objekt als Parameter
     * generiert mittels SspChallengeService ein Objekt für den Computer
     * ermittelt das ergebnis ebenfalls über den SspChallengeService
     * @param objektTyp
     */
    public void startGame(ObjektTyp objektTyp) {
        this.objektTypSpieler = objektTyp;
        this.objektTypComputer = sspChallengeService.erzeugeObjektTypComputer();
        this.spielErgebnis = sspChallengeService.ermittleErgebnis(this.objektTypSpieler, this.objektTypComputer);
    }

    public SpielErgebnis getErgebnis() {
        return spielErgebnis;
    }

    public ObjektTyp getObjektTypSpieler() {
        return objektTypSpieler;
    }

    public ObjektTyp getObjektTypComputer() {
        return objektTypComputer;
    }
}
