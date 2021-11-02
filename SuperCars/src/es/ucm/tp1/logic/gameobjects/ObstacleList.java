package es.ucm.tp1.logic.gameobjects;

public class ObstacleList {
	
	private Obstacle[] obsList;
	private int numElem;
	private int tam;
	
	public ObstacleList(int tam) {
		this.tam = tam;
		obsList =  new Obstacle[tam];
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
	
	public void removeDead(){
		Obstacle[] list2 = new Obstacle[tam];
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
	
	public void CollideInPos(int x, int y){ //pasar  + adelante a bool
		for(int i = 0; i < numElem; i++) {
			if(obsList[i].isInPosition(x, y)) {
				obsList[i].receiveCollision() ;
				this.numElem--;
			}
		}
	}
	
	public int getNume() {
		return numElem;
	}
	
	public String getSymbol() {
		return obsList[0].toString();
	}
}