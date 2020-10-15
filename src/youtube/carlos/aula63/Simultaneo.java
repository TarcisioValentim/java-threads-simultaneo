package youtube.carlos.aula63;

import java.awt.BorderLayout;
import java.awt.Font;

//import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Simultaneo extends JFrame {

	JLabel tempo = new JLabel("0");
	JLabel idade = new JLabel();
	int segundos = 0;

	public Simultaneo() {
		// TODO Auto-generated constructor stub
		editarLayout();
		new contarTempo().start();
		mostrarMensagem();

	}

	public void editarLayout() {
		Font fonte = new Font("Arial", Font.BOLD, 50);
		Font fonte2 = new Font("Arial", Font.BOLD, 30);

		add(BorderLayout.NORTH, tempo);
		add(BorderLayout.CENTER, idade);

		tempo.setHorizontalAlignment(SwingConstants.CENTER);
		idade.setHorizontalAlignment(SwingConstants.CENTER);
		tempo.setFont(fonte);
		idade.setFont(fonte2);

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	

	public void mostrarMensagem() {
		int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Em que ano voce nasceu?"));
		int anoAtual = Integer.parseInt(JOptionPane.showInputDialog("Em que ano estamos?"));
		int resultado = anoAtual - anoNasc;
		idade.setText("Sua idade é: " + resultado);

		JOptionPane.showMessageDialog(null, "Voce gastou " + segundos + " segundos para responder!");
	}

	public static void main(String[] args) {
		new Simultaneo();
	}

	public class contarTempo extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				segundos++;
				tempo.setText(segundos + "");
			}
		}
	}
}
