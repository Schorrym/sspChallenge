package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SspChallengeModelComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Haupt-Controller für die View 'newGame'
 * Ermittelt Spielausgang und Daten aus der ModelComponente
 */
@Controller
public class SspChallengeController {

    @Autowired
    SspChallengeModelComponent sspChallengeModelComponent;

    @GetMapping("/newGame")
    public String greeting(final Model model) {
        return "newGame";
    }

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Schere'
     * @param model
     * @return
     */
    @GetMapping(value = "newGame/schere", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String spielMitSchere(final Model model) {
        sspChallengeModelComponent.startGame(ObjektTyp.Schere);
        model.addAllAttributes(getSpielInfoMap());

        return "newGame";
    }

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Stein'
     * @param model
     * @return
     */
    @GetMapping(value = "newGame/stein", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String spielMitStein(final Model model) {
        sspChallengeModelComponent.startGame(ObjektTyp.Stein);
        model.addAllAttributes(getSpielInfoMap());

        return "newGame";
    }

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Papier'
     * @param model
     * @return
     */
    @GetMapping(value = "newGame/papier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String spielMitPapier(final Model model) {
        sspChallengeModelComponent.startGame(ObjektTyp.Papier);
        model.addAllAttributes(getSpielInfoMap());

        return "newGame";
    }

    /**
     * Ermittelt alle Informationen aus einem Spiel und schreibt diese in einer Map zusammen
     * @return
     */
    private Map<String, String> getSpielInfoMap(){
        Map<String, String> spielInfoMap = new HashMap<>();
        spielInfoMap.put("spielerAuswahl", this.sspChallengeModelComponent.getObjektTypSpieler().name());
        spielInfoMap.put("computerAuswahl", this.sspChallengeModelComponent.getObjektTypComputer().name());
        spielInfoMap.put("spielErgebnis", this.sspChallengeModelComponent.getErgebnis().name());

        return spielInfoMap;
    }


}
