package com.tingshuo.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tingshuo.system.entity.es.HotelEntity;
import com.tingshuo.system.service.IEservice;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年04月05日 8:26
 **/
@Service
public class EserviceImpl implements IEservice {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public String getEsTest() throws Exception {
        IndicesClient indicesClient = restHighLevelClient.indices();
        try {
            // 创建get请求
            GetIndexRequest request = new GetIndexRequest("hotel");
            // 发送get请求
            GetIndexResponse response = indicesClient.get(request, RequestOptions.DEFAULT);
            // 获取表结构
            Map<String, MappingMetaData> mappings = response.getMappings();
            for (String key : mappings.keySet()) {
                System.out.println("key--" + mappings.get(key).getSourceAsMap());
            }
            // 创建获取请求对象
            GetRequest getRequest = new GetRequest("hotel", "001");
            GetResponse responses = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(responses.getSourceAsString());
            HotelEntity hotelEntity = new HotelEntity();
            hotelEntity.setKey("test");
            // 将对象转为json
            String data = JSON.toJSONString(hotelEntity);
            // 创建索引请求对象
            IndexRequest indexRequest = new IndexRequest("hotel").id(hotelEntity.getId() + "").source(data, XContentType.JSON);
            // 执行增加文档
            IndexResponse res = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("创建状态：{}" + res.status());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    @Override
    public List<HotelEntity> getHotelFRomTitle(String keyword) {
        SearchRequest searchRequest = new SearchRequest("hotel");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("title", keyword));
        searchRequest.source(searchSourceBuilder);
        List<HotelEntity> hotelEntities = new ArrayList<HotelEntity>();
        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            RestStatus status = searchResponse.status();
            if (status != RestStatus.OK) {
                return null;
            }
            SearchHits searchHits = searchResponse.getHits();
            System.out.println("========="+searchHits);

            //SearchHit[] hits = searchHits.getHits();
            for (SearchHit searchHit : searchHits) {
                System.out.println("searchHit="+searchHit);
                HotelEntity hotelEntity = new HotelEntity();

                //文档ID
                hotelEntity.setId(searchHit.getId());
                //索引名称
                hotelEntity.setIndex(searchHit.getIndex());
                //文档得分
                hotelEntity.setScore(searchHit.getScore());

                Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
                //设置标题
                hotelEntity.setTitle((String) sourceAsMap.get("title"));
                //设置城市
                hotelEntity.setCity((String) sourceAsMap.get("city"));
                //设置价格
                Double price = (Double)sourceAsMap.get("price");
                //hotelEntity.setPrice((String) sourceAsMap.get("price"));
                hotelEntities.add(hotelEntity);
            }
            return hotelEntities;
        } catch (Exception e) {

        }
        return hotelEntities;
    }

}
