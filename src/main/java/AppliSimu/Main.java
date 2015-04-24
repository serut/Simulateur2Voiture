package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import DomaineVoiture.Voiture;

public class Main {

	public static final int dureeUneSecondeEnMilliSecondes = 33;

	public static void main(String[] args) {

		final Voiture maVoiture = new Voiture (100, 300, 1);
        List<Route> liste = new ArrayList<Route>();
        liste.add(new Route(0, maVoiture.getY()-10, 100, 2000));
        liste.add(new Route(500, 0, 2000, 100));
		final IHM ihm = new IHM(maVoiture, liste);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}

	}

}
