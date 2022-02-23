package com.example.springdataaccess.service;

import java.util.List;
import java.util.Map;

public interface MusicService {

    Map<String, List<?>> fetchRandomMusicData(int amountEach);

}
