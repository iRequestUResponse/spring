package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.Lprod;

@Service
public class LprodService implements ILprodService {
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	public LprodService() {
	}
	
	/**
	* Method : getLprodList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품그룹 리스트
	*/
	@Override
	public List<Lprod> getLprodList() {
		return lprodDao.getLprodList();
	}
	
	/**
	* Method : getLprodPagingList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품그룹 리스트 페이징
	*/
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<>();
		
		List<Lprod> lprodList = lprodDao.getLprodPagingList(page);
		int totalCnt = lprodDao.getLprodTotalCnt();
		
		// lprodList, paginationSize
		map.put("lprodList", lprodList);
		map.put("paginationSize", (totalCnt + page.getSize() - 1) / page.getSize());
		return map;
	}
}
