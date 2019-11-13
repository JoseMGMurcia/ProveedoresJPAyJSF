package dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tusuarios")
public class Usuario implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
	private int id;
    
    @Basic(optional = false)
    @Column(name = "Login")	
    private String login;
    
    @Basic(optional = false)
    @Column(name = "Pass")	
	private String pass;
	
    
    public Usuario() {
    	
    }

    
    
    

	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

    
    
    
    
}
