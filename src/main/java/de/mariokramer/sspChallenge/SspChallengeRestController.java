package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SspChallengeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("newGame")
public class SspChallengeRestController {

    private static final Log LOG = LogFactory.getLog(SspChallengeRestController.class);

    @Autowired
    SspChallengeModel sspChallengeModel;

    @GetMapping(value = "/schere", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModel spielMitSchere() {
        sspChallengeModel.startGame(ObjektTyp.Schere);

        LOG.debug(this.sspChallengeModel.getErgebnis());
        return this.sspChallengeModel;
    }

    @GetMapping(value = "/stein", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModel spielMitStein() {
        sspChallengeModel.startGame(ObjektTyp.Stein);

        LOG.debug(this.sspChallengeModel.getErgebnis());
        return this.sspChallengeModel;
    }

    @GetMapping(value = "/papier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SspChallengeModel spielMitPapier() {
        sspChallengeModel.startGame(ObjektTyp.Papier);

        LOG.debug(this.sspChallengeModel.getErgebnis());
        return this.sspChallengeModel;
    }
}
