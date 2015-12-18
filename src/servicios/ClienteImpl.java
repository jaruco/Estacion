/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conexion.Conexion;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishme
 */
public class ClienteImpl implements InterfaceDAO<Cliente> {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    @Override
    public void insert(Cliente t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("insert into Cliente(nombres,apellidos,tipoPersona,estado) values(?,?,?,?)");
            stm.setString(1, t.getNombres());
            stm.setString(2, t.getApellidos());
            stm.setString(3, t.getTipoPersona());
            stm.setBoolean(4, Boolean.TRUE);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Cliente t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Cliente set nombres=?,apellidos=?,tipoPersona=? where idCliente=?");
            stm.setString(1, t.getNombres());
            stm.setString(2, t.getApellidos());
            stm.setString(3, t.getTipoPersona());
            stm.setInt(4, t.getIdCliente());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Object id) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Cliente set estado=? where idCliente=?");
            stm.setBoolean(1, Boolean.FALSE);
            stm.setInt(2, (int) id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Cliente where estado = ? ");
            stm.setBoolean(1, true);
            rs = stm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombres(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setTipoPersona(rs.getString(4));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }
     public List<Cliente> findByName(Cliente c) {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Cliente where estado = ? and nombres like ? and apellidos like ? ");
            stm.setBoolean(1, true);
            stm.setString(2, "%"+ c.getNombres() + "%");
            stm.setString(3, "%"+ c.getApellidos() + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombres(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setTipoPersona(rs.getString(4));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente find(Object id) {
        Cliente cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Cliente where idCliente = " + id);
            stm.setBoolean(1, Boolean.TRUE);
            stm.setInt(2, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombres(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setTipoPersona(rs.getString(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> findByQuery(Cliente t) {
        return null;
    };
    
    public List<String> findClient(String dni) {
        List<String> datosCliente = new ArrayList<>();
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select cli.nombres, cli.apellidos from Cliente cli left join ClienteDocIdent docs on cli.idCliente = docs.idCliente where docs.numero = '" + dni + "';");
            rs = stm.executeQuery();
            if (rs.next()) {
                datosCliente.add(rs.getString(1));
                datosCliente.add(rs.getString(2));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datosCliente;
    }
    
     public List<Cliente> findCliente(String nroDoc) {
        List<Cliente> datosCliente = new ArrayList<>();
        Cliente cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select cli.idcliente, cli.nombres, cli.apellidos, cli.tipoPersona from Cliente cli left join ClienteDocIdent docs on cli.idCliente = docs.idCliente where docs.numero = '" + nroDoc + "';");
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombres(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setTipoPersona(rs.getString(4));
                datosCliente.add(cliente);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datosCliente;
    }
}
