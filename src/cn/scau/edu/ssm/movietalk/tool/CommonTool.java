package cn.scau.edu.ssm.movietalk.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用工具类
 * @author Administrator
 *
 */
public class CommonTool {
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String addtime = sdf.format(date);
		return addtime;
	}
}
