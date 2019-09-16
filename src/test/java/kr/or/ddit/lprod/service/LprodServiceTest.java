package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.repository.LprodDaoTest;

public class LprodServiceTest extends RootTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	@Resource(name="lprodService")
	private ILprodService lprodService;

	@Test
	public void getLprodListTest() {
		/***Given***/

		/***When***/
		List<Lprod> lprodList = lprodService.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}

	@Test
	public void getLprodPagingListTest() {
		/***Given***/

		/***When***/
		Page page = new Page();
		page.setPage(1);
		page.setSize(2);
		Map map = lprodService.getLprodPagingList(page);
		List list = (List) map.get("lprodList");
		Integer paginationSize = (Integer) map.get("paginationSize");
		logger.debug("paging list : {}", map);

		/***Then***/
		assertNotNull(map);
		assertNotNull(list);
		assertNotNull(paginationSize);
	}
}
