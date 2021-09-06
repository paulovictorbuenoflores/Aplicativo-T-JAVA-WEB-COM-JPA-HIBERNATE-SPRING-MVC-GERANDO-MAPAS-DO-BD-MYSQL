/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade.controller;

import br.com.ifgoiano.classesDeEntidade.Post;
import br.com.ifgoiano.classesDeEntidade.PostComentario;

import br.com.ifgoiano.classesDeEntidade.exceptions.NonexistentEntityException;
import br.com.ifgoiano.classesDeEntidade.exceptions.PreexistingEntityException;
import br.com.ifgoiano.usuario.Usuarios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import br.com.web.apocalipse.usuario.Usuarios;
/**
 *
 * @author Root
 */
public class PostComentarioJpaController implements Serializable {

    public PostComentarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PostComentario postComentario) throws PreexistingEntityException, Exception {
        if (postComentario.getPostCollection() == null) {
            postComentario.setPostCollection(new ArrayList<Post>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarioId = postComentario.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                postComentario.setUsuarioId(usuarioId);
            }
            Collection<Post> attachedPostCollection = new ArrayList<Post>();
            for (Post postCollectionPostToAttach : postComentario.getPostCollection()) {
                postCollectionPostToAttach = em.getReference(postCollectionPostToAttach.getClass(), postCollectionPostToAttach.getId());
                attachedPostCollection.add(postCollectionPostToAttach);
            }
            postComentario.setPostCollection(attachedPostCollection);
           
            for (Post postCollectionPost : postComentario.getPostCollection()) {
                postCollectionPost.getPostComentarioCollection().add(postComentario);
                postCollectionPost = em.merge(postCollectionPost);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPostComentario(postComentario.getId()) != null) {
                throw new PreexistingEntityException("PostComentario " + postComentario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PostComentario postComentario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PostComentario persistentPostComentario = em.find(PostComentario.class, postComentario.getId());
            Usuarios usuarioIdOld = persistentPostComentario.getUsuarioId();
            Usuarios usuarioIdNew = postComentario.getUsuarioId();
            Collection<Post> postCollectionOld = persistentPostComentario.getPostCollection();
            Collection<Post> postCollectionNew = postComentario.getPostCollection();
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                postComentario.setUsuarioId(usuarioIdNew);
            }
            Collection<Post> attachedPostCollectionNew = new ArrayList<Post>();
            for (Post postCollectionNewPostToAttach : postCollectionNew) {
                postCollectionNewPostToAttach = em.getReference(postCollectionNewPostToAttach.getClass(), postCollectionNewPostToAttach.getId());
                attachedPostCollectionNew.add(postCollectionNewPostToAttach);
            }
            postCollectionNew = attachedPostCollectionNew;
            postComentario.setPostCollection(postCollectionNew);
            postComentario = em.merge(postComentario);
           
            for (Post postCollectionOldPost : postCollectionOld) {
                if (!postCollectionNew.contains(postCollectionOldPost)) {
                    postCollectionOldPost.getPostComentarioCollection().remove(postComentario);
                    postCollectionOldPost = em.merge(postCollectionOldPost);
                }
            }
            for (Post postCollectionNewPost : postCollectionNew) {
                if (!postCollectionOld.contains(postCollectionNewPost)) {
                    postCollectionNewPost.getPostComentarioCollection().add(postComentario);
                    postCollectionNewPost = em.merge(postCollectionNewPost);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = postComentario.getId();
                if (findPostComentario(id) == null) {
                    throw new NonexistentEntityException("The postComentario with id " + id + " no longer exists.");
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
            PostComentario postComentario;
            try {
                postComentario = em.getReference(PostComentario.class, id);
                postComentario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The postComentario with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuarioId = postComentario.getUsuarioId();
            
            Collection<Post> postCollection = postComentario.getPostCollection();
            for (Post postCollectionPost : postCollection) {
                postCollectionPost.getPostComentarioCollection().remove(postComentario);
                postCollectionPost = em.merge(postCollectionPost);
            }
            em.remove(postComentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PostComentario> findPostComentarioEntities() {
        return findPostComentarioEntities(true, -1, -1);
    }

    public List<PostComentario> findPostComentarioEntities(int maxResults, int firstResult) {
        return findPostComentarioEntities(false, maxResults, firstResult);
    }

    private List<PostComentario> findPostComentarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PostComentario.class));
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

    public PostComentario findPostComentario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PostComentario.class, id);
        } finally {
            em.close();
        }
    }

    public int getPostComentarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PostComentario> rt = cq.from(PostComentario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
