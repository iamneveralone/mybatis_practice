package dev.neveralone.mybatis.mapper;

import dev.neveralone.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto); // insert, update, delete : 몇 개의 row 가 조작을 받았는지를 return
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
}
