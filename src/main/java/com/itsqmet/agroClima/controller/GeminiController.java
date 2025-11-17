package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.dto.GeminiRequest;
import com.itsqmet.agroClima.dto.GeminiResponse;
import com.itsqmet.agroClima.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeminiController {
    @Autowired
    private GeminiService geminiService;

    @PostMapping("/recomendacionesIA")
    public GeminiResponse generarRecomendaciones(@RequestBody GeminiRequest request) {
        String resultado = geminiService.generarRecomendaciones(request.getPrompt());
        return new GeminiResponse(resultado);
    }
}
