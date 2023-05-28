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
    public JComboBox<String> jenisKelaminDropdown;
    public JLabel provinsiLabel, kabKotLabel, kecamatanLabel, desaKelLabel, noUrutLabel, nikLabel, umurLabel, jenisKelaminLabel;
    public JTextField provinsiTextField, kabKotTextField, kecamatanTextField, desaKelTextField, noUrutTextField, nikTextField, umurTextField;


    public UI(AppManager appManager){
        this.appManager = appManager;
        createMainField();
        generateScreen();
        inputField1();
        inputField2();
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
        createBackgroundFull(1, "./background/bg.png");
    }

    public JLabel createLabel(int bgNum, int x, int y, int width, int height, String text, int size){
        JLabel newLabel = new JLabel(text);
        newLabel.setLayout(null);
        newLabel.setBounds(x, y, width, height);
        newLabel.setFont(new Font("Helvetica", Font.PLAIN, size));

        bgPanel[bgNum].add(newLabel);

        return newLabel;
    }

    public JTextField createTextField(int bgNum, int x, int y, int width, int height, int size, int column){
        JTextField newTextField = new JTextField(column);
        newTextField.setBounds(x, y, width, height);
        newTextField.setFont(new Font(newTextField.getFont().getName(),newTextField.getFont().getStyle(),size));

        bgPanel[bgNum].add(newTextField);

        return newTextField;
    }

    public JComboBox<String> createDropdown(int bgNum, int x, int y, int width, int height, int size, String[] isi){
        JComboBox<String> newDropdown = new JComboBox<String>(isi);
        newDropdown.setBounds(x, y, width, height);
        newDropdown.setFont(new Font(newDropdown.getFont().getName(),newDropdown.getFont().getStyle(),size));

        bgPanel[bgNum].add(newDropdown);

        return newDropdown;
    }

    public void button(int bgNum, int x, int y, int width, int height, String text, String command) {
        JButton btn = new JButton();

        btn.setBounds(x, y, width, height);
        btn.setText(text);
        btn.addActionListener(appManager.actionHandler);
        btn.setActionCommand(command);
        btn.setFont(new Font("Helvetica", Font.BOLD, 20));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.gray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(Color.black);
            }
        });

        bgPanel[bgNum].add(btn, 0);
    }

    public void inputField1(){
        provinsiTextField = createTextField(0, 600, 203, 500, 40, 40, 16);
        kabKotTextField = createTextField(0, 600, 303, 500, 40, 40, 16);
        kecamatanTextField = createTextField(0, 600, 403, 500, 40, 40, 16);
        desaKelTextField = createTextField(0, 600, 503, 500, 40, 40, 16);
        provinsiLabel = createLabel(0, 260, 203, 500, 40, "Provinsi               :", 40);
        kabKotLabel = createLabel(0, 260, 303, 500, 40, "Kabupaten/Kota  :", 40);
        provinsiLabel = createLabel(0, 260, 403, 500, 40, "Kecamatan          :", 40);
        kabKotLabel = createLabel(0, 260, 503, 500, 40, "Desa/Kelurahan  :", 40);
        button(0, 1100, 653, 200, 50, "Selanjutnya", null);

        bgPanel[0].add(bgLabel[0]);
    }   

    public void inputField2(){
        button(1, 1100, 653, 200, 50, "Selanjutnya", null);
        noUrutTextField = createTextField(1, 600, 203, 500, 40, 40, 16);
        nikTextField = createTextField(1, 600, 303, 500, 40, 40, 16);
        jenisKelaminDropdown = createDropdown(1, 600, 403, 500, 40, 40, new String[]{"Laki-laki", "Perempuan"});
        // TextField = createTextField(0, 600, 403, 500, 40, 40, 16);
        umurTextField = createTextField(1, 600, 503, 500, 40, 40, 16);
        noUrutLabel = createLabel(1, 260, 203, 500, 40, "No Urut:", 40);
        nikLabel = createLabel(1, 260, 303, 500, 40, "NIK:", 40);
        jenisKelaminLabel = createLabel(1, 260, 403, 500, 40, "Jenis Kelamin:", 40);
        umurLabel = createLabel(1, 260, 503, 500, 40, "Umur:", 40);


        bgPanel[1].add(bgLabel[1]);
    }   
    // public static void main(String[] args) {
        
    // }
}
