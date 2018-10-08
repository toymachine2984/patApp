package app.comp.entity.data;

import javax.persistence.*;

//@Entity
@Access(AccessType.PROPERTY)
@Table(name = "tax_areas")
public class TaxAreas {

    private long id;
    private String region;
    private String revenueAgencyName;
    private String ogd;
    private String rnn;
    private String taxpayerFioKz;
    private String taxpayerFioRu;
    private String nameKz;
    private String nameRu;
    private String headFioKz;
    private String headFioRu;
    private String taxDebtAmount;
    private String economicType;
    private double mainDebt;
    private double penalties;
    private double fine;
    private double sum;
    private String bin;
    private String headBin;
    private String headRnn;
    private long companyTypeId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "revenue_agency_name")
    public String getRevenueAgencyName() {
        return revenueAgencyName;
    }

    public void setRevenueAgencyName(String revenueAgencyName) {
        this.revenueAgencyName = revenueAgencyName;
    }

    @Column(name = "ogd")
    public String getOgd() {
        return ogd;
    }

    public void setOgd(String ogd) {
        this.ogd = ogd;
    }

    @Column(name = "rnn")
    public String getRnn() {
        return rnn;
    }

    public void setRnn(String rnn) {
        this.rnn = rnn;
    }

    @Column(name = "taxpayer_fio_kz")
    public String getTaxpayerFioKz() {
        return taxpayerFioKz;
    }

    public void setTaxpayerFioKz(String taxpayerFioKz) {
        this.taxpayerFioKz = taxpayerFioKz;
    }

    @Column(name = "taxpayer_fio_ru")
    public String getTaxpayerFioRu() {
        return taxpayerFioRu;
    }

    public void setTaxpayerFioRu(String taxpayerFioRu) {
        this.taxpayerFioRu = taxpayerFioRu;
    }

    @Column(name = "name_kz")
    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    @Column(name = "name_ru")
    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @Column(name = "head_fio_kz")
    public String getHeadFioKz() {
        return headFioKz;
    }

    public void setHeadFioKz(String headFioKz) {
        this.headFioKz = headFioKz;
    }

    @Column(name = "head_fio_ru")
    public String getHeadFioRu() {
        return headFioRu;
    }

    public void setHeadFioRu(String headFioRu) {
        this.headFioRu = headFioRu;
    }

    @Column(name = "tax_debt_amount")
    public String getTaxDebtAmount() {
        return taxDebtAmount;
    }

    public void setTaxDebtAmount(String taxDebtAmount) {
        this.taxDebtAmount = taxDebtAmount;
    }

    @Column(name = "economic_type")
    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }

    @Column(name = "main_debt")
    public double getMainDebt() {
        return mainDebt;
    }

    public void setMainDebt(double mainDebt) {
        this.mainDebt = mainDebt;
    }

    @Column(name = "penalties")
    public double getPenalties() {
        return penalties;
    }

    public void setPenalties(double penalties) {
        this.penalties = penalties;
    }

    @Column(name = "fine")
    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Column(name = "bin")
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @Transient
    public long getCompanyTypeId() {
        return companyTypeId;
    }

    @Column(name = "head_bin")
    public String getHeadBin() {
        return headBin;
    }

    public void setHeadBin(String headBin) {
        this.headBin = headBin;
    }

    @Column(name = "head_rnn")
    public String getHeadRnn() {
        return headRnn;
    }

    public void setHeadRnn(String headRnn) {
        this.headRnn = headRnn;
    }

    public void setCompanyTypeId(long companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "TaxAreas{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", revenueAgencyName='" + revenueAgencyName + '\'' +
                ", ogd='" + ogd + '\'' +
                ", rnn='" + rnn + '\'' +
                ", taxpayerFioKz='" + taxpayerFioKz + '\'' +
                ", taxpayerFioRu='" + taxpayerFioRu + '\'' +
                ", nameKz='" + nameKz + '\'' +
                ", nameRu='" + nameRu + '\'' +
                ", headFioKz='" + headFioKz + '\'' +
                ", headFioRu='" + headFioRu + '\'' +
                ", taxDebtAmount='" + taxDebtAmount + '\'' +
                ", economicType='" + economicType + '\'' +
                ", mainDebt='" + mainDebt + '\'' +
                ", penalties='" + penalties + '\'' +
                ", fine='" + fine + '\'' +
                ", bin='" + bin + '\'' +
                ", headBin='" + headBin + '\'' +
                ", headRnn='" + headRnn + '\'' +
                ", sum='" + sum + '\'' +
                ", companyTypeId=" + companyTypeId +
                "} \r\n";
    }
}
