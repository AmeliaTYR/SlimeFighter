package main.java.swing;

public class ScenesController {

    GameLogic gameLogic;

    public ScenesController(GameLogic gameLogic){
        this.gameLogic = gameLogic;
    }


    public void changeToHomeScene(){
        gameLogic.scenesUi.panels[0].setVisible(true);
        gameLogic.scenesUi.panels[1].setVisible(false);
        gameLogic.scenesUi.panels[3].setVisible(false);

        // hide other panels

        // todo: switch music
    }

    public void changeToTownScene(){
        gameLogic.scenesUi.panels[0].setVisible(false);
        gameLogic.scenesUi.panels[1].setVisible(true);
        gameLogic.scenesUi.panels[3].setVisible(false);

        // hide other panels
        // add a from input for this fn then only hide the panel it came from

        // todo: switch music
    }

    public void changeToTravellingScene(){
        gameLogic.scenesUi.panels[0].setVisible(false);
        gameLogic.scenesUi.panels[1].setVisible(false);
        gameLogic.scenesUi.panels[3].setVisible(true);

        // hide other panels
        // add a from input for this fn then only hide the panel it came from

        // todo: switch music
    }





}
