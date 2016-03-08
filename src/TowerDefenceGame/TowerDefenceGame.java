package TowerDefenceGame;

import TD.controller.MainScreen_Controller;

public class TowerDefenceGame {

	public static void main(String[] args) {
		TowerDefenceGame_singleton singletonTD = TowerDefenceGame_singleton.getInstance();
		MainScreen_Controller MainController = new MainScreen_Controller(singletonTD.getMainscreenview(), singletonTD.getMainscreenviewmodel());
		singletonTD.getMainscreenview().setVisible(true);
	}

}
