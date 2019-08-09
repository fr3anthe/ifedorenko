package ru.job4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.model.Constants;
import ru.job4j.model.dao.*;
import ru.job4j.model.entities.*;
import ru.job4j.service.AdService;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("ad")
public class AdController {
    private final DAdvertisement dAd;
    private final DBrand dBrand;
    private final DCarbody dCarbody;
    private final DEngine dEngine;
    private final DTransmission dTransmission;
    private final DCar dCar;
    private final AdService adService;
    private static final boolean STATUS = true;

    /**
     * Constructor
     * @param dAd DAdvertisement
     * @param dBrand DBrand
     * @param dCarbody DCarbody
     * @param dEngine DEngine
     * @param dTransmission DTransmission
     * @param dCar DCar
     * @param adService AdService
     */
    @Autowired
    public AdController(DAdvertisement dAd, DBrand dBrand, DCarbody dCarbody, DEngine dEngine, DTransmission dTransmission, DCar dCar, AdService adService) {
        this.dAd = dAd;
        this.dBrand = dBrand;
        this.dCarbody = dCarbody;
        this.dEngine = dEngine;
        this.dTransmission = dTransmission;
        this.dCar = dCar;
        this.adService = adService;
    }

    /**
     * Getting page listAd
     * @param model model
     * @return jsp
     */
    @GetMapping("listAd")
    public String showListAd(ModelMap model) {
        if (model.get("ads") == null) {
            model.addAttribute("ads", dAd.getAll());
        }
        return "listAd";
    }

    /**
     * Getting page createAd
     * @param model model
     * @return jsp
     */
    @GetMapping("createAd")
    public String showCreateAd(ModelMap model) {
        model.addAttribute("brands", dBrand.getAll());
        model.addAttribute("carbodies", dCarbody.getAll());
        model.addAttribute("engines", dEngine.getAll());
        model.addAttribute("transmissions", dTransmission.getAll());
        return "createAd";
    }

    /**
     * Getting page aboutAd
     * @param id ad's id
     * @param model model
     * @return jsp
     */
    @GetMapping("aboutAd")
    public String showAboutAd(@RequestParam("id") int id, ModelMap model) {
        Advertisement ad  = dAd.getById(id);
        if (ad.isImage()) {
            model.addAttribute("images", adService.loadImageNames(ad.getCar().getVin()));
        }
        model.addAttribute("ad", ad);
        return "aboutAd";
    }

    /**
     * Creating ad process.
     * @param ad ad
     * @param photos photos
     * @param model model
     * @param session session
     * @return result
     */
    @PostMapping(value = "createAd")
    public String createAd(@ModelAttribute Advertisement ad, @RequestAttribute List<MultipartFile> photos, ModelMap model, HttpSession session) {
        String result = "";
        String vin = ad.getCar().getVin();
        if (dCar.getByVin(vin).size() > 0) {
            model.addAttribute(Constants.ERROR, "the car is already on sale");
            result = "createAd";
        } else {
            dCar.add(ad.getCar());
            ad.setImage(adService.saveImages(vin, photos));
            ad.setDate(new Timestamp(System.currentTimeMillis()));
            ad.setUser(((User) session.getAttribute(Constants.USER)));
            ad.setStatus(STATUS);
            dAd.add(ad);
            result = "redirect:../ad/listAd.do";
        }
        return result;
    }

    /**
     * Change ad status.
     * @param id ad's id
     * @param status new status
     * @return jsp
     */
    @PostMapping(value = "changeStatus")
    public String changeStatusAd(@RequestParam("id") int id, @RequestParam("status") boolean status) {
        Advertisement advertisement = dAd.getById(id);
        advertisement.setStatus(status);
        dAd.update(advertisement);
        return "redirect:../ad/listAd.do";
    }
}



