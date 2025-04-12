/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ComandaDAO;
import DTOs.ComandaNuevaDTO;
import DTOs.ComandaProductoNuevaDTO;
import DTOs.ComandaViejaDTO;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import entidades.ComandaProducto;
import entidades.Mesa;
import entidades.Producto;
import enums.estadoComanda;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import mapper.ClienteFrecuenteMapper;
import mapper.ComandaMapper;
import mapper.ComandaProductoMapper;
import mapper.MesaMapper;
import mapper.ProductoMapper;

/**
 *
 * @author daniel
 */
public class ComandaBO {
    
    private IComandaDAO comandaDAO = ComandaDAO.getInstancia();
    private static ComandaBO comandaBO;
    
    private ComandaBO() {
    }
    
    public static ComandaBO getInstancia() {
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
        ClienteFrecuente cliente = ClienteFrecuenteMapper.toEntity(comandaNuevaDTO.getCliente());
        Mesa mesa = MesaMapper.toEntity(comandaNuevaDTO.getMesa());
        
        List<ComandaProductoNuevaDTO> productosDTO = comandaNuevaDTO.getProductos();
        List<ComandaProducto> productos = new ArrayList();
        
        for (ComandaProductoNuevaDTO comandaProductoDTO : productosDTO) {
            Producto producto = ProductoMapper.toEntity(comandaProductoDTO.getProducto());
            ComandaProducto comandaProducto = ComandaProductoMapper.toEntity(comandaProductoDTO);
            comandaProducto.setProducto(producto);
            comandaProducto.setComanda(comanda);
            productos.add(comandaProducto);
        }
        
        cliente.getComandas().add(comanda);
        
        comanda.setMesa(mesa);
        comanda.setCliente(cliente);
        comanda.setProductos(productos);
        comanda.setFechaYHora(LocalDateTime.now());
        comanda.setFolio(generarFolio(comanda.getFechaYHora()));
        
        try {
            Comanda comandaGuardada = comandaDAO.registrarComanda(comanda);
            
            if (comandaGuardada.getId() == null) {
                return true;
            } else {
                return false;
            }
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al registrar Comanda");
        }
    }
    
    public String generarFolio(LocalDateTime fechaHora) throws NegocioException {
        String fecha = fechaHora.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String folio = "OB-" + fecha;
        try {
            String numero = String.format("%03d", comandaDAO.obtenerCantidadComandas());
            return folio + "-" + numero;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al generar folio");
        }
    }
    
    public boolean actaulizarEstado(ComandaViejaDTO comandaViejaDTO) throws NegocioException {
        return true;
    }
    
    public List<ComandaViejaDTO> obtenerComandasAbiertas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasPorEstado(estadoComanda.ABIERTO);
            List<ComandaViejaDTO> comandasDTO = new ArrayList();
            
            for (Comanda comanda: comandas) {
                comandasDTO.add(ComandaMapper.toViejoDTO(comanda));
            }
            
            return comandasDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al consultar comandas.");
        }
    }
}
