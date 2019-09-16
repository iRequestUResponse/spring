package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.prod.model.Prod;

public interface IProdService {
	/**
	* Method : getLprodList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 리스트
	*/
	public List<Prod> selectListByLGU(String lprod_gu); 
}
