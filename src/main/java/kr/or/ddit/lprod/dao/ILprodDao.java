package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodDao {
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
	public List<Lprod> getLprodPagingList(Page page);
	
	/**
	* Method : getLprodTotalCnt
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품그룹 전체 건수 조회
	*/
	public int getLprodTotalCnt();
}
