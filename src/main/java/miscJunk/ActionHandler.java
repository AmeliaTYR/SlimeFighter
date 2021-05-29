package main.java.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

    GameLogic gameLogic;

    public ActionHandler(GameLogic gameLogic) {

        this.gameLogic = gameLogic;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String yourChoice = e.getActionCommand();

        switch(yourChoice) {
        // SCENE 1
        case "test": break;
        }
    }

}