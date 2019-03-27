package es.fpdual.primero.eadmin.modelo;

public class Usuario {

	private final int id;
	private final String nombre;
	private final String cargo;
	
	public Usuario(int id, String nombre, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCargo() {
		return cargo;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (object instanceof Usuario) {
			final Usuario usuario = (Usuario) object;
			return this.id == usuario.getId(); 
		}
		
		return false;
	}
	
	@Override 
	public int hashCode() {
		return this.id;
	}
}
