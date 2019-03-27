package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoContable extends Documento {

	private final String numeroOperacionContable;
	
	public DocumentoContable (int id, String nombre, Usuario usuario, 
			Date fechaCreacion, String numeroOperacionContable) {
		super(id,nombre, usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		
	}
	
	public String getNumeroOperacionContable() {
		return numeroOperacionContable;
	}
	

}
