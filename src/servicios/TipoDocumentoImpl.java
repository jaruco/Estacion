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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nishme
 */
public class TipoDocumentoImpl implements InterfaceDAO<TipoDocumento>{
     private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    @Override
    public void insert(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> findAll() {
        List<TipoDocumento> tiposDoc = new ArrayList<>();
        TipoDocumento tipoDoc = null;
        try{
             con  = Conexion.getInstance().getConnection();
            stm = con.prepareStatement("select  * from TipoDocumento");
            rs = stm.executeQuery();
            while(rs.next()){
                tipoDoc = new TipoDocumento();
                tipoDoc.setIdDoc(rs.getInt("idDoc") );
                tipoDoc.setAbreviatura(rs.getString("abreviatura"));
                tipoDoc.setDescripcion(rs.getString("descripcion"));
                tiposDoc.add(tipoDoc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tiposDoc;
    }

    @Override
    public TipoDocumento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> findByQuery(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
