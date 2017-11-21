package core.business.kafka.notify;

/**
 * 消费者消费回调
 *
 * @Date 2017-11-21
 * @author wangbin
 *
 */
public class ConsumerNotify {


    public Boolean consumerAsynNotify(String code, String message) throws Exception {

        /**
         * 通知接口：异步通知，可以根据对方返回的code获取是否通知成功
         *      返回true/false判断是否实现业务完整性
         */
        return true;
    }

}
