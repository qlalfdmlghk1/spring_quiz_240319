package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList(); // 컨트롤러한테 전달
	}
	
	public void addBookmark(String title, String address) {
		bookmarkMapper.insertBookmark(title, address);
	}
}
