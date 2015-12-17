
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nishme
 */

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer idCliente;
   
    private String nombres;
   
    private String apellidos;
   
    private String tipoPersona;
        
    private Boolean estando;
   
    private List<ClienteDocIdent> clienteDocIdentList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<ClienteDocIdent> getClienteDocIdentList() {
        return clienteDocIdentList;
    }

    public void setClienteDocIdentList(List<ClienteDocIdent> clienteDocIdentList) {
        this.clienteDocIdentList = clienteDocIdentList;
    }

    public Boolean getEstando() {
        return estando;
    }

    public void setEstando(Boolean estando) {
        this.estando = estando;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
