package com.resgistration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping (path="api/resgitrations")
@AllArgsConstructor
public class ResgistraionController {
    private ResgistrationService resgistrationsService;
    public String resgister(@RequestBody ResgistrationRequest request) {
        return resgistrationsService.register(request);
    }
}