package TowerDefenceGame;

import TD.model.MainScreen_Model;
import TD.view.MainScreen_View;
/**
 * This class is using singleton pattern to create manscreenview
 * @author peilin
 *
 */
public class TowerDefenceGame_singleton {
	private MainScreen_View mainscreenview;
	private MainScreen_Model mainscreenviewmodel;
	
	private static TowerDefenceGame_singleton singletonInstence = new TowerDefenceGame_singleton();
	/**
	 * This is a constructor of the class
	 */
	private TowerDefenceGame_singleton(){
		this.mainscreenview = new MainScreen_View();
		this.mainscreenviewmodel = new MainScreen_Model();
	}
	/**
	 * This method is get a instance of TowerDefenceGame_sigleton
	 * 
	 * @return	sigletonInstence
	 */
	public static TowerDefenceGame_singleton getInstance(){
		if(singletonInstence == null){
			return new TowerDefenceGame_singleton();
		}else{
			return singletonInstence;
		}
	}
	/**
	 * 
	 * @return mainscreenview
	 */
	public MainScreen_View getMainscreenview() {
		return mainscreenview;
	}
	/**
	 * 
	 * @return mainscreenviewmodel
	 */ 
	public MainScreen_Model getMainscreenviewmodel() {
		return mainscreenviewmodel;
	}
	
	
}
