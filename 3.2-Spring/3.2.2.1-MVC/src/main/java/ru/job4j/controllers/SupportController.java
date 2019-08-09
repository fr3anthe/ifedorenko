package ru.job4j.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.job4j.model.entities.Filter;
import ru.job4j.service.SupportService;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Controller
@RequestMapping("support")
public class SupportController {
    private final Logger logger = LoggerFactory.getLogger(SupportController.class);
    private final SupportService ss;

    /**
     * Constructor.
     * @param ss SupportService
     */
    @Autowired
    public SupportController(SupportService ss) {
        this.ss = ss;
    }

    /**
     * load image for ad
     * @param path path to photo storage
     * @param response responce
     */
    @GetMapping("image")
    public void loadImage(@RequestParam("path") String path, HttpServletResponse response) {
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(new File(path)));
            ImageIO.write(image, "jpeg", response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Filter.
     * @param filter filter
     * @param redirectAttrs redirectAttrs
     * @return redirect with result to listAd page
     */
    @GetMapping("filter")
    public String applyFlter(@ModelAttribute Filter filter, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("ads", ss.applyFilter(filter));
        return "redirect:../ad/listAd.do";
    }
}
