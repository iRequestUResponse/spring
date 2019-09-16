package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

@Repository
public class LprodDao implements ILprodDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	/**
	* Method : selectAll
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : LPROD의 모든 목록 가져오기
	*/
	@Override
	public List<Lprod> getLprodList() {
		return sqlSession.selectList("lprod.getLprodList");
	}

	/**
	* Method : getLprodPagingList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : LPROD의 페이징 목록 가져오기
	*/
	@Override
	public List<Lprod> getLprodPagingList(Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	/**
	* Method : getLprodTotalCnt
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : LPROD 전체 건수 가져오기
	*/
	@Override
	public int getLprodTotalCnt() {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}
}
