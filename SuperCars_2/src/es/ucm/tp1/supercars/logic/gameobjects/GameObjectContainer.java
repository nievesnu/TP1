package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.Collider;


public class GameObjectContainer {
	private List<GameObject> gameobjects;
	
	public GameObjectContainer() {
		gameobjects = new ArrayList <GameObject>(); 
	}
	
	public void addObject(GameObject gameO) {
		gameobjects.add(gameO);
	}
	
	public void removeDead(){
		ArrayList <GameObject> list = new ArrayList <GameObject>();
		
		for(int i = 0; i < gameobjects.size(); i++) {
			if(gameobjects.get(i).isAlive()) {
				list.add(gameobjects.get(i));
			}else {
				gameobjects.get(i).onDelete();
			}
		}
		this.gameobjects = list;
	}
	
	public void updateObjects() {
		for(int i = 0; i < gameobjects.size(); i++) {		
			gameobjects.get(i).update(); 
		}
		removeDead();
	}
	
	public String getSymbol() {
		return gameobjects.get(0).toString();
	}

	public Collider getObjectContainer(int x, int y) {
		boolean fin = false;
		int i = 0;
		Collider col = null;
		while(i<gameobjects.size() && !fin) {
			if(gameobjects.get(i).getX() == x && gameobjects.get(i).getY() == y) {
				col = gameobjects.get(i); 
				fin = true;
			} i++;
		}
		return col;
	}
}
