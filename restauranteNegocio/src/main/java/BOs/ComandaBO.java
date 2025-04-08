/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ComandaDAO;
import DTOs.ComandaNuevaDTO;
import DTOs.ComandaProductoNuevaDTO;
import DTOs.ProductoViejoDTO;
import entidades.Comanda;
import exception.NegocioException;
import interfaces.IComandaDAO;
import mapper.ComandaMapper;

/**
 *
 * @author daniel
 */
public class ComandaBO {
    
    private IComandaDAO comandaDAO = ComandaDAO.getInstancia();
    private static ComandaBO comandaBO;
    
    private ComandaBO() {
    }
    
    public ComandaBO getInstancia() {
        if (comandaBO == null) {
            comandaBO = new ComandaBO();
        }
        return comandaBO;
    }
    
    public boolean registrarComanda(ComandaNuevaDTO comandaNuevaDTO) throws NegocioException {
        if (comandaNuevaDTO.getEstado() == null) {
            throw new NegocioException("Error, el estado no puede estar vacio.");
        }
        if (comandaNuevaDTO.getMesa() == null) {
            throw new NegocioException("Error, la mesa no puede estar vacia.");
        }
        if (comandaNuevaDTO.getProductos().isEmpty()) {
            throw new NegocioException("Error, la comanda tiene que tener al menos un producto.");
        }
        for (ComandaProductoNuevaDTO producto : comandaNuevaDTO.getProductos()) {
            if (producto.getProducto() == null) {
                throw new NegocioException("Error, el Producto no puede estar vacio.");
            }
            if (producto.getCantidadRequerida() == null || producto.getCantidadRequerida() == 0) {
                throw new NegocioException("Error, la cantidad debe de ser al menos 1 para cada Producto");
            }
        }
        
        Comanda comanda = ComandaMapper.toEntity(comandaNuevaDTO);
        return true;
    }
}
