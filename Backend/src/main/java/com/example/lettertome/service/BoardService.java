package com.example.lettertome.service;

import com.example.lettertome.model.Board;
import com.example.lettertome.model.User;
import com.example.lettertome.repository.BoardRepository;
import com.example.lettertome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

//    @Autowired
//    private UserRepository userRepository;

    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list(String user_id) {
        List<Board> data= (List<Board>) boardRepository.findAll();
        List<Board> result = new ArrayList<Board>();

        for(Board b : data){
            if(user_id.equals(b.getUser().getId()))
                result.add(b);
        }
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

    public List<Board> alllist() {
        List<Board> result = (List<Board>) boardRepository.findAll();
        return result;
    }
}
