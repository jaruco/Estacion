/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
            stm = con.prepareStatement("insert into Turno(horaInicio,horaFin,descripcion,estado) values(?,?,?,?)");
            stm.setDate(1, (Date) t.getHoraInicio());
            stm.setDate(2, (Date) t.getHoraFin());
            stm.setString(3, t.getDescripcion());
            stm.setBoolean(4, Boolean.TRUE);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Turno t) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Turno set horaInicio=?,horaFin=?,descripcion=? where idTurno=?");
            stm.setDate(1, (Date) t.getHoraInicio());
            stm.setDate(2, (Date) t.getHoraFin());
            stm.setString(3, t.getDescripcion());
            stm.setInt(4, t.getIdTurno());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Object id) {
        try {
            con = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("update Turno set estado=? where idTurno=?");
            stm.setBoolean(1, Boolean.FALSE);
            stm.setInt(2, (int)id);
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
            stm = con.prepareStatement("select * from Turno");
            rs = stm.executeQuery();
            while(rs.next()){
            turno = new Turno();
            turno.setIdTurno(rs.getInt(1));
            turno.setHoraInicio(rs.getDate(2));
            turno.setHoraFin(rs.getDate(3));
            turno.setDescripcion(rs.getString(4));
            turno.setEstado(rs.getBoolean(5));
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
                turno.setHoraInicio(rs.getDate(2));
                turno.setHoraFin(rs.getDate(3));
                turno.setDescripcion(rs.getString(4));
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
    
    
    
}
