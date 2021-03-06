package com.example.project1.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project1.bean.Comment;
import com.example.project1.dto.CommentDto;
import com.example.project1.dto.CommentInputDto;
import com.example.project1.dto.CommentOutputDto;


@SpringBootTest
class CommentServiceTest {
	
	@Autowired
	ICommentService comServ;

	@Test
	void addCommentTest() {
		Comment comment = new Comment();
		comment.setCommentId(57);
		comment.setCommentDescription("Avg");
		comment.setVotes(9);
		//comment.setVoteUp(false);
		
		CommentDto comDto = comServ.addComment(comment);
		assertEquals("Avg", comDto.getCommentDescription());
		assertEquals(9, comDto.getVotes());
		//assertEquals(57, comDto.get)
	}
	
	@Test
	@Disabled
	void deleteCommentTest() {
		Comment comment = new Comment();
		comment.setCommentId(57);
		comment.setCommentDescription("Avg");
		comment.setVotes(9);
		
		if(comment!=null) {
			assertEquals("Avg", comment.getCommentDescription());
			assertEquals(9, comment.getVotes());
			comServ.deleteComment(comment);
		}
		
	}
	
	@Test
	void addCommentDto() {
		CommentInputDto comDto = new CommentInputDto();
		comDto.setCommentId(1);
		comDto.setCommentDescription("Good");
		comDto.setVotes(3);
		comDto.setVoteUp(false);
		CommentOutputDto comOutDto = comServ.addCommentDto(comDto);
		assertEquals("Good", comOutDto.getCommentDescription());
		assertEquals(3, comOutDto.getVotes());
		assertEquals(false, comOutDto.isVoteUp());
	}
}
