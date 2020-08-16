package net.thumbtack.school.springRest;


import net.thumbtack.school.springRest.interfaces.PublishingChannels;
import net.thumbtack.school.springRest.service.ItunesChannel;
import net.thumbtack.school.springRest.service.YandexMusicChannel;
import net.thumbtack.school.springRest.service.YoutubeMusicChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean("sendYandexMusic")
    public PublishingChannels sendYandexMusic() {
        return new YandexMusicChannel();
    }

    @Bean("sendYoutubeMusicAndVideo")
    public PublishingChannels sendYoutubeMusicAndVideo() {
        return new YoutubeMusicChannel();
    }

    @Bean("sendItunesMusic")
    public PublishingChannels sendItunesMusic() {
        return new ItunesChannel();
    }


}
