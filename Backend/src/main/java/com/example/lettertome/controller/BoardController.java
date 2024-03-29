package com.example.lettertome.controller;

import com.example.lettertome.model.Board;
import com.example.lettertome.service.BoardService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping
    public void create(@RequestBody Board board){
        boardService.create(board);
    }

    @GetMapping
    public List<Board> getList(){
        return boardService.alllist();
    }
    //전체 게시물 확인용

    @PostMapping("/{user_id}")
    public List<Board> get(@PathVariable String user_id, @RequestBody String status) throws ParseException {
        return boardService.list(user_id, status);
    }
    //일치하는 user_id 로 가져오기, board.html로 가져올거

    @GetMapping("/each/{board_id}")
    public Board get(@PathVariable Integer board_id){return boardService.get(board_id);}

    //letter.html에서 쓸것

    public void update(@RequestBody Board board) {boardService.update(board); }

    @DeleteMapping("/{board_id}")
    public void delete(@PathVariable Integer board_id) {boardService.delete(board_id); }
}
