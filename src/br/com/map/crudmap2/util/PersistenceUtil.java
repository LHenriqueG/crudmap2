/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Allyson
 */
public class PersistenceUtil {
    
    private static final EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("CRUD-MAP-M-2PU");
    
    
    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }
}
