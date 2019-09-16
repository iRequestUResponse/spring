package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.model.Prod;

@Service
public class ProdService implements IProdService {
	
	@Resource(name="prodDao")
	private IProdDao prodDao;
	public ProdService() {
	}
	
	/**
	* Method : getLprodList
	* 작성자 : PC-17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 리스트
	*/
	@Override
	public List<Prod> selectListByLGU(String lprod_gu) {
		return prodDao.selectListByLGU(lprod_gu);
	}
}
