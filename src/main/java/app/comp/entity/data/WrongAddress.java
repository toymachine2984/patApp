package app.comp.entity.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Entity
@Access(AccessType.PROPERTY)
@Table(name = "wrong_address")
public class WrongAddress implements Serializable {

    private long id;
    private String bin;
    private String rnn;
    private String name;
    private String taxpayerFio;
    private String headFio;
    private String headIin;
    private String headRnn;
    private String inspectionNumber;
    private Date inspectionDate;


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

    @Column(name = "inspection_number")
    public String getInspectionNumber() {
        return inspectionNumber;
    }

    public void setInspectionNumber(String inspectionNumber) {
        this.inspectionNumber = inspectionNumber;
    }

    @Column(name = "inspection_date")
    @Temporal(TemporalType.DATE)
    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

}
