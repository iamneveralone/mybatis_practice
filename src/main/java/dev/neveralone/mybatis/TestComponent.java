package dev.neveralone.mybatis;

import dev.neveralone.mybatis.dao.BoardDao;
import dev.neveralone.mybatis.dao.PostDao;
import dev.neveralone.mybatis.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;
    public TestComponent(
            @Autowired PostDao postDao,
            @Autowired BoardDao boardDao
    ){
        this.postDao = postDao;
        this.boardDao = boardDao;

        BoardDto boardDto = new BoardDto();
        boardDto.setName("new board");
        this.boardDao.createBoard(boardDto);
        System.out.println(boardDto.getId());
    }
}
