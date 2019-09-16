package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodService {
	/**
	* Method : getLprodList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품그룹 리스트
	*/
	public List<Lprod> getLprodList();
	
	/**
	* Method : getLprodPagingList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품그룹 리스트 페이징
	*/
	public Map<String, Object> getLprodPagingList(Page page);
}
