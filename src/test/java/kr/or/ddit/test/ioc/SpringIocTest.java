package kr.or.ddit.test.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/spring/ioc/application-context-ioc-test.xml")
public class SpringIocTest {
	
	@Resource(name="dbProperty")
	private DbProperty dbProperty;
	
	@Resource(name="dbPropertySetter")
	private DbProperty dbPropertySetter;

	/**
	* Method : propertyPlaceholderTest
	* 작성자 : PC-17
	* 변경이력 :
	* Method 설명 : <context:property-placeholder> 테스트
	*/
	@Test
	public void propertyPlaceholderTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(dbProperty);
		assertEquals("gear", dbProperty.getUser());
		assertEquals("java", dbProperty.getPass());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbProperty.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbProperty.getUrl());
		
		assertNotNull(dbPropertySetter);
		assertEquals("gear", dbPropertySetter.getUser());
		assertEquals("java", dbPropertySetter.getPass());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbPropertySetter.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbPropertySetter.getUrl());
	}

}
