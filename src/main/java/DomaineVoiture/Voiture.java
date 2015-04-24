package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;
    private boolean isStop;

	public Voiture(int x, int y, int vitesse) {
		this.x = x;
		this.y = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
        this.isStop = false;
	}

    public Object getVitesse() {
        return vitesseMetreSeconde;
    }

    public void setVitesse(int vitesse) {
        vitesseMetreSeconde = vitesse;
    }

    public void setDirection(int angleDirection) {
        this.directionEnDegres = angleDirection;
    }
    public Object getDirection() {
        return directionEnDegres;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void accelerer() {
        if (vitesseMetreSeconde < 100)
            vitesseMetreSeconde += 10;
    }

    public void inverserDirection() {
        directionEnDegres +=180 ;
        directionEnDegres = directionEnDegres % 360;
    }

	public void miseAJourPosition() {
        if (!isStop) {
            x += (int) (Math.cos(Math.toRadians(directionEnDegres)) * vitesseMetreSeconde);
            y += (int) (Math.sin(Math.toRadians(directionEnDegres))  * vitesseMetreSeconde);
        }
        if (x > 1000)
            x = 1000;
        else if (x < 0)
            x = 0;

        if (y > 1000)
            y = 1000;
        else if (y < 0)
            y = 0;
		notificationObservateur();
	}

    public void directionGauche() {
        directionEnDegres -= 90 ;
        if (directionEnDegres < 0) {
            directionEnDegres += 360;
        }
        directionEnDegres = directionEnDegres % 360;
    }

    public void directionDroite() {
        directionEnDegres += 90 ;
        directionEnDegres = directionEnDegres % 360;
    }

    public boolean isStop() {
        return isStop;
    }

    public void toggleStop() {
        this.isStop = !this.isStop;
    }

    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }
}
