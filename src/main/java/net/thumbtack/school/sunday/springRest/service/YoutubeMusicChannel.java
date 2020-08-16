package net.thumbtack.school.springRest.service;

import net.thumbtack.school.springRest.dto.Recording;
import net.thumbtack.school.springRest.interfaces.PublishingChannels;
import net.thumbtack.school.springRest.interfaces.RemovalChannels;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class YoutubeMusicChannel implements PublishingChannels, RemovalChannels {

    @Override
    public void publish(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("publication to YoutubeMusicChannel scheduled "+publishAvailableDate);
    }

    @Override
    public void removal(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("publication removal from YoutubeMusicChannel scheduled "+publishAvailableDate);
    }
}
