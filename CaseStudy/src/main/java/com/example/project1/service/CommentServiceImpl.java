package com.example.project1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.bean.Comment;
import com.example.project1.dto.CommentDto;
import com.example.project1.dto.CommentInputDto;
import com.example.project1.dto.CommentOutputDto;
import com.example.project1.exception.CommentNotFoundException;
import com.example.project1.repository.ICommentRepository;

@Service
public class CommentServiceImpl implements ICommentService{
	
	@Autowired
	ICommentRepository comRepo;

	@Override
	public CommentDto addComment(Comment comment) {
		
		Comment com = comRepo.save(comment);
		CommentDto comDto = new CommentDto();
		comDto.setCommentDescription(com.getCommentDescription());
		comDto.setVotes(com.getVotes());
		comDto.setVoteUp(com.isVoteUp());
		return comDto;
	}

	@Override
	public void deleteComment(Comment comment) {
		Optional<Comment> opt = comRepo.findById(comment.getCommentId());
		if(!opt.isPresent()) {
			throw new CommentNotFoundException("Comment Not Found");
		}
		comRepo.delete(comment);
	}

	@Override
	public void upVote(int commentId, boolean upVote) {
		Optional<Comment> opt = comRepo.findById(commentId);
		if(!opt.isPresent()) {
			throw new CommentNotFoundException("Comment Not Found with the given id: " +commentId);
		}
		Comment com = opt.get();
		com.setVoteUp(upVote);
		comRepo.save(com);
	}

	@Override
	public CommentOutputDto addCommentDto(CommentInputDto commentInputDto) {
		Comment com = new Comment();
		com.setCommentDescription(commentInputDto.getCommentDescription());
		com.setVotes(commentInputDto.getVotes());
		com.setVoteUp(commentInputDto.isVoteUp());
		Comment newCom = comRepo.save(com);
		CommentOutputDto comOutputDto = new CommentOutputDto();
		comOutputDto.setCommentDescription(newCom.getCommentDescription());
		comOutputDto.setVotes(newCom.getVotes());
		comOutputDto.setVoteUp(newCom.isVoteUp());
		
		return comOutputDto;
	}

	

}
