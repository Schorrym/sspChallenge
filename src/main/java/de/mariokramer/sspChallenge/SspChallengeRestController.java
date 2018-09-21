package de.mariokramer.sspChallenge;

import de.mariokramer.model.ObjektTyp;
import de.mariokramer.model.SspModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("newGame")
public class SspChallengeRestController {

    @GetMapping(value = "/schere", produces = "application/json")
    public SspModel spielMitSchere() {
        return new SspModel(ObjektTyp.Schere);
    }

    @GetMapping(value = "/stein", produces = "application/json")
    public SspModel spielMitStein() {
        return new SspModel(ObjektTyp.Stein);
    }

    @GetMapping(value = "/papier", produces = "application/json")
    public SspModel spielMitPapier() {
        return new SspModel(ObjektTyp.Papier);
    }

}
