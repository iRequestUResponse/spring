package kr.or.ddit.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

// 문자열 -> java.utl.Date
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
