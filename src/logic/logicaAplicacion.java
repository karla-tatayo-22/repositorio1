/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import beans.partidos;

import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class logicaAplicacion {

	public logicaAplicacion(){
		cargarFichero();
	}
	
	
	private final String NOMBRE_FICHERO="partidos.dat";
	private List <partidos> partidos=new LinkedList<>();/*CREAMOS UN LINKEDLIST PARA GUARDAR LOS DATOS */

	
	public List<partidos> getPartidos() {
		return partidos;
	}
	
	public void guardarEnFichero() {
		ObjectOutputStream oos=null;
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO,false));
			oos.writeObject(partidos);
			
			oos.close();
			
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public boolean altaNuevoPartido(partidos p) {
		return partidos.add(p);
	}
	
	public void setPartidos(List<partidos> partidos) {
		this.partidos = partidos;
	}

	public partidos borradoPartido(int index) {/*index es para cuando hablamos de una variable de tipo entero */
		partidos partborrado=null;
		
		if(index<partidos.size()&&index>=0)
			partborrado=partidos.remove(index);
		else
			System.out.println("POSICIÃ“N NO ENCONTRADA");
		return partborrado;		
	}
	
	public List <partidos> listaPartidosOrdenados(String metodo){
		LinkedList<partidos>copia=new LinkedList<> (partidos);
		
		if(metodo.equalsIgnoreCase("ASCENDENTE")) {
			Collections.sort(copia);
		}
		else {
			Collections.sort(copia, new Comparator<partidos>(){
				
			@Override
			public int compare(partidos o1, partidos o2) {
				return o2.getFecha().compareTo(o1.getFecha());
				}
				
			});
		}

		return copia;
		
	}
	
	
	public List <partidos> listaPartidosDivision (partidos.Divisiones d){
		List <partidos>copia2= new ArrayList<>();
		
		for (partidos o:partidos) {//TIPOS DE OBJETO QUE VAMOS A RECORRER, OBJETO, Y VARIABLE_OBJETO
			
			if(o.getDivision().equals(d)) {
				copia2.add(o);
				
			}
		}	
		
		return copia2;

	}
	
	private void cargarFichero() {
		File f=new File(NOMBRE_FICHERO);
		if(f.exists()) {
			FileInputStream fis=null;
			ObjectInputStream oos=null;
			LinkedList<partidos> ps=null;
			
			try {	
				fis=new FileInputStream(NOMBRE_FICHERO);
				oos=new ObjectInputStream(fis);
				//ps=(LinkedList<PARTIDO>)oos.				
				partidos=ps;
			}
			
			
			catch(FileNotFoundException e) {
			}
			catch(IOException e) {
					e.printStackTrace();
			}
			
			
			finally {
				try {
					oos.close();
					fis.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			}
	}
}
