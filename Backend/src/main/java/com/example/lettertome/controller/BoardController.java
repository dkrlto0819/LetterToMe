package com.example.lettertome.controller;

import com.example.lettertome.model.Board;
import com.example.lettertome.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping
    public void create(@RequestBody Board board){
        boardService.create(board);
    }

    @GetMapping
    public List<Board> get(){
        return boardService.list();
    }

    @GetMapping("/{board_id}")
    public Board get(@PathVariable Integer board_id){return boardService.get(board_id);}

    public void update(@RequestBody Board board) {boardService.update(board); }

    @DeleteMapping("/{board_id}")
    public void delete(@PathVariable Integer board_id) {boardService.delete(board_id); }
}
