package app.comp.util.ViewMessage;

import app.comp.entity.ICompany;
import app.comp.entity.data.Krp;
import app.comp.entity.data.Region;

import java.util.Date;

public class View {


    public interface AJAXCompany extends ICompany {
        String getBin();

        String getOked();

        String getAddress();

        String getKato();

        String getHeadFio();

        String getSecondOked();

        Region getRegion();

        Krp getKrp();
    }


    public interface AJAXCompanyRu extends AJAXCompany {
        String getNameRu();

//        String getBranch_ru();
//
//        String getArea_ru();
    }


    public interface AJAXCompanyKz extends AJAXCompany {
        String getNameKz();

        String getBranch_kz();

        String getArea_kz();
    }


    public interface AJAXCompanyEu extends AJAXCompany {
        String getNameRu();

        String getBranch_ru();

        String getArea_ru();
    }

    public interface AJAXCompanyAudit extends AJAXCompany {
        Date getRegistrationDate();
    }


}
