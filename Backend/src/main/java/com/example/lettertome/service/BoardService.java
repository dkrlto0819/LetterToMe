package com.example.lettertome.service;

import com.example.lettertome.controller.UserController;
import com.example.lettertome.model.Board;
import com.example.lettertome.model.User;
import com.example.lettertome.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list(String user_id) {
//        if(isAll) {
//            data = boardRepository.findByUser_Id(user_id)
//        } else {
//            data = boardRepository.findByStatus(true)
//        }

        List<Board> data= (List<Board>) boardRepository.findByUser_Id(user_id);
//        List<Board> result = new ArrayList<Board>();


//        for(Board b : data){
//            if(user_id.equals(b.getUser().getId())) {
//                result.add(b);
//            }
//        }
//        return  result;
//        int day = ChronoUnit.DAYS.between(board, today);
        Logger logger = LoggerFactory.getLogger(UserController.class);
        for(Board b : data){
            logger.info("this is open date : " + b.getOpen_date()
                    + " this is create date : " + b.getCreated_date());
            b.setD_day((int) ChronoUnit.DAYS.between(LocalDate.now(), b.getOpen_date()));
            if(b.getD_day()<=0)
                b.setSee_authority(true);
            else
                b.setSee_authority(false);
            ///(a, b) 중 b-a 인 것임
        }

        return data;
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
