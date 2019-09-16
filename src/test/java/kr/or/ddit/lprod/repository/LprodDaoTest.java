package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.Lprod;

public class LprodDaoTest extends RootTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;

	@Test
	public void getLprodListTest() {
		/***Given***/

		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}

	@Test
	public void getLprodPagingListTest() {
		/***Given***/

		/***When***/
		Page page = new Page();
		page.setPage(1);
		page.setSize(5);
		List list = lprodDao.getLprodPagingList(page);
		logger.debug("paging list : {}", list);

		/***Then***/
		assertNotNull(list);
	}

	@Test
	public void getLprodTotalCntTest() {
		/***Given***/

		/***When***/
		int cnt = lprodDao.getLprodTotalCnt();

		/***Then***/
		assertEquals(10, cnt);
	}
}
