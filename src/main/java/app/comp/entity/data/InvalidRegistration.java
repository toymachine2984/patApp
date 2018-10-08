package app.comp.entity.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


//@Entity
@Access(AccessType.PROPERTY)
@Table(name = "invalid_registration")
public class InvalidRegistration implements Serializable {

    private long id;
    private String bin;
    private String rnn;
    private String name;
    private String taxpayerFio;
    private String headFio;
    private String headIin;
    private String headRnn;
    private String decisionNumber;
    private Date decisionDate;


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

    @Column(name = "decision_number")
    public String getDecisionNumber() {
        return decisionNumber;
    }

    public void setDecisionNumber(String decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    @Column(name = "decision_date")
    @Temporal(TemporalType.DATE)
    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

}
