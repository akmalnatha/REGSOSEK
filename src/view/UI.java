package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

public class UI {
    public JTextField provinsiTextField;
    public JTextField kabKotTextField;
    public JTextField kecamatanTextField;
    public JTextField desaKelTextField;
    public JFrame window;
    

    public void createMainField() {
        window = new JFrame();
        window.setSize(1000, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
    }

    public void createBackgroundFull(int bgNum, String bgPath) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1000, 800);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1000, 800);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(bgPath)).getImage()
                .getScaledInstance(1000, 800, Image.SCALE_SMOOTH));
        bgLabel[bgNum].setIcon(bgIcon);
        bgPanel[bgNum].add(bgLabel[bgNum]);
        bgPanel[bgNum].setVisible(false);
    }

    public static void main(String[] args) {
        
    }
}
