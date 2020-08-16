package net.thumbtack.school.springRest.interfaces;

import net.thumbtack.school.springRest.dto.Recording;

import java.time.ZonedDateTime;


public interface PromotionService {

    void createCampaign(Recording recording, ZonedDateTime campaignCreateDate);
}
