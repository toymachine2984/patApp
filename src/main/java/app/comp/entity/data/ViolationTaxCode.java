package app.comp.entity.data;

import javax.persistence.*;
import java.util.Date;

//@Entity
@Access(AccessType.PROPERTY)
@Table(name = "violation_tax_code")
public class ViolationTaxCode {

  private long id;
  private String bin;
  private String rnn;
  private String name;
  private String headFio;
  private String headIin;
  private String headRnn;
  private String orderNumber;
  private Date orderDate;
  private String violationNature;

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

  @Column(name = "order_number")
  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @Column(name = "order_date")
  @Temporal(TemporalType.DATE)
  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  @Column(name = "violation_nature")
  public String getViolationNature() {
    return violationNature;
  }

  public void setViolationNature(String violationNature) {
    this.violationNature = violationNature;
  }

    @Override
    public String toString() {
        return "ViolationTaxCode{" +
                "id=" + id +
                ", bin='" + bin + '\'' +
                ", rnn='" + rnn + '\'' +
                ", name='" + name + '\'' +
                ", headFio='" + headFio + '\'' +
                ", headIin='" + headIin + '\'' +
                ", headRnn='" + headRnn + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", violationNature='" + violationNature + '\'' +
                "}\r\n";
    }
}
