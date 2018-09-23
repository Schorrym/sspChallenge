package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SpielErgebnis;
import de.mariokramer.sspChallenge.model.SspChallengeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SspChallengeServiceTest {

    @Autowired
    SspChallengeService sspChallengeService;

    /**
     * Testet manuell alle Kombiantionen von Spielausgängen
     */
    @Test
    public void ermittleErgebnisTest(){
        SpielErgebnis ergebnisPapierStein = sspChallengeService.ermittleErgebnis(ObjektTyp.Papier, ObjektTyp.Stein);
        SpielErgebnis ergebnisSteinPapier = sspChallengeService.ermittleErgebnis(ObjektTyp.Stein, ObjektTyp.Papier);
        SpielErgebnis ergebnisPapierBrunnen = sspChallengeService.ermittleErgebnis(ObjektTyp.Papier, ObjektTyp.Brunnen);
        SpielErgebnis ergebnisBrunnenPapier = sspChallengeService.ermittleErgebnis(ObjektTyp.Brunnen, ObjektTyp.Papier);

        SpielErgebnis ergebnisPapierSchere = sspChallengeService.ermittleErgebnis(ObjektTyp.Papier, ObjektTyp.Schere);
        SpielErgebnis ergebnisScherePapier = sspChallengeService.ermittleErgebnis(ObjektTyp.Schere, ObjektTyp.Papier);
        SpielErgebnis ergebnisSchereBrunnen = sspChallengeService.ermittleErgebnis(ObjektTyp.Schere, ObjektTyp.Brunnen);
        SpielErgebnis ergebnisBrunnenSchere = sspChallengeService.ermittleErgebnis(ObjektTyp.Brunnen, ObjektTyp.Schere);

        SpielErgebnis ergebnisSchereStein = sspChallengeService.ermittleErgebnis(ObjektTyp.Schere, ObjektTyp.Stein);
        SpielErgebnis ergebnisSteinSchere = sspChallengeService.ermittleErgebnis(ObjektTyp.Stein, ObjektTyp.Schere);
        SpielErgebnis ergebnisSteinBrunnen = sspChallengeService.ermittleErgebnis(ObjektTyp.Stein, ObjektTyp.Brunnen);
        SpielErgebnis ergebnisBrunnenStein = sspChallengeService.ermittleErgebnis(ObjektTyp.Brunnen, ObjektTyp.Stein);

        Assert.assertTrue(ergebnisPapierStein.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisSteinPapier.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisPapierSchere.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisScherePapier.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisSchereStein.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisSteinSchere.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisPapierBrunnen.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisBrunnenPapier.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisSchereBrunnen.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisBrunnenSchere.equals(SpielErgebnis.gewonnen));
        Assert.assertTrue(ergebnisSteinBrunnen.equals(SpielErgebnis.verloren));
        Assert.assertTrue(ergebnisBrunnenStein.equals(SpielErgebnis.gewonnen));
    }

    /**
     * Erzeugt 20 Random ObjektTypen und testet diese Funktion
     */
    @Test
    public void erzeugeObjektTypComputerTest(){
        List<ObjektTyp> objektTypComputer = new ArrayList<>();

        IntStream.range(0, 20).forEach(index ->
                objektTypComputer.add( this.sspChallengeService.erzeugeObjektTypComputer() ));
        objektTypComputer.forEach(System.out::println);

        objektTypComputer.forEach(objekt -> Assert.assertNotNull(ObjektTyp.valueOf(objekt.name())));
    }

}
