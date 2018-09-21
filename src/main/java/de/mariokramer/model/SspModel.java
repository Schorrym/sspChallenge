package de.mariokramer.model;

/**
 * Hält die zu einem Spiel gehörenden Objekte
 */
public class SspModel {

    private ObjektTyp objektTypSpieler;
    private ObjektTyp objektTypComputer;
    private SpielErgebnis spielErgebnis;

    public SspModel(ObjektTyp objektTyp) {
        this.objektTypSpieler = objektTyp;
        this.objektTypComputer = SspChallengeCore.erzeugeObjektTypComputer();
        this.spielErgebnis = SspChallengeCore.ermittleErgebnis(this.objektTypSpieler, this.objektTypComputer);
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
