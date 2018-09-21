package de.mariokramer.model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class SspModel {

    private final AtomicLong counter = new AtomicLong();

    private ObjektTyp objektTypSpieler;
    private ObjektTyp objektTypComputer;
    private SpielErgebnis spielErgebnis;


    public SspModel(ObjektTyp objektTyp) {
        this.counter.incrementAndGet();
        this.objektTypSpieler = objektTyp;
        erzeugeObjektTypComputer();
        ermittleErgebnis();
    }

    private void ermittleErgebnis() {
        if(this.objektTypSpieler.equals(this.objektTypComputer)){
            this.spielErgebnis = SpielErgebnis.unentschieden;
        }else {
            switch (this.objektTypSpieler.getObjektCode()) {
                case 1:
                    if (this.objektTypComputer.getObjektCode() == 2) {
                        this.spielErgebnis = SpielErgebnis.verloren;
                        break;
                    }
                    this.spielErgebnis = SpielErgebnis.gewonnen;
                    break;
                case 2:
                    if (this.objektTypComputer.getObjektCode() == 1) {
                        this.spielErgebnis = SpielErgebnis.gewonnen;
                        break;
                    }
                    this.spielErgebnis = SpielErgebnis.verloren;
                    break;
                case 3:
                    if (this.objektTypComputer.getObjektCode() == 2) {
                        this.spielErgebnis = SpielErgebnis.gewonnen;
                        break;
                    }
                    this.spielErgebnis = SpielErgebnis.verloren;
                    break;
            }
        }
    }

    private void erzeugeObjektTypComputer() {
        Random r = new Random();
        int computerObjektCode = r.ints(1, (3 + 1)).limit(1).findFirst().getAsInt();

        switch (computerObjektCode) {
            case 1:
                this.objektTypComputer = ObjektTyp.Schere;
                break;
            case 2:
                this.objektTypComputer = ObjektTyp.Stein;
                break;
            case 3:
                this.objektTypComputer = ObjektTyp.Papier;
                break;
        }
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
