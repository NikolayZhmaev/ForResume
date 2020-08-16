package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.dto.Recording;
import net.thumbtack.school.spring.interfaces.PromotionService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PromotionServiceImpl implements PromotionService {

    public void createCampaign(Recording recording, ZonedDateTime campaignCreateDate){
        System.out.println("createCampaign starting " + campaignCreateDate);
    }
}
