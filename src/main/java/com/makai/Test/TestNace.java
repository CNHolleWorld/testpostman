package com.makai.Test;

import com.sun.scenario.Settings;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

/* * *
 *  @Name: TestNace
 *  @User: 马凯
 *  @Date: 2019/10/10
 *  @Remark:
 * * */
public class TestNace {

    @Test
    public void testESAddIndex(){
        //创建客户端类
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
          RestClient.builder(
                  new HttpHost("192.168.87.136","9200"."http")
          )
        );


        // 2.获得索引请求
        IndexRequest request = new IndexRequest(
                "book2", // 索引名 - 数据库名
                "novel", // 类型名 - 表名
                "1");    // 主键     - 可以不设置,自动生成
        // 3.1  准备插入的文档 - 数据 - 这里使用json - 有三种方式
        String json = "{\"title\":\"<红楼梦>\",\"content\":\"看不懂的人情关系\"}";
        // 3.2 插入数据
        request.source(json, XContentType.JSON);

        // 4发送请求
        IndexResponse response = client.index(request);
        System.out.println(response);

        // 5.判断是否插入成功
        if (response.getResult() == DocWriteResponse.Result.CREATED) {
            System.out.println("插入成功");
        }
        // 6.关闭客户端
        client.close();
    }



}
