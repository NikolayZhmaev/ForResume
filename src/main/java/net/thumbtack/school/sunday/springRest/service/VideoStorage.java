package net.thumbtack.school.springRest.service;

import net.thumbtack.school.springRest.interfaces.DataStorage;
import org.springframework.stereotype.Service;

//@Component
@Service
public class VideoStorage implements DataStorage {
    @Override
    public String save(String path) {
        return "Link video save";
    }
}
