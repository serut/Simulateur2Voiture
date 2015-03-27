package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineVoiture.Voiture;

public class IHM extends JFrame implements Observer{

	private final double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private List<Route> routes;
	private IHMParametreVoiture maIHMParametreVoiture;

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    public IHM(Voiture maVoiture, List<Route> routes) {
        super();
        this.maVoiture = maVoiture;
        this.routes = routes;
        maVoiture.addObserver(this);
        initGraphique();
    }

	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);
		this.maIHMParametreVoiture = new IHMParametreVoiture(this, maVoiture);
		this.setVisible(true);
	}

	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}


	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
        for (Route route : routes) {
            this.dessinerRoute(route, contexteGraphique);
        }
        dessinerVoiture(contexteGraphique);
	}

    public void dessinerRoute(Route route, Graphics contexteGraphique) {
        contexteGraphique.setColor(Color.pink);
        int xPixel = calculerPositionPixels(route.getX());
        int yPixel = calculerPositionPixels(route.getY());
        int largeur = calculerPositionPixels(route.getLongueur());
        int longueur = calculerPositionPixels(route.getLargeur());
        contexteGraphique.fillRect(xPixel, yPixel, largeur, longueur);
    }

	private void dessinerVoiture(Graphics contexteGraphique) {
        contexteGraphique.setColor(Color.red);
        int xPixel = calculerPositionPixels(maVoiture.getX());
        int yPixel = calculerPositionPixels(maVoiture.getY());
		contexteGraphique.fillRect(xPixel, yPixel, 30, 15);
	}
	
}
