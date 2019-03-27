package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentoTest {
	
	@Test
	public void deberiaDevolverTrueSiLosDocumentosSonIguales() {
		
		//inicialización
		final Documento documento1 = 
				new Documento(20,null,null,null,null);
		final Documento documento2 = 
				new Documento(20,null,null,null,null);

		
		//ejecución
		final boolean resultado = documento1.equals(documento2);
		
		//comprobación de resultados
		assertTrue(resultado);
	}

}
