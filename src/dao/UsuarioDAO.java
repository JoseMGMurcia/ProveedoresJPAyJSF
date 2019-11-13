package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	public Usuario alta(Usuario u) {
		try {
			em.persist(u);
		} catch (DataAccessException ex) {
			return null;
		}
		return u;
	}

	public boolean baja(int id) {
		try {
			Usuario u = this.consulta(id);
			em.remove(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean modificacion(Usuario u) {
		try {
			em.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(readOnly = true)
	public Usuario consulta(int idUsuario) {
		try {
			return em.find(Usuario.class, idUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public ArrayList<Usuario> consultaAll() {
		try {
			Query query = em.createQuery("SELECT u FROM Usuario u");
			ArrayList<Usuario> todoslosUsuarios = (ArrayList<Usuario>) query.getResultList();
			return todoslosUsuarios;
		} catch (Exception e) {
			return null;
		}

	}
}
