package AppliSimu;


import static org.junit.Assert.*;

import DomaineVoiture.Voiture;
import org.junit.Before;
import org.junit.Test;

public class TestTriangle {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConversionMetresPixels() {
		Voiture car = new Voiture(100, 0, 10);
		IHM monTriangle = new IHM(car);
		int xPixels = monTriangle.calculerPositionPixels(110);
		
		assertEquals(55, xPixels);
	}

}
