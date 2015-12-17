
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nishme
 */

public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idServ;
   
    private Integer idTurno;
    
    private Boolean estado;
    
    private Usuario usuario;
    
    private ClienteDocIdent clienteDocIdent;
   
    private List<ServicioEstac> servicioEstacList;

    public Servicio() {
    }

    public Servicio(Integer idServ) {
        this.idServ = idServ;
    }

    public Integer getIdServ() {
        return idServ;
    }

    public void setIdServ(Integer idServ) {
        this.idServ = idServ;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ClienteDocIdent getClienteDocIdent() {
        return clienteDocIdent;
    }

    public void setClienteDocIdent(ClienteDocIdent clienteDocIdent) {
        this.clienteDocIdent = clienteDocIdent;
    }

    public List<ServicioEstac> getServicioEstacList() {
        return servicioEstacList;
    }

    public void setServicioEstacList(List<ServicioEstac> servicioEstacList) {
        this.servicioEstacList = servicioEstacList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServ != null ? idServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServ == null && other.idServ != null) || (this.idServ != null && !this.idServ.equals(other.idServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Servicio[ idServ=" + idServ + " ]";
    }
    
}
