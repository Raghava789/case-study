package com.example.project1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Comment;
import com.example.project1.dto.CommentDto;
import com.example.project1.dto.CommentInputDto;
import com.example.project1.dto.CommentOutputDto;
import com.example.project1.service.CommentServiceImpl;

@RestController
public class CommentController {

	@Autowired
	CommentServiceImpl comServ;
	
	@PostMapping("/comments")
	public ResponseEntity<CommentDto> addComment(@Valid @RequestBody Comment comment) {
		CommentDto com = comServ.addComment(comment); 
		return new ResponseEntity<>(com, HttpStatus.OK);
	}
	
	@PostMapping("/comments/dto")
	public ResponseEntity<CommentOutputDto> addCommentDto(@Valid @RequestBody CommentInputDto comment) {
		CommentOutputDto com = comServ.addCommentDto(comment); 
		return new ResponseEntity<>(com, HttpStatus.OK);
	}
	
	@DeleteMapping("/comments")
	public void deleteComment(@RequestBody Comment comment) {
		comServ.deleteComment(comment);
	}
	
	@PatchMapping("/comments/{commentId}")
	public void upVote(@PathVariable("commentId") int commentId, boolean isupVote) {
		comServ.upVote(commentId, isupVote);
	}
}
