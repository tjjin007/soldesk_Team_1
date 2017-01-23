package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.dto.HistoryDTO;
import kr.co.music.MusicMapper;

@Component
public class HistoryDAO extends AbstractDAO{

	@Autowired
	private SqlSession sqlSession;		// sql �� ���� ��ü
	
	public List<HistoryDTO> list(){
		MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
		List<HistoryDTO> list = mapper.list();
		return list;
	}
}
