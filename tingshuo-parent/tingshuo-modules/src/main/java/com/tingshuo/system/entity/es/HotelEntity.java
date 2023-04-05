package com.tingshuo.system.entity.es;



/**
 * 类文件描述:
 * 酒店es实体映射
 * @author yangz
 * @version 1.0.0
 * @date 2023年04月03日 20:37
 **/
//@Document(indexName="hotel")
public class HotelEntity {
    /**
     *  对应文档的id
     */
    private String id;
    /**
     * 对应文档的索引名称
     */
    private String index;
    /**
     * 对应文档的得分
     */
    private Float score;

    private String title;
    private String city;
    private String price;
    private String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
