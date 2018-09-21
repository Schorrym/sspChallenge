package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SpielErgebnis;
import de.mariokramer.sspChallenge.model.SspChallengeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SspChallengeServiceTest {

    @Autowired
    SspChallengeService sspChallengeService;

    @Test
    public void ermittleErgebnisTest(){
        SpielErgebnis ergebnisPapierStein = sspChallengeService.ermittleErgebnis(ObjektTyp.Papier, ObjektTyp.Stein);
        SpielErgebnis ergebnisSteinpapier = sspChallengeService.ermittleErgebnis(ObjektTyp.Stein, ObjektTyp.Papier);

        SpielErgebnis ergebnisPapierSchere = sspChallengeService.ermittleErgebnis(ObjektTyp.Papier, ObjektTyp.Schere);
        SpielErgebnis ergebnisScherePapier = sspChallengeService.ermittleErgebnis(ObjektTyp.Schere, ObjektTyp.Papier);

        SpielErgebnis ergebnisSchereStein = sspChallengeService.ermittleErgebnis(ObjektTyp.Schere, ObjektTyp.Stein);
        SpielErgebnis ergebnisSteinSchere = sspChallengeService.ermittleErgebnis(ObjektTyp.Stein, ObjektTyp.Schere);

        Assert.assertTrue(ergebnisPapierStein.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisSteinpapier.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisPapierSchere.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisScherePapier.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisSchereStein.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisSteinSchere.equals(SpielErgebnis.gewonnen));
    }

    @Test
    public void erzeugeObjektTypComputerTest(){
        ObjektTyp objektTypComputer = this.sspChallengeService.erzeugeObjektTypComputer();
        ObjektTyp[] objektTyps = ObjektTyp.values();

        Assert.assertTrue(objektTypComputer.equals(objektTyps[0])
                            || objektTypComputer.equals(objektTyps[1])
                            || objektTypComputer.equals(objektTyps[2]));
    }

}
