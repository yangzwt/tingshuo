package com.tingshuo.system.es.controller;

import com.tingshuo.system.entity.es.HotelEntity;
import com.tingshuo.system.service.IEservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年04月05日 8:34
 **/
@RestController
public class EsController {
    @Autowired
    private IEservice iEservice;
    @RequestMapping(value = "/getEsTest")
    public void getEsTest(){
        try {
            iEservice.getEsTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/getRec")
    public List<HotelEntity>  getRec(){
        List<HotelEntity> list = iEservice.getHotelFRomTitle("酒吧");
        if (list!=null && list.size()>0){
            return list;
        }
        return new ArrayList<HotelEntity>();
    }

    @RequestMapping(value = "/getRec1")
    public String getRec1(){

        return "no data";
    }
}
