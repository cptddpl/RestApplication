package com.webservices.restservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateos.mvc.ControllerLinkBuilder;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservices.restservice.exception.StdException;

@RestController
public class UserResource {
	
	@Autowired
	private UserDao service;
	
	@Autowired 
	private PostDao postService;
	
	@GetMapping("/users")
	public List<User> takeAllUsers()
	{
		return service.findAll();
		
		
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Posts> takeAllUsers(@PathVariable int id)
	{
		System.out.println("working1 ?");
		return postService.findAllPosts(); 
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> singleUser(@PathVariable int id)
	{
		User user = service.findUser(id);
		if(user==null)
			throw new UserNotFoundException("id - " + id);
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser=service.addUser(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> addPost(@PathVariable int id,@RequestBody Posts post)
	{	
		Posts savedPost=postService.addPost(post);
		savedPost.setId(id);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(savedPost.getPostid()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts/{postid}")
	public Posts singlePost(@PathVariable int id,@PathVariable int postid)
	{	
		System.out.println("working function67846 ?");
		Posts new1 = postService.findPost(id,postid);
		return new1;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id - " + id);
		
	}
	
	
	
	
}
