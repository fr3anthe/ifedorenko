package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.dao.DAO;
import ru.job4j.model.dao.DAdvertisement;
import ru.job4j.model.dao.DCar;
import ru.job4j.model.dao.DUser;
import ru.job4j.model.entities.User;

/**
 * class ValidateService.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Component
@Scope("singleton")
public class ValidateService {
   private DAdvertisement dad;
   private DCar dc;
   private DUser du;

    /**
     * Constructor.
     * @param dad dAdvertisement
     * @param dc dCar
     * @param du dUser
     */
    @Autowired
    public ValidateService(DAdvertisement dad, DCar dc, DUser du) {
       this.dad = dad;
       this.dc = dc;
       this.du = du;
    }


    /**
     * Check vin exist.
     * @param vin vin for check
     * @return result
     */
    public boolean isVinExist(String vin) {
        boolean result = false;
        if (dc.getByVin(vin).size() > 0) {
            result = true;
        }
        return result;
    }
}
