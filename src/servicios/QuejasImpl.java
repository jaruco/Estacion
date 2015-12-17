package servicios;

import conexion.Conexion;
import entidades.ClienteDocIdent;
import entidades.QuejasSugerencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuejasImpl implements InterfaceDAO<QuejasSugerencias>{
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    

    @Override
    public void insert(QuejasSugerencias t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("insert into QuejasSugerencias(idClienteDocIdent,observacion,estado) values(?,?,?)");
            stm.setInt(1, t.getClienteDocIdent().getIdClienteDocIdent());
            stm.setString(2, t.getObservacion());
            stm.setBoolean(3, Boolean.TRUE);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(QuejasSugerencias t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update QuejasSugerencias set idClienteDocIdent=?,observacion=? where idQuejasSug=?");
            stm.setInt(1, t.getClienteDocIdent().getIdClienteDocIdent());
            stm.setString(2, t.getObservacion());
            stm.setInt(3, t.getIdQuejasSug());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Object id) {
         try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update QuejasSugerencias set estado=? where idQuejasSug=?");
            stm.setBoolean(1, Boolean.FALSE);
            stm.setInt(2, (int)id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QuejasSugerencias> findAll() {
        List<QuejasSugerencias> quejas = new ArrayList<>();
        QuejasSugerencias queja = null;
        try{
             con  = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from QuejasSugerencias");
            rs = stm.executeQuery();
            while(rs.next()){
                queja = new QuejasSugerencias();
                queja.setIdQuejasSug(rs.getInt(1));
                queja.setClienteDocIdent(new ClienteDocIdent(rs.getInt(2)));
                queja.setObservacion(rs.getString(3));
                quejas.add(queja);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return quejas;
    }

    @Override
    public QuejasSugerencias find(Object id) {
        QuejasSugerencias quejas = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from QuejasSugerencias where estado=? and idQuejasSug=?");
            stm.setBoolean(1, Boolean.TRUE);
            stm.setInt(2, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                quejas = new QuejasSugerencias();
                quejas.setIdQuejasSug(rs.getInt(1));
                quejas.setClienteDocIdent(new ClienteDocIdent(rs.getInt(2)));
                quejas.setObservacion(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quejas;
    }

    @Override
    public List<QuejasSugerencias> findByQuery(QuejasSugerencias t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
