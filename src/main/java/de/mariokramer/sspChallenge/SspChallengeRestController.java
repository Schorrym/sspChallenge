package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SspChallengeModelComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Plain RestController, der den ermittelten Spielstand in Response als JSON-Daten liefert.
 */
@RestController
@RequestMapping
public class SspChallengeRestController {

    private static final Log LOG = LogFactory.getLog(SspChallengeRestController.class);

    @Autowired
    SspChallengeModelComponent sspChallengeModelComponent;

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Schere'
     * @return
     */
    @GetMapping(value = "/schere", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModelComponent spielMitSchere() {
        sspChallengeModelComponent.startGame(ObjektTyp.Schere);

        LOG.debug(this.sspChallengeModelComponent.getErgebnis());
        return this.sspChallengeModelComponent;
    }

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Stein'
     * @return
     */
    @GetMapping(value = "/stein", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModelComponent spielMitStein() {
        sspChallengeModelComponent.startGame(ObjektTyp.Stein);

        LOG.debug(this.sspChallengeModelComponent.getErgebnis());
        return this.sspChallengeModelComponent;
    }

    /**
     * Startet ein neues Spiel mit dem Gegenstand 'Papier'
     * @return
     */
    @GetMapping(value = "/papier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModelComponent spielMitPapier() {
        sspChallengeModelComponent.startGame(ObjektTyp.Papier);

        LOG.debug(this.sspChallengeModelComponent.getErgebnis());
        return this.sspChallengeModelComponent;
    }
}
