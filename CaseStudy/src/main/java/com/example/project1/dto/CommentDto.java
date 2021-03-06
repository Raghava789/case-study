package com.example.project1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CommentDto {
	
	private int commentId;
	@Size(min = 2, max=20, message = "Comment of this size is not allowed")
	@NotEmpty
	private String commentDescription;
	private int votes;
	private boolean voteUp;
}
