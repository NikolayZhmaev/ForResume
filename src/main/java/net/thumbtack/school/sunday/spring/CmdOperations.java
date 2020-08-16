package net.thumbtack.school.spring;


import com.google.gson.Gson;
import net.thumbtack.school.spring.dto.Recording;
import net.thumbtack.school.spring.interfaces.PromotionService;
import net.thumbtack.school.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class CmdOperations implements CommandLineRunner {

    private final AudioRecordingStorage audioRecordingStorage;
    private final VideoStorage videoStorage;
    private final YandexMusicChannel yandexMusicChannel;
    private final YoutubeMusicChannel youtubeMusicChannel;
    private final ItunesChannel itunesChannel;
    private final PromotionService promotionService;

    @Autowired
    public CmdOperations(AudioRecordingStorage audioRecordingStorage, VideoStorage videoStorage, YandexMusicChannel yandexMusicChannel, YoutubeMusicChannel youtubeMusicChannel, ItunesChannel itunesChannel, PromotionService promotionService) {
        this.audioRecordingStorage = audioRecordingStorage;
        this.videoStorage = videoStorage;
        this.yandexMusicChannel = yandexMusicChannel;
        this.youtubeMusicChannel = youtubeMusicChannel;
        this.itunesChannel = itunesChannel;
        this.promotionService = promotionService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("It's work");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        ZoneId zone = ZoneId.of("Asia/Omsk");
        ZonedDateTime zoned = ZonedDateTime.of(date, time, zone);

        Recording recording = new Recording();
        System.out.println(recording.toString());
        Gson gson = new Gson();
        gson.toJson(recording);
        System.out.println(gson);
        save(recording);

        saveAndPublishAndPromoutionAudio(new Recording(), zoned);
        saveAndPublishAndPromoutionVideo(new Recording(), zoned);
    }

    public void saveAndPublishAndPromoutionAudio(Recording recording, ZonedDateTime zonedDateTime) {
        publishAudio(recording, zonedDateTime.plusWeeks(1));
        promotionService.createCampaign(recording, zonedDateTime);
    }

    public void saveAndPublishAndPromoutionVideo(Recording recording, ZonedDateTime zonedDateTime) {
        publishVideo(recording, zonedDateTime.plusWeeks(2));
        promotionService.createCampaign(recording, zonedDateTime);
    }

    public void publishAudio(Recording recording, ZonedDateTime zonedDateTime) {
        yandexMusicChannel.publish(recording, zonedDateTime);
        youtubeMusicChannel.publish(recording, zonedDateTime);
        itunesChannel.publish(recording, zonedDateTime);
    }

    public void publishVideo(Recording recording, ZonedDateTime zonedDateTime) {
        youtubeMusicChannel.publish(recording, zonedDateTime);
    }

    public void save(Recording recording) {
        audioRecordingStorage.save(recording.toString());
        if (recording.getLinkToVideoFile() != null) {
            videoStorage.save(recording.toString());
        }
    }
}
