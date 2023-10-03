package br.com.cod3r.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class painelTabuleiro extends JPanel {

	public painelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registrarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
			if(e.isGanhou()) {
				JOptionPane.showMessageDialog(this, "Ganhou!");
			} else {
				JOptionPane.showMessageDialog(this, "Perdeu!");
			}
			tabuleiro.reiniciar();
			
		});
		});
	}
}
