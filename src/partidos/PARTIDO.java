/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partidos;
import beans.partidos;
import logic.logicaAplicacion;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class PARTIDO {

	public static void main(String[] args) {
		
	int opc;
	boolean salir=false;
	Scanner s=new Scanner(System.in);	
	String equipLocal, equipVisistantes, Resultado;
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
	int division;
	partidos.Divisiones d=null;
	Date fecha= null;
	logicaAplicacion l= new logicaAplicacion();
	
		do {
			menu();
			opc=Integer.parseInt(s.nextLine());
			
			switch(opc) {
				case 1:
					System.out.println("INTRODUCE EL NOMBRE DEL EQUIPO LOCAL");
					equipLocal=s.nextLine();
					
					System.out.println("INTRODUCE EL NOMBRE DEL EQUIPO VISITANTE");
					equipVisistantes=s.nextLine();
					
					System.out.println("INTRODUCE EL NOMBRE DEL EQUIPO RESULTADO");
					Resultado=s.nextLine();
					
					System.out.println("ElIGUE LA DIVISIÃ“N:\n1- PRIMERA \n2- SEGUNDA \n3- TERCERA");
					System.out.println("INTRODUCE LA DIVISIÃ“N");
					division=Integer.parseInt(s.nextLine());
					
						switch(division) {
						case 1:
							d=partidos.Divisiones.PRIMERA;
							break;
						case 2:
							d=partidos.Divisiones.SEGUNDA;
							break;
						case 3:
							d=partidos.Divisiones.TERCERA;
							break;
						}
					System.out.println("INTRODUCE LA FECHA CON FROMATO dd/mm/yy");
					String f =s.nextLine();
				
						try {
							fecha=sdf.parse(f);
						}	
						catch(ParseException ex) {
						ex.printStackTrace();
						}
					partidos p=new partidos(equipLocal, equipVisistantes, Resultado,d,fecha);
					if(l.altaNuevoPartido(p));
					
					System.out.println("OPERACION CORRECTA");	
				break;
				
				case 2:
					mostrarListadoPartidos(l.getPartidos());
					break;
					
				case 3:
					System.out.println("INTRODUCE EL NUMERO DE PARTIDO");
					int num=Integer.parseInt(s.nextLine());
					l.borradoPartido(num);
					break;
				case 4:
					System.out.println("inserte el modo:\n - ascendete\n - descendente");
					String metodo = s.nextLine();
					mostrarListadoPartidos(l.listaPartidosOrdenados(metodo));
					break;
					
				case 5:
					System.out.println("INTRODUCE LA DIVISION A MOSTRAR\r1\r2\r3");
					int div=Integer.parseInt(s.next());
					
					switch(div) {
					
						case 1:
							d=partidos.Divisiones.PRIMERA;
						break;
					
						case 2:
							d=partidos.Divisiones.SEGUNDA;
						break;
					
						case 3:
							d=partidos.Divisiones.TERCERA;
						break;
					
					}
					mostrarListadoPartidos(l.listaPartidosDivision(d));
					break;
				
				case 6:
					
					salir=true;
					l.guardarEnFichero();
					System.out.println("YA HAS SALIDO Y LO HAS GUARDADO EN EL FICHERO");			
				break;
			
			}
		}
		while(!salir);
					
	}
		
	
	
	
	
	private static void menu() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("-----------------------........................-----------------------------");
		System.out.println("-----------------------.         MENU         .-----------------------------");
		System.out.println("-----------------------........................-----------------------------");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1 .DAR DE ALTA A UN NUEVO PARTIDO");					
		System.out.println("2. MOSTRAR LISTADO.");				
		System.out.println("3. BORRADO DE UN PARTIDO");						
		System.out.println("4. MOSTRAR LOS PARTIDOS ORDENADOS");									 
		System.out.println("5. MOSTRAR PARTIDOS DE UNA DIVISIÃ“N");
		System.out.println("6. SALIR Y GUARDAR");
	}
	
	public static void mostrarListadoPartidos(List<PARTIDO>lista) {
		if(!lista.isEmpty()) {
			for(int i=0; i<lista.size(); i++) {
				System.out.println(i+"\t");
				System.out.println(lista.get(i));
			}
		}
		else {
			System.out.println("LISTA VACIA");
		}
	}

   

	
	
	
}
