/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade;

import br.com.ifgoiano.classesDeEntidade.exceptions.NonexistentEntityException;
import br.com.ifgoiano.classesDeEntidade.exceptions.PreexistingEntityException;
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

/**
 *
 * @author Root
 */
public class PostJpaController implements Serializable {

    public PostJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Post post) throws PreexistingEntityException, Exception {
        if (post.getPostComentarioCollection() == null) {
            post.setPostComentarioCollection(new ArrayList<PostComentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<PostComentario> attachedPostComentarioCollection = new ArrayList<PostComentario>();
            for (PostComentario postComentarioCollectionPostComentarioToAttach : post.getPostComentarioCollection()) {
                postComentarioCollectionPostComentarioToAttach = em.getReference(postComentarioCollectionPostComentarioToAttach.getClass(), postComentarioCollectionPostComentarioToAttach.getId());
                attachedPostComentarioCollection.add(postComentarioCollectionPostComentarioToAttach);
            }
            post.setPostComentarioCollection(attachedPostComentarioCollection);
            em.persist(post);
            for (PostComentario postComentarioCollectionPostComentario : post.getPostComentarioCollection()) {
                postComentarioCollectionPostComentario.getPostCollection().add(post);
                postComentarioCollectionPostComentario = em.merge(postComentarioCollectionPostComentario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPost(post.getId()) != null) {
                throw new PreexistingEntityException("Post " + post + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Post post) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Post persistentPost = em.find(Post.class, post.getId());
            Collection<PostComentario> postComentarioCollectionOld = persistentPost.getPostComentarioCollection();
            Collection<PostComentario> postComentarioCollectionNew = post.getPostComentarioCollection();
            Collection<PostComentario> attachedPostComentarioCollectionNew = new ArrayList<PostComentario>();
            for (PostComentario postComentarioCollectionNewPostComentarioToAttach : postComentarioCollectionNew) {
                postComentarioCollectionNewPostComentarioToAttach = em.getReference(postComentarioCollectionNewPostComentarioToAttach.getClass(), postComentarioCollectionNewPostComentarioToAttach.getId());
                attachedPostComentarioCollectionNew.add(postComentarioCollectionNewPostComentarioToAttach);
            }
            postComentarioCollectionNew = attachedPostComentarioCollectionNew;
            post.setPostComentarioCollection(postComentarioCollectionNew);
            post = em.merge(post);
            for (PostComentario postComentarioCollectionOldPostComentario : postComentarioCollectionOld) {
                if (!postComentarioCollectionNew.contains(postComentarioCollectionOldPostComentario)) {
                    postComentarioCollectionOldPostComentario.getPostCollection().remove(post);
                    postComentarioCollectionOldPostComentario = em.merge(postComentarioCollectionOldPostComentario);
                }
            }
            for (PostComentario postComentarioCollectionNewPostComentario : postComentarioCollectionNew) {
                if (!postComentarioCollectionOld.contains(postComentarioCollectionNewPostComentario)) {
                    postComentarioCollectionNewPostComentario.getPostCollection().add(post);
                    postComentarioCollectionNewPostComentario = em.merge(postComentarioCollectionNewPostComentario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = post.getId();
                if (findPost(id) == null) {
                    throw new NonexistentEntityException("The post with id " + id + " no longer exists.");
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
            Post post;
            try {
                post = em.getReference(Post.class, id);
                post.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The post with id " + id + " no longer exists.", enfe);
            }
            Collection<PostComentario> postComentarioCollection = post.getPostComentarioCollection();
            for (PostComentario postComentarioCollectionPostComentario : postComentarioCollection) {
                postComentarioCollectionPostComentario.getPostCollection().remove(post);
                postComentarioCollectionPostComentario = em.merge(postComentarioCollectionPostComentario);
            }
            em.remove(post);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Post> findPostEntities() {
        return findPostEntities(true, -1, -1);
    }

    public List<Post> findPostEntities(int maxResults, int firstResult) {
        return findPostEntities(false, maxResults, firstResult);
    }

    private List<Post> findPostEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Post.class));
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

    public Post findPost(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Post.class, id);
        } finally {
            em.close();
        }
    }

    public int getPostCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Post> rt = cq.from(Post.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
