package smf.controller;

import smf.entity.Ttpdv;
import smf.entity.Unidades;

import javax.persistence.EntityManager;

public class TtpdvJpaController extends BaseJpaController<Ttpdv> {

    public TtpdvJpaController(EntityManager em) {

        super(em);

    }

    public Ttpdv findById(Integer tdvId) {
        try {
            return em.find(Ttpdv.class, tdvId);
        } finally {

        }
    }




}
