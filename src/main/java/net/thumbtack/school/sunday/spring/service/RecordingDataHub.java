package net.thumbtack.school.spring.service;


import net.thumbtack.school.spring.interfaces.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordingDataHub {

    @Autowired
    private DataStorage audioRecordingStorage;
    @Autowired
    private DataStorage videoStorage;
}
