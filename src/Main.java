import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


class MyGUI extends JFrame implements ActionListener {
    private JButton button;
    private JButton resetButton;
    private JLabel label;
    private boolean isClicked = false; // Holder styr på knapp-tilstand

    public MyGUI() {
        // Sett tittel på vinduet
        setTitle("Mitt første GUI");

        // Lag knapp og etikett med styling
        button = new JButton("Trykk meg!");
        resetButton = new JButton("Resett");
        label = new JLabel("Hei, verden!");

        // Styling av label
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(new Color(25, 25, 112)); // Mørk blå tekst
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Styling av hovedknapp
        button.setFont(new Font("Verdana", Font.ITALIC, 18));
        button.setBackground(new Color(70, 130, 180)); // Stålblå bakgrunn
        button.setForeground(Color.WHITE); // Hvit tekst
        button.setFocusPainted(false); // Fjern fokus-ramme
        button.setBorder(new javax.swing.border.LineBorder(new Color(70, 130, 180), 2, true)); // true gir runde hjørner
        button.setPreferredSize(new Dimension(150, 40));
        button.setIcon(new ImageIcon("src/path/til/ikon.png"));

        // Styling av resett-knapp
        resetButton.setFont(new Font("Arial", Font.BOLD, 12));
        resetButton.setBackground(new Color(220, 20, 60)); // Rød bakgrunn
        resetButton.setForeground(Color.WHITE); // Hvit tekst
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
        resetButton.setPreferredSize(new Dimension(100, 35));

        // Koble knapper til action
        button.addActionListener(this);
        resetButton.addActionListener(this);

        // Sett bakgrunnsfarge på vinduet
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice blue

        // Legg komponenter til vinduet med bedre layout
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(label);
        add(button);
        add(resetButton);

        // Konfigurer vinduet
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Sentrer vinduet på skjermen
        setVisible(true);

        // Add mouse listener for hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237)); // Lysere blå
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180)); // Original farge
            }
        });
    }

    // Hva skjer når du klikker på knappen
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            // Resett alt tilbake til original tilstand
            resetToOriginal();
        } else if (e.getSource() == button) {
            if (!isClicked) {
                // Gå til "trykket" tilstand
                label.setText("Du trykket på knappen!");
                button.setText("Trykket!");
                button.setBackground(new Color(60, 179, 113)); // Grønn farge
                isClicked = true;
            } else {
                // Gå tilbake til original tilstand
                label.setText("Hei, verden!");
                button.setText("Trykk meg!");
                button.setBackground(new Color(70, 130, 180)); // Stålblå bakgrunn
                isClicked = false;
            }
        }
    }

    // Metode for å resette til original tilstand
    private void resetToOriginal() {
        label.setText("Hei, verden!");
        button.setText("Trykk meg!");
        button.setBackground(new Color(70, 130, 180)); // Stålblå bakgrunn
        isClicked = false;
    }

    // main-metode
    public static void main(String[] args) {
        new MyGUI();
    }
}
