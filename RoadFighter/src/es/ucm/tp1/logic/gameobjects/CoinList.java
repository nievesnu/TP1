package es.ucm.tp1.logic.gameobjects;

public class CoinList {
	
	private int tam;
	private Coin[] listCoins; 
	private int numElements = 0;
	
	public CoinList (int tama) {
		this.tam = tama;
		listCoins = new Coin[tam];
	}
	
	public void add(Coin coin) {
		this.listCoins[numElements] = coin;
		this.numElements++;
	
	}
	
	public boolean isInPos(int x, int y) {
		boolean is = false;
		for(int i =0; i<numElements; i++) {
			if(listCoins[i].isInPosition(x, y)) {
				is = true;
			}
		}
		return is;
	}
	
	public Coin getObjectInPos(int x, int y) {
		Coin moneda = null;
		for(int i = 0; i < numElements; i++) {
			if(listCoins[i].isInPosition(x, y)) {
				moneda = listCoins[i];
			}
		}
		return moneda;
	}

	
	public boolean  isPosEmpty(int x, int y){
		boolean s = true;
		for(int i = 0; i < numElements; i++) {
			if(listCoins[i].isInPosition(x, y)) {
				s = false;
			}
		}
		return s;
	}
	
	
	//update()
	public void removeDead(){
		Coin[] listCoins2 = new Coin[tam];
		int counter = 0;
		
		for(int i = 0; i < numElements; i++) {
			if(listCoins[i].getCoinVida() == 1) {
				 listCoins2[counter] = listCoins[i];
				 counter++;
			}
		}
		
		this.listCoins = listCoins2;
		this.numElements = counter;
	}
	
	
	public void CollideInPos(int x, int y) {
		for(int i = 0; i < numElements; i++) {
			if(listCoins[i].isInPosition(x, y)) {
				listCoins[i].receiveCollision();
				this.numElements--;
			}
		}
	}
	
	public int getNume() {
		return numElements;
	}
	public String getSymbol() {
		return listCoins[0].toString();
	}
	
	/*
	 * �?� update() de la clase CoinList
�?� Recorrer el array coins y hacer update() de cada coin. El
update() de la clase Coin no hace nada porque los coins no
se mueven
�?� Eliminar los coins muertos
�?� Crear un nuevo array de coins
�?� Recorrer el viejo array de coins y por cada coin
�?� si está muerto, disminuir 1 el estático del número de
coins
�?� si no está muerto, llevar el coin al nuevo array de coins
�?� guardar el nuevo array de coins como nuevo coins
	 */
	

}
