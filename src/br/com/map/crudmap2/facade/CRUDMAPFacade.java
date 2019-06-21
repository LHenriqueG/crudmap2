/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.facade;

import br.com.map.crudmap2.dao.UsuarioDAO;
import br.com.map.crudmap2.model.Usuario;
import java.util.List;

/**
 *
 * @author Allyson
 */
public class CRUDMAPFacade {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public void salvarUsuario(Usuario usuario) throws Exception{
        usuarioDAO.salvar(usuario);
    }
    
    public void editarUsuario(Usuario usuario) throws Exception{
        usuarioDAO.editar(usuario);
    }
    
    public void removerUsuario(Usuario usuario) throws Exception{
        usuarioDAO.remover(usuario);
    }
    
    public Usuario buscarUsuario(int id) throws Exception{
        return usuarioDAO.getPorId(id);
    }
    
    public List<Usuario> listarUsuarios() throws Exception{
        return usuarioDAO.listar();
    }
    
    public List<Usuario> buscarUsuarios(String busca) throws Exception{
        return usuarioDAO.buscar(busca);
    }
}
