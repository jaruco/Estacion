package servicios;

import conexion.Conexion;
import entidades.Estacionamiento;
import entidades.ServicioEstac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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

    public ServicioEstac FindByPlaca(String placa, Date fechaini) {
        ServicioEstac ServEstacionamiento = null;
        Estacionamiento estacionamiento = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select est.idEstac ,est.ubicacion, se.fechaIni , se.idServEstac, se.fechaFin , se.horaIni , se.horaFin,ta.monto \n"
                    + "from Estacionamiento est\n"
                    + "inner join Vehiculo ve on est.idVehiculo = ve.idVehiculo\n"
                    + "inner join TipoVehiculo tv on ve.idTipoVehiculo = ve.idTipoVehiculo\n"
                    + "inner join Tarifa ta on tv.idTarifa = ta.idTarifa\n"
                    + "inner join ServicioEstac se on se.idEstac = est.idEstac\n"
                    + "where ve.placa =? and se.fechaIni = ?");
            stm.setString(1, placa);
            stm.setDate(2, new java.sql.Date(fechaini.getTime()));
            rs = stm.executeQuery();
            if (rs.next()) {
                estacionamiento = new Estacionamiento();
                ServEstacionamiento = new ServicioEstac();
                estacionamiento.setIdEstac(rs.getInt(1));
                estacionamiento.setUbicacion(rs.getString(2));
                ServEstacionamiento.setFechaIni(rs.getDate(3));
                ServEstacionamiento.setIdServEstac(rs.getInt(4));
                ServEstacionamiento.setFechaFin(rs.getDate(5));
                ServEstacionamiento.setHoraIni(rs.getTime(6));
                ServEstacionamiento.setHoraFin(rs.getTime(7));
                ServEstacionamiento.setEstacionamiento(estacionamiento);
                ServEstacionamiento.setTarifaTipoVehiculo(rs.getDouble(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServEstacionamiento;
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
