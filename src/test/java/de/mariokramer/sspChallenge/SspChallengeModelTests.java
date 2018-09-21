package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SpielErgebnis;
import de.mariokramer.sspChallenge.model.SspChallengeModel;
import de.mariokramer.sspChallenge.model.SspChallengeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SspChallengeModelTests {

	@MockBean
	SspChallengeService sspChallengeService;

	@Autowired
	SspChallengeModel sspChallengeModel;

	@Test
	public void assertBeansNotNull(){
		Assert.assertNotNull(this.sspChallengeModel);
		Assert.assertNotNull(this.sspChallengeService);
	}

	@Test
	public void testErgebnisNotNullDurchlauf() {
		Mockito.doReturn(ObjektTyp.Stein).when(sspChallengeService).erzeugeObjektTypComputer();
		Mockito.doReturn(SpielErgebnis.gewonnen).when(sspChallengeService).ermittleErgebnis(Mockito.any(),Mockito.any());
		this.sspChallengeModel.startGame(ObjektTyp.Schere);
		String ergebnis = this.sspChallengeModel.getErgebnis().name();

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
