package control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import dominio.Usuario;
import modelo.Modelo;

public class CLogin extends Control {

	private Usuario usuario;
	
	
	public boolean validarDatos() {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Modelo modelo = (Modelo) context.getBean("modelo");
			System.out.println("Usuario" + usuario.getId());

		return false;
	}

	
	public String botonLogin() {
		
		if (validarDatos()) {
			if (usuario.getLogin().equals("Gerente")) {
				return "LoginJefe";
			}else {
				return "LoginEmpleado";
			}
		}
		return "LoginMal";
	}

	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
