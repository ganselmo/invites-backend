package invites.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Invite {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(nullable = false)
	private int dni;
	@Column(nullable = false) 
	private String name;
	@Column(nullable = false)
	private String last_name;
	@Column(nullable = false)
	private String direction;
	@Column(nullable = false)
	private Date birthdate;
	
	public Invite() {
		super();
	}

	public int getId() {
		return id;
	}

	public int getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getDirection() {
		return direction;
	}

	public Date getBirthdate() {
		return birthdate;
	}
	
	
	
}
