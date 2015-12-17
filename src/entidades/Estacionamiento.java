
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nishme
 */

public class Estacionamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idEstac;
    
    private Character estado;
    
    private String ubicacion;
    
    private List<ServicioEstac> servicioEstacList;
    
    private TipoVehiculo tipoVehiculo;

    public Estacionamiento() {
    }

    public Estacionamiento(Integer idEstac) {
        this.idEstac = idEstac;
    }

    public Integer getIdEstac() {
        return idEstac;
    }

    public void setIdEstac(Integer idEstac) {
        this.idEstac = idEstac;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ServicioEstac> getServicioEstacList() {
        return servicioEstacList;
    }

    public void setServicioEstacList(List<ServicioEstac> servicioEstacList) {
        this.servicioEstacList = servicioEstacList;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstac != null ? idEstac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacionamiento)) {
            return false;
        }
        Estacionamiento other = (Estacionamiento) object;
        if ((this.idEstac == null && other.idEstac != null) || (this.idEstac != null && !this.idEstac.equals(other.idEstac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estacionamiento[ idEstac=" + idEstac + " ]";
    }
    
}
