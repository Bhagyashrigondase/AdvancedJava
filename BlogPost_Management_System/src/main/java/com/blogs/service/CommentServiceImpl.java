package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ApiException;
import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommentDTO;
import com.blogs.entities.BlogPost;
import com.blogs.entities.Comment;
import com.blogs.entities.User;
import com.blogs.repository.BlogPostRepository;
import com.blogs.repository.CommentRepository;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogPostRepository blogPostRepository;

	@Override
	public ApiResponse createNewComment(CommentDTO newComment) {
		User commenter=userRepository.findById(newComment.getCommenterId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid commenter id !!!!"));
		
		BlogPost post=blogPostRepository.findById(newComment.getPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid post id !!!!"));
		if(commenter.getId()==post.getAuthor().getId())
			throw new ApiException("Blogger can not comment on thier own post!!");
		Comment comment=mapper.map(newComment, Comment.class);
		comment.setCommenter(commenter);
		comment.setPost(post);
		Comment addedComment=commentRepository.save(comment);
		return new ApiResponse("Comment added successfully with id="+addedComment.getId());
	}

}
