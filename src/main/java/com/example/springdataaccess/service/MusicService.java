package com.example.springdataaccess.service;

import java.util.List;
import java.util.Map;

public interface MusicService {

    Map<String, List<?>> fetchMusicData(int amountEach);

}
