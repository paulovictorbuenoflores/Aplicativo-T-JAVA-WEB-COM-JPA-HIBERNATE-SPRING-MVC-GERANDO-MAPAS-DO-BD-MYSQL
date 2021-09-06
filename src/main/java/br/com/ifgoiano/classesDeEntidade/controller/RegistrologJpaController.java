/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade.controller;

import br.com.ifgoiano.classesDeEntidade.Registrolog;

import br.com.ifgoiano.classesDeEntidade.exceptions.NonexistentEntityException;
import br.com.ifgoiano.classesDeEntidade.exceptions.PreexistingEntityException;
import br.com.ifgoiano.usuario.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import br.com.web.apocalipse.usuario.Usuarios;
/**
 *
 * @author Root
 */
public class RegistrologJpaController implements Serializable {

    public RegistrologJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registrolog registrolog) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarioId = registrolog.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                registrolog.setUsuarioId(usuarioId);
            }
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistrolog(registrolog.getId()) != null) {
                throw new PreexistingEntityException("Registrolog " + registrolog + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registrolog registrolog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Registrolog persistentRegistrolog = em.find(Registrolog.class, registrolog.getId());
            Usuarios usuarioIdOld = persistentRegistrolog.getUsuarioId();
            Usuarios usuarioIdNew = registrolog.getUsuarioId();
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                registrolog.setUsuarioId(usuarioIdNew);
            }
            registrolog = em.merge(registrolog);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registrolog.getId();
                if (findRegistrolog(id) == null) {
                    throw new NonexistentEntityException("The registrolog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Registrolog registrolog;
            try {
                registrolog = em.getReference(Registrolog.class, id);
                registrolog.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registrolog with id " + id + " no longer exists.", enfe);
            }
           
            em.remove(registrolog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registrolog> findRegistrologEntities() {
        return findRegistrologEntities(true, -1, -1);
    }

    public List<Registrolog> findRegistrologEntities(int maxResults, int firstResult) {
        return findRegistrologEntities(false, maxResults, firstResult);
    }

    private List<Registrolog> findRegistrologEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registrolog.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Registrolog findRegistrolog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registrolog.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistrologCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registrolog> rt = cq.from(Registrolog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
