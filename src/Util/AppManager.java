package Util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AppManager {
    Routing routing = new Routing(this);
    UI ui = new UI(this);
    ActionHandler actionHandler = new ActionHandler(this);

    public AppManager(){
        routing.showScreen(0);
    }
}
