package es.fpdual.primero.eadmin;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaBase;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.Expediente;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.TipoExpediente;
import es.fpdual.primero.eadmin.modelo.Usuario;

@SpringBootApplication
public class EadminApplication {

	public static void main(String[] args) {
		
		final Usuario usuario = new Usuario(4, "bob", "chef");
		final Date fecha = new Date();
		
		
		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario
						, fecha, "10005756468461356");
		
		final Documento documento = new DocumentoContable(15, "operacion", usuario
				, fecha, "99999999999955574");
		

		
		SpringApplication.run(EadminApplication.class, args);
	}

}











