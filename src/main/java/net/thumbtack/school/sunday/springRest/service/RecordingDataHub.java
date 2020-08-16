package net.thumbtack.school.springRest.service;


import net.thumbtack.school.springRest.interfaces.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordingDataHub {

    @Autowired
    private DataStorage audioRecordingStorage;
    @Autowired
    private DataStorage videoStorage;
}
