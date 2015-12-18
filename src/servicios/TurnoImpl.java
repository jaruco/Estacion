/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Tempzlates
 * and open the template in the editor.
 */
package servicios;

import conexion.Conexion;
import entidades.Turno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishme
 */
public class TurnoImpl implements InterfaceDAO<Turno> {
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    @Override
    public void insert(Turno t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("insert into Turno(horaInicio,horaFin,estado) values(?,?,?)");
            stm.setString(1,t.getHoraInicio());
            stm.setString(2,t.getHoraFin());
            stm.setBoolean(3, Boolean.TRUE);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Turno t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Turno set horaInicio=?,horaFin=? where idTurno=?");
            stm.setString(1,t.getHoraInicio());
            stm.setString(2,t.getHoraFin());
            stm.setInt(3, t.getIdTurno());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void eliminarTurno(int id) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Turno set estado=0 where idTurno="+id+"");
//            stm.setBoolean(1, Boolean.FALSE);
//            stm.setInt(1, (int)id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Turno> findAll() {
        List<Turno> turnos = new ArrayList<>();
        Turno turno = null;
        try{
            con  = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Turno where estado<>0");
            rs = stm.executeQuery();
            while(rs.next()){
            turno = new Turno();
            turno.setIdTurno(rs.getInt(1));
            turno.setHoraInicio(rs.getString(2));
            turno.setHoraFin(rs.getString(3));
            turno.setEstado(rs.getBoolean(4));
            turnos.add(turno);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return turnos;
    }

    @Override
    public Turno find(Object id) {
        Turno turno = null;
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select * from Turno where estado=? and idTurno=?");
            stm.setBoolean(1, Boolean.TRUE);
            stm.setInt(2, (int) id);
            rs = stm.executeQuery();
            if (rs.next()) {
                turno = new Turno();
                turno.setIdTurno(rs.getInt(1));
                turno.setHoraInicio(rs.getString(2));
                turno.setHoraFin(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return turno;
    }

    @Override
    public List<Turno> findByQuery(Turno t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public void eliminar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
