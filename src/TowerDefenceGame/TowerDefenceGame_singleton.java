package TowerDefenceGame;

import TD.model.MainScreen_Model;
import TD.view.MainScreen_View;

public class TowerDefenceGame_singleton {
	private MainScreen_View mainscreenview;
	private MainScreen_Model mainscreenviewmodel;
	
	private static TowerDefenceGame_singleton singletonInstence = new TowerDefenceGame_singleton();
	
	private TowerDefenceGame_singleton(){
		this.mainscreenview = new MainScreen_View();
		this.mainscreenviewmodel = new MainScreen_Model();
	}
	
	public static TowerDefenceGame_singleton getInstance(){
		if(singletonInstence == null){
			return new TowerDefenceGame_singleton();
		}else{
			return singletonInstence;
		}
	}

	public MainScreen_View getMainscreenview() {
		return mainscreenview;
	}

	public MainScreen_Model getMainscreenviewmodel() {
		return mainscreenviewmodel;
	}
	
	
}
