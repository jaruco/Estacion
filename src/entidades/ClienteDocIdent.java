
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nishme
 */

public class ClienteDocIdent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idClienteDocIdent;
    
    private String numero;
    
    private List<Servicio> servicioList;
    
    private TipoDocumento tipoDocumento;
    
    private Cliente cliente;
    
    private Boolean estado;
    
    private List<QuejasSugerencias> quejasSugerenciasList;

    public ClienteDocIdent() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ClienteDocIdent(Integer idClienteDocIdent) {
        this.idClienteDocIdent = idClienteDocIdent;
    }

    public Integer getIdClienteDocIdent() {
        return idClienteDocIdent;
    }

    public void setIdClienteDocIdent(Integer idClienteDocIdent) {
        this.idClienteDocIdent = idClienteDocIdent;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<QuejasSugerencias> getQuejasSugerenciasList() {
        return quejasSugerenciasList;
    }

    public void setQuejasSugerenciasList(List<QuejasSugerencias> quejasSugerenciasList) {
        this.quejasSugerenciasList = quejasSugerenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteDocIdent != null ? idClienteDocIdent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteDocIdent)) {
            return false;
        }
        ClienteDocIdent other = (ClienteDocIdent) object;
        if ((this.idClienteDocIdent == null && other.idClienteDocIdent != null) || (this.idClienteDocIdent != null && !this.idClienteDocIdent.equals(other.idClienteDocIdent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ClienteDocIdent[ idClienteDocIdent=" + idClienteDocIdent + " ]";
    }
    
}
