package cn.com.tjpower.www.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.tjpower.www.model.Message;

@Service
public class MessageService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public Message get(String id) {
		return sqlSessionTemplate.selectOne("MessageMapper.get", id);
	}

	public List<Message> getAll() {
		return sqlSessionTemplate.selectList("MessageMapper.getAll");
	}

	public int insert(Message message) {
		return sqlSessionTemplate.insert("MessageMapper.insert", message);
	}

	public int delete(String id) {
		return sqlSessionTemplate.insert("MessageMapper.delete", id);
	}

}
