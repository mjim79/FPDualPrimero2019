package es.fpdual.primero.eadmin.respositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumentoEnLista;

public class RespositorioDocumentoEnListaTest {
	
	private RepositorioDocumentoEnLista repositorioDocumento;
	
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		
		this.repositorioDocumento = 
				new RepositorioDocumentoEnLista();
		this.documento =  mock(Documento.class);
	}
	
	@Test
	public void deberiaAlmacenarNuevoDocumento() {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(
			this.repositorioDocumento.
			obtenerTodosDocumentos().contains(documento));
		
		
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExceptionAlAlmacenarDocumentoYaExistente() {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
			
	}
	
	@Test
	public void deberiaModificarDocumento() {
		
		Documento documentoAlmacenado = new Documento(20, "Doc1",null,null, null);
		Documento documentoModificado = new Documento(20, "Doc2",null,null, null);
		
		this.repositorioDocumento.altaDocumento(documentoAlmacenado);
		
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("Doc2", this.repositorioDocumento
				.obtenerTodosDocumentos().
					get(0).getNombre());
	}

	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarDocumento() {
		
				
		this.repositorioDocumento.modificarDocumento(this.documento);
	
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		
		when(documento.getId()).thenReturn(20);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		this.repositorioDocumento.eliminarDocumento(20);
		
		assertTrue(
				this.repositorioDocumento.obtenerTodosDocumentos()
				.isEmpty());
	}
	
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste(){
		
		this.repositorioDocumento.eliminarDocumento(20);
		
	}
	
	@Test
	public void deberiaDevolver1SiLaListaEstaVacia() {
		
		final int resultado = 
				this.repositorioDocumento.getSiguienteId();
		
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void deberiaDevolverElSiguienteId() {
		
		when(documento.getId()).thenReturn(20);
		when(documento.getNombre()).thenReturn("documento1");
		
		this.repositorioDocumento.altaDocumento(documento);
		
		final int resultado = 
				this.repositorioDocumento.getSiguienteId();
		
		assertEquals(21, resultado);
		
	}
	
	
}

