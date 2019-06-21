/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.dao;

import br.com.map.crudmap2.model.Usuario;
import br.com.map.crudmap2.util.MensagensUtil;
import br.com.map.crudmap2.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Allyson
 */
public class UsuarioDAO implements IDao<Usuario> {

    private EntityManager em;

    @Override
    public void salvar(Usuario t) throws Exception{
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_SALVAR));
        }finally{
            em.close();
        }
    }

    @Override
    public void editar(Usuario t) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EDITAR));
        }finally{
            em.close();
        }
    }

    @Override
    public void remover(Usuario t) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_EXCLUIR));
        }finally{
            em.close();
        }
    }

    @Override
    public List<Usuario> listar() throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        }finally{
            em.close();
        }
    }

    @Override
    public List<Usuario> buscar(String busca) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome LIKE :p");
            query.setParameter("p", busca + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        }finally{
            em.close();
        }
    }

    @Override
    public Usuario getPorId(int id) throws Exception {
        try {
            em = PersistenceUtil.createEntityManager();
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(MensagensUtil.getString(MensagensUtil.MSG_ERRO_CONSULTAR));
        }finally{
            em.close();
        }
    }

}
