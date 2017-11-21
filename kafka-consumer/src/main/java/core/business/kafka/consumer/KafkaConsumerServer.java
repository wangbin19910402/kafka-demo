package core.business.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * KafkaConsumer监听器
 *
 * @Date 2017-11-21
 * @author wangbin
 *
 */
public class KafkaConsumerServer implements MessageListener<String, String> {
	protected final Logger LOG = LoggerFactory.getLogger("kafkaConsumer");
	/**
	 * 监听器自动执行该方法
	 * 	消费消息
	 * 	自动提交offset
	 * 	执行业务代码
	 * 	（high level api 不提供offset管理，不能指定offset进行消费）
	 */
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
		LOG.info("=============kafkaConsumer开始消费=============");
		String topic = record.topic();
		String key = record.key();
		String value = record.value();
		int partition = record.partition();
		LOG.info("-------------topic:"+topic);
		LOG.info("-------------value:"+value);
		LOG.info("-------------partition:"+partition);
		LOG.info("-------------key:"+key);


		/**
		 * 执行具体业务操作
		 * 		todo somethting
		 *
		 * 业务完成后执行回调通知函数
		 * 		todo ConsumerNotify.consumerAsynNotify();
		 */

		LOG.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
	}

}
