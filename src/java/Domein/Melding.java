/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tim
 */
@Entity
@Table(name = "melding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Melding.findAll", query = "SELECT m FROM Melding m"),
    @NamedQuery(name = "Melding.findById", query = "SELECT m FROM Melding m WHERE m.id = :id"),
    @NamedQuery(name = "Melding.findByType", query = "SELECT m FROM Melding m WHERE m.type = :type"),
    @NamedQuery(name = "Melding.findByBeschrijving", query = "SELECT m FROM Melding m WHERE m.beschrijving = :beschrijving"),
    @NamedQuery(name = "Melding.findByLattitude", query = "SELECT m FROM Melding m WHERE m.lattitude = :lattitude"),
    @NamedQuery(name = "Melding.findByLongitude", query = "SELECT m FROM Melding m WHERE m.longitude = :longitude")})
public class Melding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Beschrijving")
    private String beschrijving;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lattitude")
    private Double lattitude;
    @Column(name = "longitude")
    private Double longitude;
    @JoinColumn(name = "auteur", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User auteur;
    

    public Melding() {
    }

    public Melding(Integer id) {
        this.id = id;
    }

    public Melding(Integer id, String type, String beschrijving) {
        this.id = id;
        this.type = type;
        this.beschrijving = beschrijving;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Melding)) {
            return false;
        }
        Melding other = (Melding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domein.Melding[ id=" + id + " ]";
    }
    
}
