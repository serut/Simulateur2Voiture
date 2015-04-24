package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 0, 10);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
	}


    @Test
    public void testTournerGauche() {


        Voiture maVoiture2 = new Voiture (100, 100, 10);
        maVoiture2.setVitesse(1000);
        maVoiture2.directionGauche();
        maVoiture2.miseAJourPosition();
        assertEquals(270, maVoiture2.getDirection());
        maVoiture2.directionGauche();
        maVoiture2.miseAJourPosition();
        assertEquals(180, maVoiture2.getDirection());
        assertEquals(0, maVoiture2.getY());

    }

    @Test
    public void testTournerDroite() {


        Voiture maVoiture2 = new Voiture (100, 100, 10);
        maVoiture2.setVitesse(1000);
        maVoiture2.directionDroite();
        maVoiture2.miseAJourPosition();
        assertEquals(90, maVoiture2.getDirection());
        maVoiture2.directionDroite();
        maVoiture2.miseAJourPosition();
        assertEquals(180, maVoiture2.getDirection());

    }

    @Test
    public void testArreter() {
        Voiture maVoiture2 = new Voiture (100, 100, 10);
        maVoiture2.setVitesse(1000);
        maVoiture2.toggleStop();
        maVoiture2.miseAJourPosition();
        assertEquals(100, maVoiture2.getX());
        assertEquals(100, maVoiture2.getY());

    }
	
}
