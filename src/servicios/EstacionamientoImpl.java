package servicios;

import conexion.Conexion;
import entidades.Estacionamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstacionamientoImpl implements InterfaceDAO<Estacionamiento> {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    @Override
    public void insert(Estacionamiento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estacionamiento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estacionamiento> findAll() {
        List<Estacionamiento> estacionamientos = new ArrayList<>();
        Estacionamiento estacionamiento = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Estacionamiento");
            rs = stm.executeQuery();
            while (rs.next()) {
                estacionamiento = new Estacionamiento();
                estacionamiento.setIdEstac(rs.getInt(1));
//                estacionamiento.setTipoVehiculo();
//                queja.setIdQuejasSug(rs.getInt(1));
//                queja.setClienteDocIdent(new ClienteDocIdent(rs.getInt(2)));
//                queja.setObservacion(rs.getString(3));
//                quejas.add(queja);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estacionamientos;
    }

    public List<String> allTypes() {
        List<String> estacionamientos = new ArrayList<>();
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select ubicacion from Estacionamiento where estado = '1'");
            rs = stm.executeQuery();
            while (rs.next()) {
                estacionamientos.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estacionamientos;
    }

    @Override
    public Estacionamiento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estacionamiento> findByQuery(Estacionamiento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
