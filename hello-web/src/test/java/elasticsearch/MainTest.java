package elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zdk.hello.service.user.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b>类 名 称</b> :  MainTest<br/>
 * <b>类 描 述</b> :  测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/1/22 11:33<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/1/22 11:33<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MainTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {
        try (RestHighLevelClient client =
                     new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")))) {

            search(client);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void searchIndex(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest("shopping");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        request.source(searchSourceBuilder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(search, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue));
    }
    
    
    public static void search(RestHighLevelClient client) throws IOException {
        SearchRequest request = new SearchRequest("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "user03"));
        //boolQueryBuilder.must(QueryBuilders.matchQuery("id", "03"));
        
        searchSourceBuilder.query(boolQueryBuilder);
        SearchRequest source = request.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(source, RequestOptions.DEFAULT);
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsString());
        }
    }
    
    public static void createIndex(RestHighLevelClient client) throws IOException {
        CreateIndexResponse user = client.indices().create(new CreateIndexRequest("user"), RequestOptions.DEFAULT);
        System.out.println("创建结果:" + user.isAcknowledged());
    }
    
    public static void createUserDoc(RestHighLevelClient client, List<User> userList) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        
        for (User user : userList) {
            bulkRequest.add(new IndexRequest("user", "_doc", user.getId()).source(JSON.toJSONString(user), XContentType.JSON));
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        
        LOGGER.info("update response:{}", Arrays.stream(bulkResponse.getItems())
                .map(rs -> rs.getResponse().getResult().getLowercase())
                .collect(Collectors.joining(",")));
    }
    
    
    public static List<User> createUserData() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId("1000100" + i);
            user.setName("user0" + i);
            user.setRemark("一号remark");
            userList.add(user);
        }
        return userList;
    }
    
}
