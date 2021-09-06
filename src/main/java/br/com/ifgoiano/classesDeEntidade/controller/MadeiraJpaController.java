/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifgoiano.classesDeEntidade.controller;

import br.com.ifgoiano.mapas.lenha.Madeira;
import br.com.ifgoiano.classesDeEntidade.exceptions.NonexistentEntityException;
import br.com.ifgoiano.classesDeEntidade.exceptions.PreexistingEntityException;
import br.com.ifgoiano.mapas.lenha.Madeira;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Root
 */

public class MadeiraJpaController implements Serializable {

    public MadeiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Madeira madeira) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(madeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMadeira(madeira.getId()) != null) {
                throw new PreexistingEntityException("Madeira " + madeira + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Madeira madeira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            madeira = em.merge(madeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = madeira.getId();
                if (findMadeira(id) == null) {
                    throw new NonexistentEntityException("The madeira with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Madeira madeira;
            try {
                madeira = em.getReference(Madeira.class, id);
                madeira.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The madeira with id " + id + " no longer exists.", enfe);
            }
            em.remove(madeira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Madeira> findMadeiraEntities() {
        return findMadeiraEntities(true, -1, -1);
    }

    public List<Madeira> findMadeiraEntities(int maxResults, int firstResult) {
        return findMadeiraEntities(false, maxResults, firstResult);
    }

    private List<Madeira> findMadeiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Madeira.class));
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

    public Madeira findMadeira(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Madeira.class, id);
        } finally {
            em.close();
        }
    }

    public int getMadeiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Madeira> rt = cq.from(Madeira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    /////////////////////////////grafico///////////////////////////////
    
    
  private StreamedContent	grafico;
	private static final Logger	log	= Logger.getLogger(MadeiraJpaController.class.getName()); 

	public MadeiraJpaController() {
		try {
			JFreeChart graficoPizza = ChartFactory.createPieChart("5 cidades mais populosas de SC", 
				this.geraDados(), true, true, false); 
			File arquivoGrafico = new File("pizza.png"); 
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoPizza, 500, 300); 
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png"); 
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}
	private DefaultPieDataset geraDados() {
		DefaultPieDataset dts = new DefaultPieDataset(); 
		dts.setValue("Blumenau", new Double(334002.0));
		dts.setValue("Criciúma", new Double(204667.0));
		dts.setValue("Florianopólis", new Double(461524.0));
		dts.setValue("Joinville", new Double(554601.0));
		dts.setValue("São José", new Double(228561.0));
		return dts;
	}
	public StreamedContent	getGrafico() {
		return this.grafico;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
