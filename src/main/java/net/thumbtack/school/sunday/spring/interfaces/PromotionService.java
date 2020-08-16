package net.thumbtack.school.spring.interfaces;

import net.thumbtack.school.spring.dto.Recording;

import java.time.ZonedDateTime;


public interface PromotionService {

    void createCampaign(Recording recording, ZonedDateTime campaignCreateDate);
}
