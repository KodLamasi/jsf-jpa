/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_paket;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author ftastemur
 */
@Entity
@Table(name = "College")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "College.findAll", query = "SELECT c FROM College c"),
    @NamedQuery(name = "College.findByFakulteID", query = "SELECT c FROM College c WHERE c.fakulteID = :fakulteID"),
    @NamedQuery(name = "College.findByFakulteAd", query = "SELECT c FROM College c WHERE c.fakulteAd = :fakulteAd")})
public class College implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fakulteID")
    private Integer fakulteID;
    @Size(max = 20)
    @Column(name = "fakulteAd")
    private String fakulteAd;
    @OneToMany(mappedBy = "fakulteID")
    private Collection<Department> departmentCollection;

    public College() {
    }

    public College(Integer fakulteID) {
        this.fakulteID = fakulteID;
    }

    public Integer getFakulteID() {
        return fakulteID;
    }

    public void setFakulteID(Integer fakulteID) {
        this.fakulteID = fakulteID;
    }

    public String getFakulteAd() {
        return fakulteAd;
    }

    public void setFakulteAd(String fakulteAd) {
        this.fakulteAd = fakulteAd;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakulteID != null ? fakulteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof College)) {
            return false;
        }
        College other = (College) object;
        if ((this.fakulteID == null && other.fakulteID != null) || (this.fakulteID != null && !this.fakulteID.equals(other.fakulteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uni_paket.College[ fakulteID=" + fakulteID + " ]";
    }
    
}
