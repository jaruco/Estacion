/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteDocIdent;
import entidades.TipoDocumento;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishme
 */
public class ClienteDocImpl implements InterfaceDAO<ClienteDocIdent> {
    
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    @Override
    public void insert(ClienteDocIdent t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("insert into ClienteDocIdent(idCliente,idDoc,numero,estado) values(?,?,?,?)");
            stm.setInt(1, t.getCliente().getIdCliente());
            stm.setInt(2, t.getTipoDocumento().getIdDoc());
            stm.setString(3, t.getNumero());
            stm.setBoolean(4, Boolean.TRUE);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ClienteDocIdent t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update ClienteDocIdent set idCliente=?,idDoc=?,numero=? where idClienteDocIdent=?");
            stm.setInt(1, t.getCliente().getIdCliente());
            stm.setInt(2, t.getTipoDocumento().getIdDoc());
            stm.setString(3, t.getNumero());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Object id) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update ClienteDocIdent set estado=? where idClienteDocIdent=?");
            stm.setBoolean(1, Boolean.FALSE);
            stm.setInt(2, (int)id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClienteDocIdent> findAll() {
        List<ClienteDocIdent> clientedocid = new ArrayList<>();
        ClienteDocIdent clientedoc = null;
        try{
             con  = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from ClienteDocIdent");
            rs = stm.executeQuery();
            while(rs.next()){
                clientedoc = new ClienteDocIdent();
                clientedoc.setIdClienteDocIdent(rs.getInt(1));
                clientedoc.setCliente(new Cliente(rs.getInt(2)));
                clientedoc.setTipoDocumento(new TipoDocumento(rs.getInt(3)));
                clientedoc.setNumero(rs.getString(4));
                clientedocid.add(clientedoc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return clientedocid;
    }

    @Override
    public ClienteDocIdent find(Object id) {
        ClienteDocIdent cliente = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from ClienteDocIdent where estado=? and idClienteDocIdent=?");
            stm.setBoolean(1, Boolean.TRUE);
            stm.setInt(2, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new ClienteDocIdent();
                cliente.setIdClienteDocIdent(rs.getInt(1));
                cliente.setCliente(new Cliente(rs.getInt(2)));
                cliente.setTipoDocumento(new TipoDocumento(rs.getInt(3)));
                cliente.setNumero(rs.getString(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<ClienteDocIdent> findByQuery(ClienteDocIdent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
