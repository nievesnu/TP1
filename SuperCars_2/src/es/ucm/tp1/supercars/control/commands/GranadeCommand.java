package es.ucm.tp1.supercars.control.commands;

public class GranadeCommand {

}

/*
 *  crea un objeto Grenade en la posición (x, y),  tiene un coste de 3 coins y explota en 3 ciclos
 * 
 *  El comando tendrá que sobreescribir el método parse de Command para aceptar los
 *  parámetros de la posición
 *  
 *  La posición X es relativa a la posición del jugador, es decir, X = 5 significa que la
 *  granada se lanzará 5 posiciones por delante del jugador
 *  
 *  La posición de Y es absoluta respecto a la carretera, es decir, Y = 0 hace referencia
 *  al primer carril (en la perte superior) de la carretera.
 *  
 *  Sólo podemos añadir granadas en la parte visible de la carretera y la casilla tiene que estar vacía
 *  
 *  Al terminar la cuenta atrás explotará causando daño sólo a los obstáculos y muros
 *  (Obstacle, Wall, Pedestrian, Truck...), así que deberemos extender con un método
 *  receiveExplosion el interface Collider. El comportamiento es igual al de receiveShoot
 *  así que deberemos reutlizar el mismo método cuando sea posible.
 *  
 *  Después de añadir la granada se hace un update del game, actualizando los objetos de juego, el ciclo
 *  
 * */
 