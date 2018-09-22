package de.mariokramer.sspChallenge.model;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SpielErgebnis;
import de.mariokramer.sspChallenge.model.SspChallengeModelComponent;
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
public class SspChallengeModelComponentTests {

	@MockBean
	SspChallengeService sspChallengeService;

	@Autowired
	SspChallengeModelComponent sspChallengeModelComponent;

	@Test
	public void assertBeansNotNull(){
		Assert.assertNotNull(this.sspChallengeModelComponent);
		Assert.assertNotNull(this.sspChallengeService);
	}

	@Test
	public void testErgebnisNotNullDurchlauf() {
		Mockito.doReturn(ObjektTyp.Stein).when(sspChallengeService).erzeugeObjektTypComputer();
		Mockito.doReturn(SpielErgebnis.gewonnen).when(sspChallengeService).ermittleErgebnis(Mockito.any(),Mockito.any());
		this.sspChallengeModelComponent.startGame(ObjektTyp.Schere);
		String ergebnis = this.sspChallengeModelComponent.getErgebnis().name();

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
