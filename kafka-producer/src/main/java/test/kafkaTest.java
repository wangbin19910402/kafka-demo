package test;

import util.CommonUtil;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Kafka测试(单线程HttpPost)
 *
 * @Date 2017-11-21
 * @author wangb
 *
 */
public class kafkaTest {


    private static final String url = "http://localhost:8083/kafka/kafkaProduce.shtml";
    private static final String topic = "tt1";
    private static final String ifPartiton = "0";
    private static final int partitionNum = 3;


    public static void main(String[] args) {
        String test = "test1";

        Map<String,Object> param = new HashMap<>();
        param.put("topic",topic);
        param.put("ifPartiton",ifPartiton);
        param.put("partitionNum",getPartition(test));
        param.put("message",test);


        HttpUtil.sendPost(url, CommonUtil.mapToJsonStr(param));
    }


    private static int getPartition(String message){
        if (message == null) {
            Random random = new Random();
            return random.nextInt(partitionNum);
        }else {
            return Math.abs(message.hashCode())%partitionNum;
        }
    }

}
