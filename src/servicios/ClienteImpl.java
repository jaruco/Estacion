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
            stm.setInt(2, (int)id);
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
            stm = con.prepareStatement("select * from Cliente");
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

    @Override
    public Cliente find(Object id) {
        Cliente cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Cliente where idCliente = "+id);
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
    public List<Cliente> findByQuery(Cliente t) {return null;};
    
    public List<String> findClient(String dni){
        List<String> datosCliente = new ArrayList<>();
        try{
        con = Conexion.getInstance().getConnection();
        stm = con.prepareStatement("select cli.nombres, cli.apellidos from Cliente cli \n" +
                                   "left join ClienteDocIdent docs\n" +
                                   "on cli.idCliente = docs.idCliente\n" +
                                   "where docs.numero = '"+dni+"';");
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return datosCliente;
    }
}
