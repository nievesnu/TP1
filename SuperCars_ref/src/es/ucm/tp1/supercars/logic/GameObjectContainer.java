package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;


public class GameObjectContainer {
	private List<GameObject> gameobjects;
	
	public GameObjectContainer() {
		gameobjects = new ArrayList <GameObject>(); 
	}
	
	public void addObject(GameObject gameO) {
		gameO.onEnter(); 
		gameobjects.add(gameO);
	}
	
	private void removeDead(){ //es un metodo privado porque siempre que se hace el update se eliminar los muertos
		
		for(int i = 0; i < gameobjects.size(); i++) {
			if(!gameobjects.get(i).isAlive()) {
				gameobjects.get(i).onDelete();
				gameobjects.remove(gameobjects.get(i));
			}
		}
	}
	
	public void updateObjects() { 
		for(int i = 0; i < gameobjects.size(); i++) {		
			gameobjects.get(i).update(); 
		}
		removeDead();
	}
	
	//encuentra el objeto 
	public GameObject getObjectContainer(int x, int y) {
		boolean fin = false;
		int i = 0;
		GameObject col = null;
		while(i<gameobjects.size() && !fin) {
			if(gameobjects.get(i).isInPosition(x, y)) {
				col = gameobjects.get(i); 
				fin = true;
			} i++;
		}
		return col;
	}
}
