package net.thumbtack.school.springRest.endpoint;


import net.thumbtack.school.springRest.interfaces.PromotionService;
import net.thumbtack.school.springRest.service.*;
import net.thumbtack.school.springRest.dto.Recording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/promotionService")
public class PromotionServiceEndPoint {

    private final AudioRecordingStorage audioRecordingStorage;
    private final VideoStorage videoStorage;
    private final YandexMusicChannel yandexMusicChannel;
    private final YoutubeMusicChannel youtubeMusicChannel;
    private final ItunesChannel itunesChannel;
    private final PromotionService promotionService;

    @Autowired
    public PromotionServiceEndPoint(AudioRecordingStorage audioRecordingStorage, VideoStorage videoStorage, YandexMusicChannel yandexMusicChannel, YoutubeMusicChannel youtubeMusicChannel, ItunesChannel itunesChannel, PromotionService promotionService) {
        this.audioRecordingStorage = audioRecordingStorage;
        this.videoStorage = videoStorage;
        this.yandexMusicChannel = yandexMusicChannel;
        this.youtubeMusicChannel = youtubeMusicChannel;
        this.itunesChannel = itunesChannel;
        this.promotionService = promotionService;
    }

    @PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> saveRecording(@RequestBody Recording recording) {
        return save(recording);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void publishAudio(Recording recording, ZonedDateTime zonedDateTime) {
        yandexMusicChannel.publish(recording, zonedDateTime);
        youtubeMusicChannel.publish(recording, zonedDateTime);
        itunesChannel.publish(recording, zonedDateTime);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void publishVideo(Recording recording, ZonedDateTime zonedDateTime) {
        youtubeMusicChannel.publish(recording, zonedDateTime);
    }

    @DeleteMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public void removalAudio (Recording recording, ZonedDateTime zonedDateTime){
        yandexMusicChannel.removal(recording, zonedDateTime);
        youtubeMusicChannel.removal(recording, zonedDateTime);
        itunesChannel.removal(recording, zonedDateTime);
    }

    @DeleteMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public void removalVideo (Recording recording, ZonedDateTime zonedDateTime){
        youtubeMusicChannel.removal(recording, zonedDateTime);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveAndPublishAndPromoutionAudio(Recording recording, ZonedDateTime zonedDateTime) {
        publishAudio(recording, zonedDateTime.plusWeeks(1));
        promotionService.createCampaign(recording, zonedDateTime);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveAndPublishAndPromoutionVideo(Recording recording, ZonedDateTime zonedDateTime) {
        publishVideo(recording, zonedDateTime.plusWeeks(2));
        promotionService.createCampaign(recording, zonedDateTime);
    }







    public List<String> save(Recording recording) {
        List<String> links = new ArrayList<>();
        links.add(audioRecordingStorage.save(recording.toString()));
        if (recording.getLinkToVideoFile() != null) {
            links.add(videoStorage.save(recording.toString()));
        }
        return links;
    }

}
