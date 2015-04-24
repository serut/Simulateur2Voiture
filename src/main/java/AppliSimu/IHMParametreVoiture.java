package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class IHMParametreVoiture extends JPanel implements ActionListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
	private Voiture maVoiture;
    private JButton boutonDirectionGauche;
    private JButton boutonDirectionDroite;
    private JButton boutonToggleStop;

	
	public IHMParametreVoiture(Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonDirectionDroite = new JButton("Tourner à droite");
        boutonDirectionDroite.addActionListener(this);
        this.add(boutonDirectionDroite);

        boutonDirectionGauche = new JButton("Tourner à gauche");
        boutonDirectionGauche.addActionListener(this);
        this.add(boutonDirectionGauche);

        boutonToggleStop = new JButton("Stop");
        boutonToggleStop.addActionListener(this);
        this.add(boutonToggleStop);

		this.maVoiture = maVoiture;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
		else if (bouton == boutonInverserDirection)
			maVoiture.inverserDirection();
        else if (bouton == boutonDirectionGauche)
            maVoiture.directionGauche();
        else if (bouton == boutonDirectionDroite)
            maVoiture.directionDroite();
        else if (bouton == boutonToggleStop) {
            maVoiture.toggleStop();
            boutonToggleStop.setText(maVoiture.isStop()?"Démarrer":"Stop");
        }

	}
	

}
