package cn.scau.edu.ssm.movietalk.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>
{

	@Override
	public Date convert(String time)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		try 
		{
			return df.parse(time);
		} catch (ParseException e) 
		{
			return null;
		}
	}

}
