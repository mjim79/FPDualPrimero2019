package es.fpdual.primero.eadmin.servicio;

import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;

public interface ServicioDocumento {
	

	/**
	 * Servicio para almacenar documentos.
	 * @param documento documento completo a falta de 
	 * id y fechas que serán calculadas automáticamente
	 * @return documento resultado con el id y las fechas
	 * completas
	 */
	public Documento altaDocumento(Documento documento);
	public void modificarDocumento(Documento documento);
	public void eliminarDocumento(int codigoDocumento);
	public List<Documento> obtenerTodosDocumentos();
	public Documento obtenerDocumentoPorId(int codigoDocumento);
	

}
