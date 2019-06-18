package com.example.lettertome.service;

import com.example.lettertome.model.Board;
import com.example.lettertome.model.User;
import com.example.lettertome.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list(String user_id) {
//        List<Board> data= (List<Board>) boardRepository.findAll();
//        List<Board> result = new ArrayList<Board>();


//        for(Board b : data){
//            if(user_id.equals(b.getUser().getId())) {
//                result.add(b);
//            }
//        }
//        return  result;
        return boardRepository.findByUser_Id(user_id);
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
