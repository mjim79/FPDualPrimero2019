package es.fpdual.primero.eadmin.servicio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface ServicioDocumento {
	
	public Documento altaDocumento(Documento documento);
	public void modificarDocumento(Documento documento);
	public void eliminarDocumento(int codigoDocumento);
	public List<Documento> obtenerTodosDocumentos();
	

}
