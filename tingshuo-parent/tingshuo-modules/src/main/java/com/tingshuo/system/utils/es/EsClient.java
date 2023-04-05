package com.tingshuo.system.utils.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年04月05日 14:53
 **/
//@Component
public class EsClient {
    @Value("${elasticsearch.rest.hosts}")
    private String hosts;

    public RestHighLevelClient initSimpleClient(){
        HttpHost[] httpHosts=Arrays.stream(hosts.split(",")).map(
                host->{
                    String[] hostPars = host.split(":");
                    String hostName= hostPars[0];
                    int port = Integer.parseInt(hostPars[1]);
                    return new HttpHost(hostName,port,HttpHost.DEFAULT_SCHEME_NAME);
                }).filter(Objects::nonNull).toArray(HttpHost[]::new);
                return new RestHighLevelClient(RestClient.builder(httpHosts));
    }
}
