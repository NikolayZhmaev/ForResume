package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.interfaces.PublishingChannels;
import net.thumbtack.school.spring.dto.Recording;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service("YandexMusicChannel")
public class YandexMusicChannel implements PublishingChannels {

    public YandexMusicChannel() {
    }

    @Override
    public void publish(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("publication to YandexMusicChannel scheduled "+publishAvailableDate);
    }
}
