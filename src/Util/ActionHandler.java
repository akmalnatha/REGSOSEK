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
            
        }
    }
    
}
