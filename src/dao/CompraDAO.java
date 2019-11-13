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
public class CompraDAO {

	@PersistenceContext
	private EntityManager em;

	public Compra alta(Compra c) {
		try {
			em.persist(c);
		} catch (DataAccessException ex) {
			return null;
		}
		return c;
	}

	public boolean baja(int id) {
		try {
			Compra c = this.consulta(id); 
			em.remove(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean modificacion(Compra c) {
		try {
			em.merge(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(readOnly = true)
	public Compra consulta(int idCompra) {
		try {
			return em.find(Compra.class, idCompra);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public ArrayList<Compra> consultaAll() {
		try {
			Query query = em.createQuery("SELECT c FROM Compra c");
			ArrayList<Compra> todaslasCompras = (ArrayList<Compra>) query.getResultList();
			return todaslasCompras;
		} catch (Exception e) {
			return null;
		}

	}
}
