/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_paket;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ftastemur
 */
@Entity
@Table(name = "Student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByOgrenciID", query = "SELECT s FROM Student s WHERE s.ogrenciID = :ogrenciID"),
    @NamedQuery(name = "Student.findByAd", query = "SELECT s FROM Student s WHERE s.ad = :ad"),
    @NamedQuery(name = "Student.findBySoyad", query = "SELECT s FROM Student s WHERE s.soyad = :soyad")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ogrenciID")
    private Integer ogrenciID;
    @Size(max = 20)
    @Column(name = "ad")
    private String ad;
    @Size(max = 20)
    @Column(name = "soyad")
    private String soyad;
    @JoinColumn(name = "bolumID", referencedColumnName = "bolumID")
    @ManyToOne
    private Department bolumID;

    public Student() {
    }

    public Student(Integer ogrenciID) {
        this.ogrenciID = ogrenciID;
    }

    public Integer getOgrenciID() {
        return ogrenciID;
    }

    public void setOgrenciID(Integer ogrenciID) {
        this.ogrenciID = ogrenciID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Department getBolumID() {
        return bolumID;
    }

    public void setBolumID(Department bolumID) {
        this.bolumID = bolumID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ogrenciID != null ? ogrenciID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.ogrenciID == null && other.ogrenciID != null) || (this.ogrenciID != null && !this.ogrenciID.equals(other.ogrenciID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uni_paket.Student[ ogrenciID=" + ogrenciID + " ]";
    }
    
}
