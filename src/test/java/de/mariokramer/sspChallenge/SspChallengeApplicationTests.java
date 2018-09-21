package de.mariokramer.sspChallenge;

import de.mariokramer.model.ObjektTyp;
import de.mariokramer.model.SspModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SspChallengeApplicationTests {

	@Test
	public void testErgebnisNotNullDurchlauf() {
		SspModel neueRunde =  new SspModel(ObjektTyp.Schere);
		String ergebnis = neueRunde.getErgebnis().name();

		Assert.assertNotNull(ergebnis);
	}

	@Test
	public void testObjektTypIndex() {
		ObjektTyp schere = ObjektTyp.Schere;
		ObjektTyp stein = ObjektTyp.Stein;
		ObjektTyp papier = ObjektTyp.Papier;

		Assert.assertTrue(schere.getObjektCode() == 1);
		Assert.assertTrue(stein.getObjektCode() == 2);
		Assert.assertTrue(papier.getObjektCode() == 3);
	}

}
