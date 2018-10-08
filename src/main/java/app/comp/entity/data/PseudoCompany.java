package app.comp.entity.data;

import javax.persistence.*;
import java.util.Date;

//@Entity
@Access(AccessType.PROPERTY)
@Table(name = "pseudo_company")
public class PseudoCompany {

    private long id;
    private String bin;
    private String rnn;
    private String name;
    private String taxpayerFio;
    private String headFio;
    private String headIin;
    private String headRnn;
    private String courtDecision;
    private Date criminalActivityDate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "bin")
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @Column(name = "rnn")
    public String getRnn() {
        return rnn;
    }

    public void setRnn(String rnn) {
        this.rnn = rnn;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "taxpayer_fio")
    public String getTaxpayerFio() {
        return taxpayerFio;
    }

    public void setTaxpayerFio(String taxpayerFio) {
        this.taxpayerFio = taxpayerFio;
    }

    @Column(name = "head_fio")
    public String getHeadFio() {
        return headFio;
    }

    public void setHeadFio(String headFio) {
        this.headFio = headFio;
    }

    @Column(name = "head_iin")
    public String getHeadIin() {
        return headIin;
    }

    public void setHeadIin(String headIin) {
        this.headIin = headIin;
    }

    @Column(name = "head_rnn")
    public String getHeadRnn() {
        return headRnn;
    }

    public void setHeadRnn(String headRnn) {
        this.headRnn = headRnn;
    }

    @Column(name = "court_decision")
    public String getCourtDecision() {
        return courtDecision;
    }

    public void setCourtDecision(String courtDecision) {
        this.courtDecision = courtDecision;
    }


    @Column(name = "criminal_activity_date")
    @Temporal(TemporalType.DATE)
    public Date getCriminalActivityDate() {
        return criminalActivityDate;
    }

    public void setCriminalActivityDate(Date criminalActivityDate) {
        this.criminalActivityDate = criminalActivityDate;
    }

}
