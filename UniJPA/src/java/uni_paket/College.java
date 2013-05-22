/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni_paket;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ftastemur
 */
@Entity
@Table(name = "COLLEGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "College.findAll", query = "SELECT c FROM College c"),
    @NamedQuery(name = "College.findByCollegeId", query = "SELECT c FROM College c WHERE c.collegeId = :collegeId"),
    @NamedQuery(name = "College.findByCname", query = "SELECT c FROM College c WHERE c.cname = :cname")})
public class College implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLLEGE_ID")
    private Integer collegeId;
    @Size(max = 30)
    @Column(name = "CNAME")
    private String cname;

    public College() {
    }

    public College(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collegeId != null ? collegeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof College)) {
            return false;
        }
        College other = (College) object;
        if ((this.collegeId == null && other.collegeId != null) || (this.collegeId != null && !this.collegeId.equals(other.collegeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uni_paket.College[ collegeId=" + collegeId + " ]";
    }
    
}
