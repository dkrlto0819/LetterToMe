package com.example.lettertome.service;

import com.example.lettertome.controller.UserController;
import com.example.lettertome.model.Board;
import com.example.lettertome.model.User;
import com.example.lettertome.repository.BoardRepository;
import com.example.lettertome.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    @Autowired
    private UserRepository userRepository;

    public void create(Board board) {
        Logger logger = LoggerFactory.getLogger(UserController.class);
        User user = new User();
        user = userRepository.findById(board.getUser().getId()).orElse(null);
        //user = userRepository.findById(board.getUser);
        board.setUser(user);
        boardRepository.save(board);
    }

    public List<Board> list(String user_id, String status) throws ParseException {

        List<Board> data= (List<Board>) boardRepository.findByUser_Id(user_id);

        Logger logger = LoggerFactory.getLogger(UserController.class);

        Boolean statusData = extractStatus(status);

        for(Board b : data){
            b.setD_day((int) ChronoUnit.DAYS.between(LocalDate.now(), b.getOpen_date()));
            if(b.getD_day()<=0)
                b.setSeeAuthority(true);
            else
                b.setSeeAuthority(false);
            ///(a, b) 중 b-a 인 것임

            boardRepository.save(b);
        }

        if(statusData==false){
            data= (List<Board>) boardRepository.findByUser_Id(user_id);
        }else{
            data= (List<Board>) boardRepository.findByUser_IdAndSeeAuthority(user_id, true);
            //완료된것만 보기
        }



        return data;
    }

    private Boolean extractStatus(String status) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(status);
        Boolean dataObject = (Boolean) jsonObject.get("show");

        Logger logger = LoggerFactory.getLogger(UserController.class);
        return dataObject;
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
