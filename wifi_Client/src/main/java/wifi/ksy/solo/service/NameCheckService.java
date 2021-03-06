package wifi.ksy.solo.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi.ksy.solo.dao.MemberDao;



@Service
public class NameCheckService {
	
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public String checkName(String name) {
		
		String result = "N";
		
		dao = template.getMapper(MemberDao.class);
		
		int resultCnt = dao.selectByName(name);
		
		if(resultCnt < 1) {
			result = "Y";
		}
		
		return result;
	}

}
