package flow.mvc.dao.log;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.LogVO;

/**
 * @author 허태준 / 2021. 7. 21. / 오후 3:20:30
 */
@Repository
public class LogDao implements LogDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;


	@Override
	public void addlog(LogVO lvo) {
		ss.insert("log.addlog", lvo);
	}


	@Override
	public List<LogVO> getCDetailLog() {
		return ss.selectList("log.getCDetailLog");
	}

}
