package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.interfaces.DataStorage;
import org.springframework.stereotype.Service;

//@Component
@Service
public class VideoStorage implements DataStorage {
    @Override
    public String save(String path) {
        return "Link video save";
    }
}
