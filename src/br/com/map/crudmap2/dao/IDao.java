/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.dao;

import java.util.List;

/**
 *
 * @author Allyson
 */
public interface IDao<T> {
    
    public void salvar(T t) throws Exception;
    
    public void editar(T t) throws Exception;
    
    public void remover(T t) throws Exception;
    
    public List<T> listar() throws Exception;
    
    public List<T> buscar(String busca) throws Exception;
   
    public T getPorId(int id) throws Exception;
}
