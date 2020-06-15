/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package browserpass;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Anonymous
 */
@Entity
@Table(name = "records", catalog = "browserpasswords", schema = "")
@NamedQueries({
    @NamedQuery(name = "Records_1.findAll", query = "SELECT r FROM Records_1 r"),
    @NamedQuery(name = "Records_1.findByIdrecords", query = "SELECT r FROM Records_1 r WHERE r.idrecords = :idrecords"),
    @NamedQuery(name = "Records_1.findByBrowser", query = "SELECT r FROM Records_1 r WHERE r.browser = :browser"),
    @NamedQuery(name = "Records_1.findByUser", query = "SELECT r FROM Records_1 r WHERE r.user = :user"),
    @NamedQuery(name = "Records_1.findByPassword", query = "SELECT r FROM Records_1 r WHERE r.password = :password"),
    @NamedQuery(name = "Records_1.findByCreatedtime", query = "SELECT r FROM Records_1 r WHERE r.createdtime = :createdtime"),
    @NamedQuery(name = "Records_1.findByPcname", query = "SELECT r FROM Records_1 r WHERE r.pcname = :pcname"),
    @NamedQuery(name = "Records_1.findByIpaddress", query = "SELECT r FROM Records_1 r WHERE r.ipaddress = :ipaddress"),
    @NamedQuery(name = "Records_1.findByOtherinfo", query = "SELECT r FROM Records_1 r WHERE r.otherinfo = :otherinfo")})
public class Records_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecords")
    private Integer idrecords;
    @Basic(optional = false)
    @Column(name = "browser")
    private String browser;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "createdtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdtime;
    @Basic(optional = false)
    @Column(name = "pcname")
    private String pcname;
    @Basic(optional = false)
    @Column(name = "ipaddress")
    private String ipaddress;
    @Basic(optional = false)
    @Column(name = "otherinfo")
    private String otherinfo;

    public Records_1() {
    }

    public Records_1(Integer idrecords) {
        this.idrecords = idrecords;
    }

    public Records_1(Integer idrecords, String browser, Date createdtime, String pcname, String ipaddress, String otherinfo) {
        this.idrecords = idrecords;
        this.browser = browser;
        this.createdtime = createdtime;
        this.pcname = pcname;
        this.ipaddress = ipaddress;
        this.otherinfo = otherinfo;
    }

    public Integer getIdrecords() {
        return idrecords;
    }

    public void setIdrecords(Integer idrecords) {
        Integer oldIdrecords = this.idrecords;
        this.idrecords = idrecords;
        changeSupport.firePropertyChange("idrecords", oldIdrecords, idrecords);
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        String oldBrowser = this.browser;
        this.browser = browser;
        changeSupport.firePropertyChange("browser", oldBrowser, browser);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        String oldUser = this.user;
        this.user = user;
        changeSupport.firePropertyChange("user", oldUser, user);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        Date oldCreatedtime = this.createdtime;
        this.createdtime = createdtime;
        changeSupport.firePropertyChange("createdtime", oldCreatedtime, createdtime);
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        String oldPcname = this.pcname;
        this.pcname = pcname;
        changeSupport.firePropertyChange("pcname", oldPcname, pcname);
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        String oldIpaddress = this.ipaddress;
        this.ipaddress = ipaddress;
        changeSupport.firePropertyChange("ipaddress", oldIpaddress, ipaddress);
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        String oldOtherinfo = this.otherinfo;
        this.otherinfo = otherinfo;
        changeSupport.firePropertyChange("otherinfo", oldOtherinfo, otherinfo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecords != null ? idrecords.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Records_1)) {
            return false;
        }
        Records_1 other = (Records_1) object;
        if ((this.idrecords == null && other.idrecords != null) || (this.idrecords != null && !this.idrecords.equals(other.idrecords))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "browserpass.Records_1[ idrecords=" + idrecords + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
