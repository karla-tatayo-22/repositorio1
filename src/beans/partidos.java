/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.Serializable;
import java.util.Date;


 /*
 * @author DAM
 */
public class partidos implements Serializable, Comparable<partidos>{
public enum Divisiones {PRIMERA,SEGUNDA,TERCERA}
private Divisiones division;
private String eqLocal,eqVisitante, resultado;
private Date fecha;
	
public partidos(String eqLocal, String eqVisitante, String resultado, Divisiones division, Date fecha){
	super();
	this.eqLocal = eqLocal;
	this.eqVisitante = eqVisitante;
	this.resultado = resultado;
	this.division = division;
	this.fecha = fecha;
	}
	
public Divisiones getDivision() {
		return division;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		partidos other = (partidos) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	public void setDivision(Divisiones division) {
		this.division = division;
	}

	public String getEqLocal() {
		return eqLocal;
	}

	public void setEqLocal(String eqLocal) {
		this.eqLocal = eqLocal;
	}

	public String getEqVisitante() {
		return eqVisitante;
	}

	public void setEqVisitante(String eqVisitante) {
		this.eqVisitante = eqVisitante;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
        public Date getFecha() {
            return fecha;   
        }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
        @Override
            public int compareTo(partidos o) {
                        return this.fecha.compareTo(o.fecha);
            }
	@Override
	public String toString() {
		return "partido [eqLocal=" + eqLocal + ", eqVisitante=" + eqVisitante + ", resultado=" + resultado + ", division="
				+ division + ", fecha=" + fecha + utils.UTILS.sdf.format(getFecha())+"]";
	}
	
}


	


