package com.webservices.restservice.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDao {

	static List<Posts> posts=new ArrayList<>();

	static
	{
		posts.add(new Posts("1post",1,1));
		posts.add(new Posts("1post",2,1));
		posts.add(new Posts("1post",3,1));
	}

	public List<Posts> findAllPosts()
	{
		System.out.println("Working ?");
		return posts;
	}
	public Posts findPost(int id,int postid)
	{
		System.out.println("Inside findpost");
		for(Posts post:posts){
			if((post.getPostid()==postid)&&(post.getId()==id)){
				System.out.println("Post found");
				return post;
			}
		}
		System.out.println("Post not found");
		return null;
	}

	static int postCount=0;
	public Posts addPost(Posts post)
	{
		if(post.getPostid()==0)
			post.setPostid(++postCount);
		posts.add(post);
		return post;
	}



}
