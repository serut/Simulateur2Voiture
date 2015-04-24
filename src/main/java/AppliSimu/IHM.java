package AppliSimu;

import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import  javax.swing.*;

import javax.swing.JFrame;

import DomaineVoiture.Voiture;

public class IHM extends JFrame implements Observer{

	private IHMCircuit circuit;
	private IHMParametreVoiture maIHMParametreVoiture;

    @Override
    public void update(Observable arg0, Object arg1) {
        this.getCircuit().repaint();
    }

    public IHM(Voiture maVoiture, List<Route> routes) {
        super();
        maVoiture.addObserver(this);
        this.circuit = new IHMCircuit(maVoiture, routes);
        this.maIHMParametreVoiture = new IHMParametreVoiture(maVoiture);
        this.setTitle("Simulateur de Voiture");
        this.setSize(700, 500);

        //this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", this.maIHMParametreVoiture);
        this.getContentPane().add("Center", this.circuit);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public IHMCircuit getCircuit() {
        return this.circuit;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        this.circuit.repaint();
    }
}
