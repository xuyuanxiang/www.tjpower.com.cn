package cn.com.tjpower.www.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tjpower.www.model.Message;
import cn.com.tjpower.www.service.MessageService;
import cn.com.tjpower.www.util.StringConvert;

@Controller
@RequestMapping("message")
public class MessageController {

	@Autowired
	MessageService messageService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Message> getAll() {
		return messageService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Message get(@PathVariable String id) {
		return messageService.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public int create(String name, String content) {
		if (StringUtils.isEmpty(name) && StringUtils.isEmpty(content))
			return 0;
		Message message = new Message();
		message.setId(StringConvert.getUUIDString());
		message.setName(name);
		message.setContent(content);
		message.setCreated(new Date());
		return messageService.insert(message);
	}
}
