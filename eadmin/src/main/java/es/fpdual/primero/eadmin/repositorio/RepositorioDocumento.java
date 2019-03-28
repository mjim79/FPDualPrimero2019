package es.fpdual.primero.eadmin.repositorio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	public void altaDocumento(Documento documento);
	public void modificarDocumento(Documento documento);
	public void eliminarDocumento(int codigoDocumento);
	public List<Documento> obtenerTodosDocumentos();
	public int getSiguienteId();
	
}
