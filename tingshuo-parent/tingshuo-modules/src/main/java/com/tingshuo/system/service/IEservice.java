package com.tingshuo.system.service;

import com.tingshuo.system.entity.es.HotelEntity;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年04月05日 8:26
 **/
public interface IEservice {
    String getEsTest() throws Exception;

    List<HotelEntity> getHotelFRomTitle(String keyword);
}
