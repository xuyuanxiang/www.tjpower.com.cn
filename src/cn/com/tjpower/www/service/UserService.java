package cn.com.tjpower.www.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.tjpower.www.model.User;

@Service
public class UserService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public User get(String id) {
		return sqlSessionTemplate.selectOne("UserMapper.get", id);
	}

	public User getByCode(String code) {
		return sqlSessionTemplate.selectOne("UserMapper.getByCode");
	}

	public List<User> getAll() {
		return sqlSessionTemplate.selectList("UserMapper.getAll");
	}

	public int save(User user) {
		if (StringUtils.isNotEmpty(user.getId())) {
			return sqlSessionTemplate.update("UserMapper.update", user);
		} else {
			return sqlSessionTemplate.insert("UserMapper.insert", user);
		}
	}

	public int delete(String id) {
		return sqlSessionTemplate.delete("UserMapper.delete", id);
	}
}
