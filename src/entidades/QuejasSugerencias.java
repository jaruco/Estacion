
package entidades;

import java.io.Serializable;

/**
 *
 * @author Nishme
 */

public class QuejasSugerencias implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idQuejasSug;
    
    private String observacion;
    
    private ClienteDocIdent clienteDocIdent;
    
    private Boolean estado;

    public QuejasSugerencias() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public QuejasSugerencias(Integer idQuejasSug) {
        this.idQuejasSug = idQuejasSug;
    }

    public Integer getIdQuejasSug() {
        return idQuejasSug;
    }

    public void setIdQuejasSug(Integer idQuejasSug) {
        this.idQuejasSug = idQuejasSug;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ClienteDocIdent getClienteDocIdent() {
        return clienteDocIdent;
    }

    public void setClienteDocIdent(ClienteDocIdent clienteDocIdent) {
        this.clienteDocIdent = clienteDocIdent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuejasSug != null ? idQuejasSug.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuejasSugerencias)) {
            return false;
        }
        QuejasSugerencias other = (QuejasSugerencias) object;
        if ((this.idQuejasSug == null && other.idQuejasSug != null) || (this.idQuejasSug != null && !this.idQuejasSug.equals(other.idQuejasSug))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.QuejasSugerencias[ idQuejasSug=" + idQuejasSug + " ]";
    }
    
}

