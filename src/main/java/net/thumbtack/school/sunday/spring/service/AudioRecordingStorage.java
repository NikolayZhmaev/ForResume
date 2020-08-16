package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.interfaces.DataStorage;
import org.springframework.stereotype.Service;

@Service
public class AudioRecordingStorage implements DataStorage {
    @Override
    public String save(String path) {
        return "Audio save";
    }
}
