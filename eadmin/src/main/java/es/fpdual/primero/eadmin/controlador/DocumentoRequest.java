package es.fpdual.primero.eadmin.controlador;

import java.util.Date;

import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class DocumentoRequest {
	
	private final int id;
	private final String nombre;
	private final String usuario;
	private final Date fechaCreacion;
	private final String tipoDocumento;
	
	
	public DocumentoRequest(int id, String nombre, String usuario, Date fechaCreacion, String tipoDocumento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}



	public String getUsuario() {
		return usuario;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}


}
