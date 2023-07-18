package dev.neveralone.mybatis.mapper;

import dev.neveralone.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
