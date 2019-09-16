package kr.or.ddit.prod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.dao.IProdDao;

public class ProdDaoTest extends RootTestConfig {
	@Resource(name="prodDao")
	private IProdDao prodDao;

	@Test
	public void selectListByLGUTest() {
		/***Given***/

		/***When***/
		List list = prodDao.selectListByLGU("P101");

		/***Then***/
		assertEquals(6, list.size());
	}
}
