package ar.com.jpa.beans.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "per_id")
	private Integer personaId;
	
	@Column(name = "per_nombre", nullable = false, length = 45)
	private String perNombre;
	
	@Column(name = "per_apellido", nullable = false, length = 45)
	private String perApellido;
	
	@Column(name = "per_dni", nullable = false, length = 45)
	private String perDni;
	
	@Column(name = "per_email", length = 45)
	private String perEmail;
	
	@Column(name = "per_telefono", length = 45)
	private String perTelefono;

	//Constructor vacio
	public Persona() {
		
	}
	
	//Constructor sin ID
	public Persona(String perNombre, String perApellido, String perDni,
			String perEmail, String perTelefono) {
		super();
		this.perNombre = perNombre;
		this.perApellido = perApellido;
		this.perDni = perDni;
		this.perEmail = perEmail;
		this.perTelefono = perTelefono;
	}

	//Constructor solo con ID
	public Persona(Integer personaId) {
		super();
		this.personaId = personaId;
	}

	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public String getPerDni() {
		return perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getPerTelefono() {
		return perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	@Override
	public String toString() {
		return "Persona |personaId=" + personaId + ", perNombre=" + perNombre
				+ ", perApellido=" + perApellido + ", perDni=" + perDni
				+ ", perEmail=" + perEmail + ", perTelefono=" + perTelefono
				+ "|";
	}
	
	
	
}
