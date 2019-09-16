package kr.or.ddit.prod.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;

public class ProdServiceTest extends RootTestConfig {
	@Resource(name="prodService")
	private IProdService prodService;

	@Test
	public void selectListByLGUTest() {
		/***Given***/

		/***When***/
		List list = prodService.selectListByLGU("P101");

		/***Then***/
		assertEquals(6, list.size());
	}
}
