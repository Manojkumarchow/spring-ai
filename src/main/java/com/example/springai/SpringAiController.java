package com.example.springai;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAiController {

    private final OpenAiChatModel openAiChatModel;

    public SpringAiController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }


    @GetMapping("/prompt")
    public ResponseEntity<String> getPrompt(@RequestParam(defaultValue = "Tell me a joke") String message) {
        String response = openAiChatModel.call(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
