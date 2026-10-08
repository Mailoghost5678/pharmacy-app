package com.example.ejb;

import com.example.entity.Medicine;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MedicineFacade {

    @PersistenceContext(unitName = "PharmacyPU")
    private EntityManager em;

    public List<Medicine> findAll() {
        return em.createQuery("SELECT m FROM Medicine m", Medicine.class).getResultList();
    }

    public Medicine find(Long id) {
        return em.find(Medicine.class, id);
    }

    public void create(Medicine m) { em.persist(m); }
    public void edit(Medicine m)   { em.merge(m); }

    public void remove(Long id) {
        Medicine m = em.find(Medicine.class, id);
        if (m != null) em.remove(m);
    }
}
