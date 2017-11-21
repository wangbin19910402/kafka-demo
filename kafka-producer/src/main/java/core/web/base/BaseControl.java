package core.web.base;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 基础control
 *
 * @date 2017-11-21
 * @author wangbin
 *
 */
@Controller
public class BaseControl {

	protected final static String SUCCESS = "success";
	protected final static String CODE = "Code";
	protected final static String MESSAGE = "message";
	
	public void writeJSON(JSONObject json, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}
	
	public JSONObject getKafkaMes(boolean success, String code,String message){
		JSONObject json = new JSONObject();
		json.accumulate(SUCCESS, success);
		json.accumulate(CODE, code);
		json.accumulate(MESSAGE, message);
		return json;
	}
	
}
