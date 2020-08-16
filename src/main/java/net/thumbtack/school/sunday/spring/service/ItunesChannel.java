package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.dto.Recording;
import net.thumbtack.school.spring.interfaces.PublishingChannels;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ItunesChannel implements PublishingChannels {
    @Override
    public void publish(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("publication to ItunesChannel scheduled " +publishAvailableDate);
    }
}
