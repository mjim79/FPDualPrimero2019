package es.fpdual.primero.eadmin.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Expediente extends AdministracionElectronicaBase{
	
	private final TipoExpediente tipoExpediente;
	private final List<Documento> documentos;
	
	public Expediente(int id, String nombre, Usuario usuario, 
			Date fechaCreacion, TipoExpediente tipoExpediente, 
			List<Documento> documentos) {
		
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	
	public TipoExpediente getTipoExpediente() {
		return tipoExpediente;
	}
	
	public List<Documento> getDocumentos() {
		return this.documentos;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (object instanceof Expediente) {
			final Expediente expediente = (Expediente) object;
			return this.id == expediente.getId(); 
		}
		
		return false;
	}
	
	public List<Integer> obtenerLongitudNombresDocumentos() {
		
		if (documentos.size()==0) {
			throw new 
			AdministracionElectronicaException
			("lista de documentos vacía");
		}
		return documentos.stream().
				filter(this::esDocumentoContable).
				map(Documento::getNombre).
				map(String::length).
				collect(Collectors.toList());
		
	}
	
	private boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().
				equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}
	
	@Override 
	public int hashCode() {
		return this.id;
	}

	public Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipo() {
		
		return documentos.stream().collect(
				Collectors.groupingBy(d -> d.getTipoDocumento()));
	}
	
}
