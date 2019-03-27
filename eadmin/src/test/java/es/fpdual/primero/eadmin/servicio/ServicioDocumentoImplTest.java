package es.fpdual.primero.eadmin.servicio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;

public class ServicioDocumentoImplTest {

	RepositorioDocumento repositorioDocumento;
	ServicioDocumentoImpl servicioDocumento;
	
	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento = 
				mock(RepositorioDocumento.class);
		this.servicioDocumento = 
			new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		
		List<Documento> listaDevueltaPorElRepositorio 
			= new ArrayList<>();
		when(repositorioDocumento.obtenerTodosDocumentos()).
			thenReturn(listaDevueltaPorElRepositorio);
		
		final List<Documento> resultado = servicioDocumento.
				obtenerTodosDocumentos();
		
		assertEquals(listaDevueltaPorElRepositorio, 
				resultado);
	}
	
	
	@Test
	public void deberiaModificarUnDocumento() {
		
		
		Documento documento = mock(Documento.class);
		Documento documentoDevueltoPorElRepositorio = 
				mock(Documento.class);
		when(repositorioDocumento.modificarDocumento(documento)).
			thenReturn(documentoDevueltoPorElRepositorio);
		
		final Documento resultado = servicioDocumento.
				modificarDocumento(documento);
		
		assertEquals(documentoDevueltoPorElRepositorio, 
				resultado);
	}
	
	@Test
	public void deberiaEliminarDocumentoConCodigoFacilitado() {
		
		
		this.servicioDocumento.eliminarDocumento(20);
		
		verify(this.repositorioDocumento).eliminarDocumento(20);
	}
}
