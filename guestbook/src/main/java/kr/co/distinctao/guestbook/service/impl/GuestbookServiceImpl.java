package kr.co.distinctao.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.distinctao.guestbook.dao.GuestbookDao;
import kr.co.distinctao.guestbook.dao.LogDao;
import kr.co.distinctao.guestbook.dto.Guestbook;
import kr.co.distinctao.guestbook.dto.Log;
import kr.co.distinctao.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional // readonly
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}

	@Override
	@Transactional (readOnly = false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		return deleteCount;
	}

	@Override
	@Transactional (readOnly = false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id);

//		if(1 == 1)
//		throw new RuntimeException("test exception"); // 일부로 예외 발생 시 전체 수행이 되지 않
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestbook;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}
}
