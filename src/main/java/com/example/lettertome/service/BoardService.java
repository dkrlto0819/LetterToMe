package com.example.lettertome.service;

import com.example.lettertome.model.Board;
import com.example.lettertome.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;
    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list() {
        List<Board> result= (List<Board>) boardRepository.findAll();
        return  result;
    }

    public Board get(Integer board_id) {
        return boardRepository.findById(board_id).orElse(null);
    }

    public void update(Board board) {
        boardRepository.save(board);
    }

    public void delete(Integer board_id) {
        boardRepository.deleteById(board_id);
    }
}
