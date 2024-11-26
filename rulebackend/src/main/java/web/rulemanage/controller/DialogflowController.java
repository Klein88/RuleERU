package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.service.DialogflowService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class DialogflowController {

    @Autowired
    private DialogflowService dialogflowService;

    @PostMapping("/send")
    public String send(@RequestBody String message) {
        return dialogflowService.sendRequestToDialogflow(message);
    }
}
