package net.thumbtack.school.spring.interfaces;

import net.thumbtack.school.spring.dto.Recording;

import java.time.ZonedDateTime;

public interface PublishingChannels {
    void publish(Recording recording, ZonedDateTime publishAvailableDate);
}
