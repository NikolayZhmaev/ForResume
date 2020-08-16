package net.thumbtack.school.springRest.service;

import net.thumbtack.school.springRest.interfaces.DataStorage;
import org.springframework.stereotype.Service;

@Service
public class AudioRecordingStorage implements DataStorage {
    @Override
    public String save(String path) {
        return "Audio save";
    }
}
