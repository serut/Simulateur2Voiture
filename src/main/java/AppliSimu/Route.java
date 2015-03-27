package AppliSimu;

import DomaineVoiture.Voiture;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Leo on 27/03/15.
 */
public class Route {

    private int x;
    private int y;
    private int largeur;
    private int longueur;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public Route(int x, int y, int largeur, int longueur) {
        super();
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.longueur = longueur;
    }
}
