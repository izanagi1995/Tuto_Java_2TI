package info.izanagi1995.tuto2ti.exam2016threads;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class JFrameServeur extends JFrame implements ActionListener {

  private JPanel contentPane;
  private ServerSocket serveur;
  private Socket client;
  private JButton jButton;
  private JLabel jLabel;


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
  	JFrameServeur jfs = new JFrameServeur();
  	jfs.setVisible(true);
  }

  /**
   * Create the frame.
   */
  public JFrameServeur() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
    jButton = new JButton("Démarrer le serveur");
    jButton.addActionListener(this);
    contentPane.add(jButton);
  }
	
 public void actionPerformed(ActionEvent e) {
    try {
      
      serveur = new ServerSocket(0);// permet d'ouvrir sur le premier port TCP disponible
      jButton.setVisible(false);
      jLabel = new JLabel("Le serveur écoute sur le port " + serveur.getLocalPort());
						
      this.getContentPane().add(jLabel);
			
      new Thread(new Runnable(){

  		@Override
  		public void run() {
  			try {
  				//L'appel a accept est bloquant, il bloque la GUI, on doit donc le mettre dans
  				//un thread pour l'exécuter en parallèle.
  				client = serveur.accept();
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			
  		}
      	  
    });
			
    } catch (IOException ex) {
      ex.printStackTrace();
    }	
  }

}
