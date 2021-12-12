package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

public class Record {
	private static long maxValor = Long.MAX_VALUE;
	private static StringBuilder buffer;
	
	public static long loadRecord(Game g) throws InputOutputRecordException{ //llamar a esto en init
		long r = maxValor;
		buffer = new StringBuilder();
		String[] separador;
		try {
			String cadena;
			FileReader f = new FileReader("./record.txt"); //el ./ lo mete en el directorio principal 
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				//System.out.println(cadena);
				separador = cadena.split(":");
				if (g.getLevel().name().equals(separador[0])) {
					if (separador.length == 2) {
						r = Long.parseLong(separador[1]);
					}										
				}else{
					buffer.append(cadena + "\n");
				}
			}
			b.close();
		}catch(IOException e) { //engloba las de in/out y filenotfound esta dentro
			throw new InputOutputRecordException("[ERROR]: the file you are looking for could not be found or is corrupted", null);
		}
		return r;
	}
	
	public static void saveRecord(Game g) throws InputOutputRecordException {
		
		try {	
		File myFoo = new File("./record.txt");
		FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
		                                                     // false to overwrite.
		fooWriter.write(buffer.toString() + "\n");
		fooWriter.write(g.getLevel().name() +":" + g.getRecord());
		fooWriter.close();
		
		} catch(IOException e) { //engloba las de in/out y filenotfound esta dentro
			throw new InputOutputRecordException("[ERROR]: the file you are looking for could not be found or is corrupted", null);
		}
	}
}