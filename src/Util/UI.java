package Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private AppManager appManager;
    public JFrame window;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];
    public JLabel provinsiLabel;
    public JLabel kotaLabel;
    public JLabel kecamatanLabel;
    public JLabel desaLabel;
    public JTextField provinsiTextField;
    public JTextField kabKotTextField;
    public JTextField kecamatanTextField;
    public JTextField desaKelTextField;


    public UI(AppManager appManager){
        this.appManager = appManager;
        createMainField();
        generateScreen();
        inputField1();
        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920*3/4, 1080*3/4);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(null);
        window.setLayout(null);
        window.setResizable(false);
    }

    public void createBackgroundFull(int bgNum, String bgPath) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1920*3/4, 1080*3/4);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(bgPath)).getImage()
                .getScaledInstance(1920*3/4, 1080*3/4, Image.SCALE_SMOOTH));
        bgLabel[bgNum].setIcon(bgIcon);
        // bgPanel[bgNum].add(bgLabel[bgNum], -1);
    }

    public void generateScreen() {
        // Start
        createBackgroundFull(0, "./background/bg.png");
    }

    public void inputField1(){
        provinsiLabel = new JLabel("Provinsi               :");
        provinsiLabel.setLayout(null);
        provinsiLabel.setBounds(360, 203, 500, 100);
        provinsiLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));

        kotaLabel = new JLabel("Kabupaten/Kota  :");
        kotaLabel.setLayout(null);
        kotaLabel.setBounds(360, 303, 500, 100);
        kotaLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));

        kecamatanLabel = new JLabel("Kecamatan          :");
        kecamatanLabel.setLayout(null);
        kecamatanLabel.setBounds(360, 403, 500, 100);
        kecamatanLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));

        desaLabel = new JLabel("Desa/Kelurahan  :");
        desaLabel.setLayout(null);
        desaLabel.setBounds(360, 503, 500, 100);
        desaLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));


        bgPanel[0].add(provinsiLabel);
        bgPanel[0].add(kotaLabel);
        bgPanel[0].add(kecamatanLabel);
        bgPanel[0].add(desaLabel);
        bgPanel[0].add(bgLabel[0]);
    }   

    // public static void main(String[] args) {
        
    // }
}
