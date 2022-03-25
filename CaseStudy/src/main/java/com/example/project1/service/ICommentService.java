package com.example.project1.service;


import com.example.project1.bean.Comment;
import com.example.project1.dto.CommentDto;
import com.example.project1.dto.CommentInputDto;
import com.example.project1.dto.CommentOutputDto;

public interface ICommentService {

	public CommentDto addComment(Comment comment);
	public CommentOutputDto addCommentDto(CommentInputDto comment);
	public void deleteComment(Comment comment);
	public void upVote(int commentId, boolean upVote);

}
