package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
@Scope("singleton")
public class AdService {
    @Value("${imageLocation}") private String imageLocation;
    private final Logger logger = LoggerFactory.getLogger(AdService.class);
    private static final String IMAGE = "image";


    /**
     * save image.
     * @param vin car's vin
     * @param photos photos to save
     * @return result
     */
    public boolean saveImages(String vin, List<MultipartFile> photos) {
        boolean result = false;
        try {
            if (photos.size() > 0) {
                String path = this.checkPaths(vin);
                for (MultipartFile file : photos) {
                    if (file.getContentType().contains(IMAGE)) {
                        String fileName = file.getOriginalFilename();
                        Files.write(Paths.get(path + File.separator + fileName), file.getBytes());
                    }
                }
                result = true;
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Load image names.
     * @param vin car's vin
     * @return list with image names
     */
    public List<String> loadImageNames(String vin) {
        List<String> images = new ArrayList<>();
        String path = imageLocation + File.separator + vin + File.separator;
        for (File file : new File(path).listFiles()) {
            images.add(file.toString().replace("\\", "/"));
        }
        return images;
    }

    /**
     * Check paths.
     * @param vin vin for folder
     * @return path
     * @throws IOException exception
     */
    private String checkPaths(String vin) throws IOException {
        Path temp = Paths.get(imageLocation + File.separator + vin);
        if (!Files.exists(temp)) {
            Files.createDirectory(temp);
        }
        return temp.toString();
    }
}
