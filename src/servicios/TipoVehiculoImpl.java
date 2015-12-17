/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import conexion.Conexion;
import entidades.Tarifa;
import entidades.TipoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishme
 */
public class TipoVehiculoImpl implements InterfaceDAO<TipoVehiculo>{
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
  
    @Override
    public void insert(TipoVehiculo t) {
         try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("insert into TipoVehiculo(descripcion,estado,idTarifa) values(?,?,?)");
            stm.setString(1, t.getDescripcion());
            stm.setBoolean(2, Boolean.TRUE);
            stm.setInt(3, t.getTarifa().getIdTarifa());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TipoVehiculo t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update TipoVehiculo set descripcion=?,idTarifa=? where idTipoVehiculo=?");
            stm.setString(1, t.getDescripcion());
            stm.setInt(2, t.getTarifa().getIdTarifa());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Object id) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update TipoVehiculo set estado=? where idTipoVehiculo=?");
            stm.setBoolean(1, Boolean.FALSE);
            stm.setInt(2, (int)id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> allTypes() {
        List<String> vehiculos = new ArrayList<>();
        try{
            con  = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select descripcion from TipoVehiculo");
            rs = stm.executeQuery();
            while(rs.next()){                
                vehiculos.add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public TipoVehiculo find(Object id) {
        TipoVehiculo vehiculo = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from TipoVehiculo where estado=? and idTipoVehiculo=?");
            stm.setBoolean(1, Boolean.TRUE);
            stm.setInt(2, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                vehiculo = new TipoVehiculo();
                vehiculo.setIdTipoVehiculo(rs.getInt(1));
                vehiculo.setDescripcion(rs.getString(2));
                vehiculo.setTarifa(new Tarifa(rs.getInt(3)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehiculo;
    }

    @Override
    public List<TipoVehiculo> findByQuery(TipoVehiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoVehiculo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
