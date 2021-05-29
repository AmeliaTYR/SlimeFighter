package main.java.swing;

public class ScenesController {

    GameLogic gameLogic;

    public ScenesController(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }


    public void changeToHomeScene(){
        gameLogic.ui.panels[0].setVisible(true);
        gameLogic.ui.panels[1].setVisible(false);

        // todo: switch mushc
    }

    public void changeToTownScene(){
        gameLogic.ui.panels[0].setVisible(false);
        gameLogic.ui.panels[1].setVisible(true);

        // todo: switch mushc
    }





}
