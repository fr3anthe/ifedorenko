package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.dao.DAdvertisement;
import ru.job4j.model.entities.Advertisement;
import ru.job4j.model.entities.Filter;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Scope("singleton")
public class SupportService {
    private DAdvertisement dAd;
    private final Map<String, Function<String, List<Advertisement>>> map = new HashMap();
    private static final String PHOTO = "photo";
    private static final String DAY = "day";
    private static final String MODEL = "model";

    /**
     * Constructor.
     * @param dAd DAdvertisement
     */
    @Autowired
    public SupportService(DAdvertisement dAd) {
        this.dAd = dAd;
    }

    /**
     * init.
     */
    @PostConstruct
    private void init() {
        this.map.put(PHOTO, value -> dAd.getAllWithPhoto());
        this.map.put(DAY, value -> dAd.getByLastDay());
        this.map.put(MODEL, value -> dAd.getAllByModel(value));
    }

    /**
     * Apply filter.
     * @param filter filter
     * @return result by filter
     */
    public List<Advertisement> applyFilter(Filter filter) {
        return this.map.get(filter.getType()).apply(filter.getValue());
    }
}
