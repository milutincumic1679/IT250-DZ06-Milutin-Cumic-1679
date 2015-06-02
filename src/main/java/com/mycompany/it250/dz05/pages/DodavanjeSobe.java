/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.it250.dz05.pages;

import com.mycompany.it250.dz05.entities.Soba;
import com.mycompany.it250.dz05.entities.Soba;
import java.util.ArrayList;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
/**
 *
 * @author mcumic10
 */
public class DodavanjeSobe {

    @Property
    private Soba soba;
    @Inject
    private Session session;
    @Property
    private ArrayList<Soba> sobe;

    void onActivate() {
        if (sobe == null) {
            sobe = new ArrayList<Soba>();
        }
// createCriteria metoda pravi Select * upit nad prosle?enom klasom
        sobe = (ArrayList<Soba>) session.createCriteria(Soba.class).list();
    }

    @CommitAfter
    Object onSuccess() {
// persist metoda ?uva objekatu bazi podataka
        session.persist(soba);
        return this;
    }
}
