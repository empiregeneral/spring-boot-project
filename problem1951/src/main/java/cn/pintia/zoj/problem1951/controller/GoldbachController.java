package cn.pintia.zoj.problem1951.controller;

import cn.pintia.zoj.problem1951.dto.request.GoldbachEquationFirstRequest;
import cn.pintia.zoj.problem1951.dto.response.GoldbachEquationFirstResponse;
import cn.pintia.zoj.problem1951.service.GoldBachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/goldbach")
public class GoldbachController {
    @Autowired
    private GoldBachService goldBachService;

    @GetMapping("/equation-first")
    public ResponseEntity<GoldbachEquationFirstResponse> equationFirst(@Valid @RequestBody GoldbachEquationFirstRequest requestBody) {
        int evenNum = requestBody.getEvenNum();

        GoldbachEquationFirstResponse response = new GoldbachEquationFirstResponse(goldBachService.equationFirst(evenNum), 200);
        return ResponseEntity.ok(response);

    }
}
