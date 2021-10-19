package es.ucm.tp1.logic.gameobjects;

public class ObstacleList {
	
	private Obstacle[] obsList;
	private int numElem;
	private int tamaño;
	
	public ObstacleList(int tamaño) {
		this.tamaño = tamaño;
		obsList =  new Obstacle[tamaño];
		this.numElem=0;
	}
	
	public void add(Obstacle o) {
		this.obsList[numElem] = o;
		this.numElem++;
	}
	
	public boolean isInPos(int x, int y) {
		boolean is = false;
		for(int i =0; i<numElem; i++) {
			if(obsList[i].isInPosition(x, y)) {
				is = true;
			}
		}
		return is;
	}
	
	public Obstacle getObjectInPos(int x, int y){
		Obstacle obsta = null;
		for(int i = 0; i < numElem; i++) {

			if(obsList[i].isInPosition(x, y)) {
				obsta = obsList[i];
			}
		}
		return obsta;
	}
	
	public boolean isPosEmpty(int x,int y){
		boolean s = true;
		for(int i = 0; i < numElem; i++) {
			if(obsList[i].isInPosition(x, y)) {
				s = false;
			}
		}
		return s;	
	}
	
	//update de ayuda para los que van retrasados
	public void removeDead(){
		Obstacle[] list2 = new Obstacle[tamaño];
		int counter = 0;
		
		for(int i = 0; i < numElem; i++) {
			if(obsList[i].getObstacleVida() == 1) {
				 list2[counter] = obsList[i]; 
				 counter++;
			}
		}
		
		this.obsList = list2;
		this.numElem = counter;
	}
	
	public boolean CollideInPos(int x, int y){
		boolean a = false;
		for(int i = 0; i < numElem; i++) {
			if(obsList[i].isInPosition(x, y)) {
				obsList[i].receiveCollision() ;
				this.numElem--;
				a = true;
			}
		}
		return a;
	}
}
