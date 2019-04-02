package es.fpdual.primero.eadmin.controlador;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;

public class ControladorDocumentoTest {
	
	private ControladorDocumento controlador;
	private ServicioDocumento servicioDocumento;
	
	@Before
	public void ejecutarAntesDeCadaTest() {
		this.servicioDocumento = mock(ServicioDocumento.class);
		this.controlador = 
				new ControladorDocumento(servicioDocumento);
	}
	
	@Test
	public void deberialAlmacenarDocumento() {
		
		Documento documentoInsertado = mock(Documento.class);	
		DocumentoRequest documentoRequest = 
				mock(DocumentoRequest.class);
		
		when(this.servicioDocumento.
				altaDocumento(any())).
		thenReturn(documentoInsertado);
		when(documentoRequest.getUsuario()).thenReturn("20");
		when(documentoRequest.getTipoDocumento()).
			thenReturn("DOCUMENTO_CONTABLE");
		
		final Documento resultado = this.controlador.altaDocumento
				(documentoRequest);
		
		assertSame(documentoInsertado, resultado);
	}

}
