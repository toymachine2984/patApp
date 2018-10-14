package app.comp.entity.data;


import app.comp.entity.system.Audit;
import app.comp.util.ViewMessage.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "company")
public class Company extends Audit implements Serializable {

    private long id;

    @JsonView(value = View.AJAXCompany.class)
    private String bin;

    @JsonView(value = {View.AJAXCompanyRu.class, View.AJAXCompanyEu.class})
    private String nameRu;

    @JsonView(value = View.AJAXCompanyKz.class)
    private String nameKz;

    @JsonView(value = View.AJAXCompanyAudit.class)
    private Date registrationDate;

    @JsonView(value = View.AJAXCompany.class)
    private String oked;

    @JsonView(value = {View.AJAXCompanyRu.class, View.AJAXCompanyEu.class})
    private String branchRu;

    @JsonView(value = View.AJAXCompanyKz.class)
    private String branchKz;

    @JsonView(value = View.AJAXCompany.class)
    private String krpName;

    @JsonView(value = {View.AJAXCompanyRu.class, View.AJAXCompanyEu.class})
    private String areaRu;

    @JsonView(value = View.AJAXCompanyKz.class)
    private String areaKz;

    @JsonView(value = View.AJAXCompany.class)
    private String address;

    @JsonView(value = View.AJAXCompany.class)
    private String kato;

    @JsonView(value = View.AJAXCompany.class)
    private String headFio;

    @JsonView(value = View.AJAXCompany.class)
    private String secondOked;

    @JsonView(value = View.AJAXCompany.class)
    private Region region;

    @JsonView(value = View.AJAXCompany.class)
    private Krp krp;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "bin", unique = true, nullable = false)
    @NotEmpty(message = "{validation.company.bin.NotEmpty.message}")
    @Size(min = 12, max = 12, message = "{validation.company.bin.Size.message}")
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @Column(name = "name_ru")
    @NotEmpty(message = "{validation.company.name.NotEmpty.message}")
    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "oked")
    public String getOked() {
        return oked;
    }

    public void setOked(String oked) {
        this.oked = oked;
    }

    @Column(name = "branch_ru")
    public String getBranch_ru() {
        return branchRu;
    }

    public void setBranch_ru(String branch_ru) {
        this.branchRu = branch_ru;
    }

    @Transient
    public String getKrpName() {
        return krpName;
    }

    public void setKrpName(String krpName) {
        this.krpName = krpName;
    }

    @Column(name = "area_ru")
    public String getArea_ru() {
        return areaRu;
    }

    public void setArea_ru(String area_ru) {
        this.areaRu = area_ru;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "kato")
    public String getKato() {
        return kato;
    }

    public void setKato(String kato) {
        this.kato = kato;
    }

    @Column(name = "head_fio")
    public String getHeadFio() {
        return headFio;
    }

    public void setHeadFio(String headFio) {
        this.headFio = headFio;
    }

    @Column(name = "second_oked")
    public String getSecondOked() {
        return secondOked;
    }

    public void setSecondOked(String secondOked) {
        this.secondOked = secondOked;
    }

    @JoinColumn(name = "region_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @JoinColumn(name = "krp_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Krp getKrp() {
        return krp;
    }

    public void setKrp(Krp krp) {
        this.krp = krp;
    }

    @Column(name = "name_kz")
    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    @Column(name = "branch_kz")
    public String getBranch_kz() {
        return branchKz;
    }

    public void setBranch_kz(String branch_kz) {
        this.branchKz = branch_kz;
    }

    @Column(name = "area_kz")
    public String getArea_kz() {
        return areaKz;
    }

    public void setArea_kz(String area_kz) {
        this.areaKz = area_kz;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", bin='" + bin + '\'' +
                ", nameRu='" + nameRu + '\'' +
                ", nameKz='" + nameKz + '\'' +
                ", registrationDate=" + registrationDate +
                ", oked='" + oked + '\'' +
                ", branchRu='" + branchRu + '\'' +
                ", branchKz='" + branchKz + '\'' +
                ", krp='" + krp + '\'' +
                ", krpName='" + krpName + '\'' +
                ", areaRu='" + areaRu + '\'' +
                ", areaKz='" + areaKz + '\'' +
                ", address='" + address + '\'' +
                ", kato='" + kato + '\'' +
                ", headFio='" + headFio + '\'' +
                ", secondOked='" + secondOked + '\'' +
                ", region=" + region +
                ", krp=" + krp +
                "}+\r\n";
    }
}
