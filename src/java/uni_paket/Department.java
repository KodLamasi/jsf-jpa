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
 * @author ftastemur
 */
@Entity
@Table(name = "Department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByBolumID", query = "SELECT d FROM Department d WHERE d.bolumID = :bolumID"),
    @NamedQuery(name = "Department.findByBolumAd", query = "SELECT d FROM Department d WHERE d.bolumAd = :bolumAd")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bolumID")
    private Integer bolumID;
    @Size(max = 20)
    @Column(name = "bolumAd")
    private String bolumAd;
    @OneToMany(mappedBy = "bolumID")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "fakulteID", referencedColumnName = "fakulteID")
    @ManyToOne
    private College fakulteID;

    public Department() {
    }

    public Department(Integer bolumID) {
        this.bolumID = bolumID;
    }

    public Integer getBolumID() {
        return bolumID;
    }

    public void setBolumID(Integer bolumID) {
        this.bolumID = bolumID;
    }

    public String getBolumAd() {
        return bolumAd;
    }

    public void setBolumAd(String bolumAd) {
        this.bolumAd = bolumAd;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public College getFakulteID() {
        return fakulteID;
    }

    public void setFakulteID(College fakulteID) {
        this.fakulteID = fakulteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bolumID != null ? bolumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.bolumID == null && other.bolumID != null) || (this.bolumID != null && !this.bolumID.equals(other.bolumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uni_paket.Department[ bolumID=" + bolumID + " ]";
    }
    
}
