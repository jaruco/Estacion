
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nishme
 */

public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idDoc;
    
    private String descripcion;
    
    private String abreviatura;
   
    private List<ClienteDocIdent> clienteDocIdentList;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public List<ClienteDocIdent> getClienteDocIdentList() {
        return clienteDocIdentList;
    }

    public void setClienteDocIdentList(List<ClienteDocIdent> clienteDocIdentList) {
        this.clienteDocIdentList = clienteDocIdentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoDocumento[ idDoc=" + idDoc + " ]";
    }
    
}
