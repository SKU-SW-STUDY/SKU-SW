package sku.board.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/index/{seq}")
    public String showNotice(@PathVariable int seq) {
        System.out.println("Selected Notice Sequence: " + seq);

        return "boardView";
    }

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @GetMapping("/writeView")
    public String writeView(){

        return "writeView";
    }

}
