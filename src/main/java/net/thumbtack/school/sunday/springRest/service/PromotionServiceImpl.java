package net.thumbtack.school.springRest.service;

import net.thumbtack.school.springRest.dto.Recording;
import net.thumbtack.school.springRest.interfaces.PromotionService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PromotionServiceImpl implements PromotionService {

    public void createCampaign(Recording recording, ZonedDateTime campaignCreateDate){
        System.out.println("createCampaign starting " + campaignCreateDate);
    }
}
