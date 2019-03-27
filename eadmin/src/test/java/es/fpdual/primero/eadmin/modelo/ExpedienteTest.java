package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.beans.factory.config.YamlProcessor.DocumentMatcher;

import ch.qos.logback.core.net.SyslogOutputStream;

public class ExpedienteTest {
	
	private final Usuario usuario = new Usuario(2,"usu", "c");
	private final Date fechaCreacion = new Date();
	
	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {
		// inicialización
		final DocumentoContable documentoContable = 
				new DocumentoContable(10, "operacion contable", usuario
				, new Date(), "10005756468461356");

		final Documento documento = new DocumentoContable(15, "operacion", 
				usuario , new Date(), "99999999999955574");
		
		final Documento documentoNuevo = new Documento(20,"nuevo documento", 
				usuario, new Date(), TipoDocumento.DOCUMENTO_PADRON);
		
		final List<Documento> documentos = new ArrayList<Documento>();
		documentos.add(documentoContable);
		documentos.add(documentoNuevo);
		documentos.add(documento);
		
		
		for(Documento documentoActual: documentos) {
			if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
		}
		
		documentos.stream().
			filter(documentoActual 
					-> esDocumentoContable(documentoActual)).
			forEach(documentoActual 
						-> System.out.println(documentoActual));
		
		documentos.stream().
			filter(this::esDocumentoContable).
			forEach(System.out::println);
		
		final List<Documento> doumentosContables = 
			documentos.stream().
				filter(this::esDocumentoContable).
				collect(Collectors.toList());
			
		documentos.stream()
		.map(documentoActual 
				-> documentoActual.getNombre())
		.map(nombre -> nombre.length() )
		.forEach(longitud 
						-> System.out.println(longitud));
		
		documentos.stream()
		.map(Documento::getNombre)
		.map(String::length)
		.forEach(System.out::println);
		
		for(Documento documentoActual: documentos) {
			System.out.println(documentoActual.getNombre().length());
		}
		
		// ejecución
		final Expediente expediente = new Expediente(1, "expediente 1", 
				usuario, new Date(), TipoExpediente.EXPEDIENTE_LICENCIA_OBRAS, 
				documentos);
		
		// comprobación de resultados
		assertEquals(documentos, expediente.getDocumentos());
		assertTrue(expediente.getDocumentos().contains(documentoContable));
		assertEquals(3, expediente.getDocumentos().size());
	}
	
	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().
				equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}
	
	@Test
	public void deberiaObtenerLongiudNombresDocumentos() {
		
		// inicilización
		final Documento doc1 = new Documento(1,"uno", 
				usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento doc2 = new Documento(2, "cuatro", 
				usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_CONTABLE);

		final List<Documento> documentos = new ArrayList<>();
		documentos.add(doc1);
		documentos.add(doc2);
		final Expediente expediente = new Expediente
				(1, "nombre", usuario, fechaCreacion,
				TipoExpediente.EXPDIENTE_SUBVENCIONES, 
				documentos);
		
		// ejecución
		final List<Integer> resultado = expediente.
				obtenerLongitudNombresDocumentos();
		
		// comprobación de resultados
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		assertEquals(Integer.parseInt("6"), resultado.get(1).intValue());
	}
	
	@Test
	public void deberiaDevolerDocumentosAgrupadosPorTipo() {
		final Documento doc1 = new Documento(1,"uno", 
				usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento doc2 = new Documento(2, "cuatro", 
				usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento doc3 = new Documento(3, "otro", 
				usuario, fechaCreacion, 
				TipoDocumento.DOCUMENTO_NOMINA);
		final List<Documento> documentos = new ArrayList<>();
		documentos.add(doc1);
		documentos.add(doc2);
		documentos.add(doc3);
		final Expediente expediente = new Expediente
				(1, "nombre", usuario, fechaCreacion,
				TipoExpediente.EXPDIENTE_SUBVENCIONES, 
				documentos);
		
		final Map<TipoDocumento, List<Documento>> resultado = 
				expediente.obtenerDocumentosPorTipo();
		System.out.println(resultado.toString());
		
		assertEquals(2, resultado.get(TipoDocumento.DOCUMENTO_CONTABLE).size());
		assertEquals(1, resultado.get(TipoDocumento.DOCUMENTO_NOMINA).size());
	}
}
