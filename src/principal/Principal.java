package principal;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.*;
import modelo.Modelo;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Modelo modelo = (Modelo) context.getBean("modelo");

		
		
		Proveedor proveedor1 = new Proveedor("R. Gomez", "629306096", "Ricardo");
		Proveedor proveedor2 = new Proveedor("P. Gandia", "655443388", "Pedro");
		Proveedor proveedor3 = new Proveedor("L. Zamora", "968665544", "Luis");
		
		System.out.println();
		System.out.println("Alta de proveedores en proceso");
		modelo.alta(proveedor1);
		modelo.alta(proveedor2);
		modelo.alta(proveedor3);

		System.out.println("Alta de proveedores acabada");
		Producto producto1 = new Producto("Tomate", "rico");
		modelo.alta(producto1);

		Compra compra = new Compra(4, 5.20, new GregorianCalendar(), producto1, proveedor1);
		System.out.println("Alta de Compra en proceso");
		modelo.alta(compra);
		System.out.println("Baja de proveedor en proceso");
		modelo.baja(proveedor2);

		ArrayList<Proveedor> misProveedores = (ArrayList<Proveedor>) modelo.consultaProveedores();
		System.out.println("Lista de proveedores");
		for (Proveedor p : misProveedores)
			System.out.println(p.getId());
		
		System.out.println("Todo correcto.");

	}
}
