package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
    AppManager appManager;

    public ActionHandler(AppManager appManager){
        this.appManager = appManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand();

        switch (command){
            case "page-1":
                appManager.routing.showScreen(0);
            case "page-2":
                appManager.routing.showScreen(1);
                // appManager.ui.bgPanel[0].setVisible(false);
            case "page-3":
                appManager.routing.showScreen(2);
            case "page-4":
                appManager.routing.showScreen(3);
            case "page-5":
                appManager.routing.showScreen(4);
            case "page-6":
                appManager.routing.showScreen(5);
        }
    }
    
}
