package de.mariokramer.sspChallenge;

import de.mariokramer.model.ObjektTyp;
import de.mariokramer.model.SspModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SspChallangeRestController {

    @RequestMapping("/")
    public SspModel newGame(@RequestParam(value="name", defaultValue="Schere") String name) {
        ObjektTyp objektTyp = ObjektTyp.valueOf(name);
        SspModel neueRunde = new SspModel(objektTyp);



        return neueRunde;
    }

}
