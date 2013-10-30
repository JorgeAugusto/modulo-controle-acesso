package net.marcoreis.seguranca.service;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.marcoreis.seguranca.model.Usuario;

//FIXME Verificar o nome para essa classe no Blueprints
@Stateless
public class FachadaUsuario {
  @Inject
  private Logger log;
  @Inject
  private EntityManager em;

  public void persistir(Usuario usuario) {
    em.persist(usuario);
    log.info("Persistir: " + usuario.getId());
  }

  public Usuario findByEmail(String email) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
    Root<Usuario> usuario = criteria.from(Usuario.class);
    criteria.select(usuario).where(cb.equal(usuario.get("email"), email));
    return em.createQuery(criteria).getSingleResult();
  }

  public Collection<Usuario> findAll() {
    return em.createQuery("from Usuario").getResultList();
  }

  public void excluir(Usuario u) {
    u = em.merge(u);
    em.remove(u);
  }

  public Usuario findById(Long id) {
    return em.find(Usuario.class, id);
  }
}
