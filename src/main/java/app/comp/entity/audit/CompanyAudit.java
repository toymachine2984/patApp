package app.comp.entity.audit;


import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@Entity
@EntityListeners({AuditingEntityListener.class})
public class CompanyAudit  {

    public CompanyAudit() {
        super();
    }

    private DateTime dateTime;
    private String name;
    private String bin;
    private String adress;

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "CompanyAudit{" +
                "dateTime=" + dateTime +
                ", name='" + name + '\'' +
                ", bin='" + bin + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    //    @Column(name = "created_date", updatable = false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @CreatedDate
//    public DateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(DateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    @Column(name = "modified_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @LastModifiedDate
//    public DateTime getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(DateTime modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
//
//    @Column(name = "created_by")
//    @CreatedBy
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Column(name = "modified_by")
//    @LastModifiedBy
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//

}
