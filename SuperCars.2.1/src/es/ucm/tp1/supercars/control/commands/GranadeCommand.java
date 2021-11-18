package es.ucm.tp1.supercars.control.commands;

public class GranadeCommand {

}

/*
 *  crea un objeto Grenade en la posici�n (x, y),  tiene un coste de 3 coins y explota en 3 ciclos
 * 
 *  El comando tendr� que sobreescribir el m�todo parse de Command para aceptar los
 *  par�metros de la posici�n
 *  
 *  La posici�n X es relativa a la posici�n del jugador, es decir, X = 5 significa que la
 *  granada se lanzar� 5 posiciones por delante del jugador
 *  
 *  La posici�n de Y es absoluta respecto a la carretera, es decir, Y = 0 hace referencia
 *  al primer carril (en la perte superior) de la carretera.
 *  
 *  S�lo podemos a�adir granadas en la parte visible de la carretera y la casilla tiene que estar vac�a
 *  
 *  Al terminar la cuenta atr�s explotar� causando da�o s�lo a los obst�culos y muros
 *  (Obstacle, Wall, Pedestrian, Truck...), as� que deberemos extender con un m�todo
 *  receiveExplosion el interface Collider. El comportamiento es igual al de receiveShoot
 *  as� que deberemos reutlizar el mismo m�todo cuando sea posible.
 *  
 *  Despu�s de a�adir la granada se hace un update del game, actualizando los objetos de juego, el ciclo
 *  
 * */
 