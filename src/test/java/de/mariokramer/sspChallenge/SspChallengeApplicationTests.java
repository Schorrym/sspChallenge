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
	public void contextLoads() {
		SspModel neueRunde =  new SspModel(ObjektTyp.Schere);
		String ergebnis = neueRunde.getErgebnis().name();

		System.out.println(ergebnis);
		Assert.assertNotNull(ergebnis);
	}

	@Test
	public  void testRandom() {
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));
		System.out.println(getRandomNumberInRange(1,3));

	}

	private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

	}

}
