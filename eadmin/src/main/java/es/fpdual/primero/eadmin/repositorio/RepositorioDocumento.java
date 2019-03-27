package es.fpdual.primero.eadmin.repositorio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	public Documento altaDocumento(Documento documento);
	public Documento modificarDocumento(Documento documento);
	public void eliminarDocumento(int codigoDocumento);
	public List<Documento> obtenerTodosDocumentos();
	public int getSiguienteId();
	
}
