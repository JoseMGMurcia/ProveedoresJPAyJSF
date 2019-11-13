package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;

@Repository
@Transactional
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;

	public Producto alta(Producto c) {
		try {
			em.persist(c);
		} catch (DataAccessException ex) {
			return null;
		}
		return c;
	}

	public boolean baja(int id) {
		try {
			Producto p = this.consulta(id); 
			em.remove(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean modificacion(Producto p) {
		try {
			em.merge(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(readOnly = true)
	public Producto consulta(int idProducto) {
		try {
			return em.find(Producto.class, idProducto);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public ArrayList<Producto> consultaAll() {
		try {
			Query query = em.createQuery("SELECT p FROM Producto p");
			ArrayList<Producto> todoslosProductos = (ArrayList<Producto>) query.getResultList();
			return todoslosProductos;
		} catch (Exception e) {
			return null;
		}

	}

}
