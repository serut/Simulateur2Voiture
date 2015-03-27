package AppliSimu;


import static org.junit.Assert.*;

import DomaineVoiture.Voiture;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestIHM {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConversionMetresPixels() {
		Voiture car = new Voiture(100, 0, 10);
		IHM monIHM = new IHM(car, new ArrayList<Route>());
        monIHM.setVisible(false);
        int xPixels = monIHM.calculerPositionPixels(110);
		
		assertEquals(55, xPixels);
	}

    @Test
    public void testCreationRoute() {
        Voiture car = new Voiture(100, 0, 10);
        List<Route> routes = new ArrayList<Route>();
        routes.add(new Route(400, 400, 10, 500));
        IHM monIHM = new IHM(car, routes);

        int xPixels = monIHM.calculerPositionPixels(110);
        monIHM.setVisible(false);

    }
}
