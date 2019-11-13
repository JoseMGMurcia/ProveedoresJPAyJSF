package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Producto;
import dominio.Proveedor;

@Repository
@Transactional
public class ProveedorDAO {

	@PersistenceContext
	private EntityManager em;

	public Proveedor alta(Proveedor c) {
		try {
			em.persist(c);
		} catch (DataAccessException ex) {
			return null;
		}
		return c;
	}

	public boolean baja(int id) {
		try {
			Proveedor p = this.consulta(id);
			em.remove(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean modificacion(Proveedor p) {
		try {
			em.merge(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(readOnly = true)
	public Proveedor consulta(int idProveedor) {
		try {
			return em.find(Proveedor.class, idProveedor);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public ArrayList<Proveedor> consultaAll() {
		try {
			Query query = em.createQuery("SELECT p FROM Proveedor p");
			ArrayList<Proveedor> todoslosProveedores = (ArrayList<Proveedor>) query.getResultList();
			return todoslosProveedores;
		} catch (Exception e) {
			return null;
		}

	}
}
