package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineVoiture.Voiture;

public class IHM extends JFrame implements Observer{

	private final double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private IHMParametreVoiture maIHMParametreVoiture;

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    public IHM(Voiture maVoiture) {
        super();
        this.maVoiture = maVoiture;
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
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}
	
}
