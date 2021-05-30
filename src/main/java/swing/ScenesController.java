package main.java.swing;

public class ScenesController {

    GameLogic gameLogic;

    public ScenesController(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }


    public void changeToHomeScene(){
        gameLogic.ui.panels[0].setVisible(true);
        gameLogic.ui.panels[1].setVisible(false);
        // hide other panels

        // todo: switch mushc
    }

    public void changeToTownScene(){
        gameLogic.ui.panels[0].setVisible(false);
        gameLogic.ui.panels[1].setVisible(true);
        // hide other panels
        // add a from input for this fn then only hide the panel it came from

        // todo: switch mushc
    }





}
