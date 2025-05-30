import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


class MyGUI extends JFrame implements ActionListener {
    private JButton button;
    private JLabel label;
    private boolean isClicked = false; // Holder styr på knapp-tilstand

    public MyGUI() {
        // Sett tittel på vinduet
        setTitle("Mitt første GUI");

        // Lag knapp og etikett med styling
        button = new JButton("Trykk meg!");
        label = new JLabel("Hei, verden!");

        // Styling av label
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(new Color(25, 25, 112)); // Mørk blå tekst
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Styling av knapp
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180)); // Stålblå bakgrunn
        button.setForeground(Color.WHITE); // Hvit tekst
        button.setFocusPainted(false); // Fjern fokus-ramme
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // 3D-effekt
        button.setPreferredSize(new Dimension(150, 40));

        // Koble knapp til action
        button.addActionListener(this);

        // Sett bakgrunnsfarge på vinduet
        getContentPane().setBackground(new Color(240, 248, 255)); // Alice blue

        // Legg komponenter til vinduet med bedre layout
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        add(label);
        add(button);

        // Konfigurer vinduet
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Sentrer vinduet på skjermen
        setVisible(true);
    }

    // Hva skjer når du klikker på knappen
    @Override
    public void actionPerformed(ActionEvent e) {
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

    // main-metode
    public static void main(String[] args) {
        new MyGUI();
    }
}
