package es.fpdual.primero.eadmin.controlador;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

public class DocumentoRequestMapper {

	private DocumentoRequestMapper() {
		// sonar
	}

	public static Documento toDocumento(DocumentoRequest documentoRequest) {
		
		return new Documento(0,
				documentoRequest.getNombre(),
				construyeUsuario(documentoRequest), 
				null,
				construyeTipoDocumento(documentoRequest.getTipoDocumento()));
	}

	private static TipoDocumento construyeTipoDocumento(String tipoDocumento) {
		
		TipoDocumento resultado;
		
		switch(tipoDocumento.toUpperCase()) {
			case "DOCUMENTO_CONTABLE":
				resultado = TipoDocumento.DOCUMENTO_CONTABLE;
				break;
			case "DOCUMENTO_FACTURA":
				resultado = TipoDocumento.DOCUMENTO_FACTURA;
				break;
			case "DOCUMENTO_NOMINA":
				resultado = TipoDocumento.DOCUMENTO_NOMINA;
				break;
			case "DOCUMENTO_SUBVENCION":
				resultado = TipoDocumento.DOCUMENTO_SUBVENCION;
				break;
			case "DOCUMENTO_PADRON":
				resultado = TipoDocumento.DOCUMENTO_PADRON;
				break;
			default:
				resultado = TipoDocumento.DOCUMENTO_CONTABLE;
		}
		
		return resultado;
	}

	private static Usuario construyeUsuario(DocumentoRequest documentoRequest) {
		return new Usuario(Integer.parseInt(documentoRequest.getUsuario()),
				"usuario"+documentoRequest.getUsuario(),
				"cargo"+documentoRequest.getUsuario());
	}
	
	
}
