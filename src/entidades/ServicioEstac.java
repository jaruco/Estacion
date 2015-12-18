package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Nishme
 */
public class ServicioEstac implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idServEstac;

    private Date horaIni;

    private Date horaFin;

    private Date fechaIni;

    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private BigDecimal total;

    private Servicio servicio;

    private Estacionamiento estacionamiento;

    private Double tarifaTipoVehiculo;

    public ServicioEstac() {
    }

    public ServicioEstac(Integer idServEstac) {
        this.idServEstac = idServEstac;
    }

    public Integer getIdServEstac() {
        return idServEstac;
    }

    public void setIdServEstac(Integer idServEstac) {
        this.idServEstac = idServEstac;
    }

    public Date getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Date horaIni) {
        this.horaIni = horaIni;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public Double getTarifaTipoVehiculo() {
        return tarifaTipoVehiculo;
    }

    public void setTarifaTipoVehiculo(Double tarifaTipoVehiculo) {
        this.tarifaTipoVehiculo = tarifaTipoVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServEstac != null ? idServEstac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioEstac)) {
            return false;
        }
        ServicioEstac other = (ServicioEstac) object;
        if ((this.idServEstac == null && other.idServEstac != null) || (this.idServEstac != null && !this.idServEstac.equals(other.idServEstac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ServicioEstac[ idServEstac=" + idServEstac + " ]";
    }

}
