package AppliSimu;

import DomaineVoiture.Voiture;

import java.awt.*;
import java.util.List;
import java.util.Observable;
import javax.swing.*;

/**
 * Created by Leo on 10/04/15.
 */
public class IHMCircuit extends JPanel {
    private final double paramatreConversionMetresPixels = 0.5;
    private Voiture maVoiture;
    private List<Route> routes;
    private IHMParametreVoiture maIHMParametreVoiture;

    public IHMCircuit(Voiture maVoiture, List<Route> routes) {
        super();
        this.maVoiture = maVoiture;
        this.routes = routes;
        this.repaint();
    }

    public int calculerPositionPixels(int xMetres) {
        return (int) (paramatreConversionMetresPixels * xMetres);
    }

    public void paintComponent(Graphics contexteGraphique) {
        super.paintComponent(contexteGraphique);
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
