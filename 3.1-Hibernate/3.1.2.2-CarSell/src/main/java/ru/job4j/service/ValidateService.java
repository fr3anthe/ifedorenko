package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.dao.DAdvertisement;
import ru.job4j.model.dao.DCar;
import ru.job4j.model.dao.DUser;
import ru.job4j.model.entities.User;

/**
 * class ValidateService
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
public class ValidateService {
    private static final ValidateService INSTANCE = new ValidateService();
    private DAdvertisement dad;
    private DCar dc;
    private DUser du;

    /**
     * Private Constructor
     */
    private ValidateService() {
        dad = DAdvertisement.getInstance();
        dc = DCar.getInstance();
        du = DUser.getInstance();
    }

    /**
     * Check users exist.
     * @param login login for check
     * @return result
     */
    public boolean isUserExist(String login) {
        boolean result = false;
        if (du.getByLogin(login).size() > 0) {
            result = true;
        }
        return result;
    }

    /**
     * User autorization.
     * @param login login
     * @param password password
     * @return result -1 if false, or id if success
     */
    public int isUserCredential(String login, String password) {
        int result = -1;
        for (User user : du.getAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getId();
                break;
            }
        }
        return result;
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

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }

}
