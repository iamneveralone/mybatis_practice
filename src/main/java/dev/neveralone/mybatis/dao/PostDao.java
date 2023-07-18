package dev.neveralone.mybatis.dao;

import dev.neveralone.mybatis.dto.PostDto;
import dev.neveralone.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// 실제로 Mapper 를 사용해서 통신을 하는 class
@Repository // 이 클래스가 데이터를 주고받기 위해 존재하는 클래스임을 의미
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    ){
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto){
        // SqlSession session = sessionFactory.openSession(); // openSession 인자 비워두면 default 는 True
        // PostMapper 를 구현한 구현체가 mapper 에 주입됨
        // try 중괄호 안에서만 ( ) 안의 변수가 살아있도록 하는 문법 (여기서는 session)
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
    }

    public PostDto readPost(int id){
        // 왜 굳이 sessionFactory 에서 매번 session 을 열고 닫으면서 mapper 를 새로 받는 것이냐
        // mapper 인스턴스는 thread-safe 하지 않음 -> 요청이 동시에 들어오면 이 함수의 결과가 다른 함수에 영향 줄 수 있음
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll(){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }

    public int updatePost(PostDto dto){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }

    public int deletePost(int id){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
