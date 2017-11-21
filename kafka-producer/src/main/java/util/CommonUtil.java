package util;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Json相关Util
 *
 * @Date 2017-11-21
 * @author wangbin
 *
 */
public class CommonUtil {
	/**
	 * 将json转换成map
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> jsonToHashMap(Object object){  
		HashMap<String, Object> data = new HashMap<String, Object>();  
		// 将json字符串转换成jsonObject  
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();  
		// 遍历jsonObject数据，添加到Map对象  
		while (it.hasNext())  
		{  
			String key = String.valueOf(it.next());  
			Object value = (Object) jsonObject.get(key);  
			data.put(key, value);  
		}  
		return data;  
	}

	@SuppressWarnings("rawtypes")
	public static String mapToJsonStr(Map<String,Object> map) {
		return JSON.toJSONString(map);
	}
}
