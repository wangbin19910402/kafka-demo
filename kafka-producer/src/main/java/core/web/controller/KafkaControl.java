package core.web.controller;

import core.business.kafka.KafkaMesConstant;
import core.business.kafka.producer.service.KafkaProducerServer;
import core.web.base.BaseControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * kafkaProducer的Controller
 *
 * @Date 2017-11-21
 * @author wangb
 *
 */
@Controller
public class KafkaControl extends BaseControl {

    @Resource
    private KafkaProducerServer kafkaProducer;

    /**
     * kafka发送消息接口
     *
     * @param request
     * @param response
     * @param topic
     * @param message
     * @param ifPartition 是否使用分区 0使用分区 -1不使用分区
     * @param partitionNum 如果使用分区，那么传递分区数量
     * @throws Exception
     */
    @RequestMapping(value = "/kafka/kafkaProduce")
    public void kafkaProduce(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("topic") String topic,
                             @RequestParam("message") String message,
                             @RequestParam(value = "ifPartition", required = false, defaultValue = "0") String ifPartition,
                             @RequestParam(value = "partitionNum", required = false, defaultValue = "-1") int partitionNum) throws Exception {
        Map<String, Object> res = kafkaProducer.sndMesForTemplate(topic, message, ifPartition, partitionNum);
        String kcode = (String) res.get("code");
        if (!kcode.equals(KafkaMesConstant.SUCCESS_CODE)) {
            writeJSON(getKafkaMes(false, kcode, message), response);
        } else {
            writeJSON(getKafkaMes(true, kcode, message), response);
        }
    }
}