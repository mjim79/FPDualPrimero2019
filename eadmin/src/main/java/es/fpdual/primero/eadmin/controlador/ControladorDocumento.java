package es.fpdual.primero.eadmin.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumentoImpl;

@RestController
public class ControladorDocumento {

	ServicioDocumento servicioDocumento;
	
	@Autowired
	public ControladorDocumento(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}
	
	@PostMapping("/documentos")
	public Documento altaDocumento(
			@RequestBody DocumentoRequest documentoRequest) {
			final Documento documentoAInsertar = 
					DocumentoRequestMapper.toDocumento(documentoRequest);
			
		return this.servicioDocumento.altaDocumento(documentoAInsertar);
	}
	
	@GetMapping("/documentos/{id}")
	public Documento obtenerDocumentoPorId(@PathVariable("id") int id) {
		return this.servicioDocumento.obtenerDocumentoPorId(id);
	}
	
	@GetMapping("/documentos")
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.servicioDocumento.obtenerTodosDocumentos();
	}
	
	@DeleteMapping("/documentos/{id}")
	public void eliminarDocmento(@PathVariable("id") int id) {
		this.servicioDocumento.eliminarDocumento(id);
	}

	
	@PutMapping("/documentos/{id}") 
	public void modifcarDocumento (
			@RequestBody DocumentoRequest documentoRequest, 
			@PathVariable int id) {
		
		final Documento documento = 
				this.servicioDocumento.obtenerDocumentoPorId(id);
		
		final Documento documentoAModificar = 
				DocumentoRequestMapper.toDocumentoCompleto(
						documentoRequest, documento.getId(),
						documento.getFechaCreacion());
		
		this.servicioDocumento.modificarDocumento(
				documentoAModificar);
	}
	
	
	
	
	
}
