package AppliSimu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Leo on 27/03/15.
 */
public class TestRoute {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testInstanciationRoute() {
        Route route = new Route(400, 400, 10, 500);
        assertEquals(route.getLargeur(), 10);
    }

}
