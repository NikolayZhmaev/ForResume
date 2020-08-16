package net.thumbtack.school.springRest.interfaces;

import net.thumbtack.school.springRest.dto.Recording;

import java.time.ZonedDateTime;

public interface PublishingChannels {
    void publish(Recording recording, ZonedDateTime publishAvailableDate);
}
