package q5_PauloFilho;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdivinharNumeroGUI {
    private static int NUMERO_ALEATORIO = new Random().nextInt(20) + 1;
    private static final int NUMERO_DE_TENTATIVAS = 5;
    private static int tentativasRestantes = NUMERO_DE_TENTATIVAS;

    private JFrame frame;
    private JButton[] botoes;
    private JTextField tentativaTextField;

    public AdivinharNumeroGUI() {
        frame = new JFrame("Adivinhe o Número");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 4));

        botoes = new JButton[20];
        for (int i = 0; i < 20; i++) {
            botoes[i] = new JButton(Integer.toString(i + 1));
            botoes[i].addActionListener(new BotaoListener());
            frame.add(botoes[i]);
        }

        tentativaTextField = new JTextField("Tentativas Restantes: " + tentativasRestantes);
        tentativaTextField.setEditable(false);
        frame.add(tentativaTextField);

        frame.pack();
        frame.setVisible(true);
    }

    private class BotaoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (tentativasRestantes > 0) {
                JButton botaoClicado = (JButton) e.getSource();
                int numeroEscolhidoPeloUsuario = Integer.parseInt(botaoClicado.getText());

                if (numeroEscolhidoPeloUsuario == NUMERO_ALEATORIO) {
                    JOptionPane.showMessageDialog(frame, "Você acertou! O número era " + NUMERO_ALEATORIO);
                    reiniciarJogo();
                } else {
                    tentativasRestantes--;
                    tentativaTextField.setText("Tentativas Restantes: " + tentativasRestantes);
                    if (tentativasRestantes == 0) {
                        JOptionPane.showMessageDialog(frame, "Suas tentativas acabaram. O número era " + NUMERO_ALEATORIO);
                        reiniciarJogo();
                    }
                }
            }
        }
    }

    private void reiniciarJogo() {
        NUMERO_ALEATORIO = new Random().nextInt(20) + 1;
        tentativasRestantes = NUMERO_DE_TENTATIVAS;
        tentativaTextField.setText("Tentativas Restantes: " + tentativasRestantes);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdivinharNumeroGUI());
    }
}
