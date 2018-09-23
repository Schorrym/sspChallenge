package de.mariokramer.sspChallenge.model;

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
public class SspChallengeModelComponentTest {

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
		SpielErgebnis ergebnis = this.sspChallengeModelComponent.getErgebnis();
		ObjektTyp objektSpieler = this.sspChallengeModelComponent.getObjektTypSpieler();
		ObjektTyp objektComputer = this.sspChallengeModelComponent.getObjektTypComputer();

		Assert.assertNotNull(ergebnis);
		Assert.assertNotNull(objektSpieler);
		Assert.assertNotNull(objektComputer);
	}

	@Test
	public void testObjektTypIndex() {
		ObjektTyp schere = ObjektTyp.Schere;
		ObjektTyp stein = ObjektTyp.Stein;
		ObjektTyp papier = ObjektTyp.Papier;
		ObjektTyp brunnen = ObjektTyp.Brunnen;

		Assert.assertTrue(schere.getObjektCode() == 1);
		Assert.assertTrue(stein.getObjektCode() == 2);
		Assert.assertTrue(papier.getObjektCode() == 3);
		Assert.assertTrue(brunnen.getObjektCode() == 4);
	}

}
