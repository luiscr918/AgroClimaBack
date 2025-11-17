package com.itsqmet.agroClima.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class GeminiService {

    @Value("${API_KEY_GOOGLE}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private final String apiUrl =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    // 🔥 FUNCIÓN PARA LIMPIAR RESPUESTA DE GEMINI
    private String limpiarMarkdownJson(String texto) {
        if (texto == null) return null;

        texto = texto.replaceAll("```json", "");
        texto = texto.replaceAll("```", "");
        texto = texto.replaceAll("`", "");

        return texto.trim();
    }

    public String generarRecomendaciones(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-goog-api-key", apiKey);

        // 🔥 Súper prompt para obligar a JSON puro
        String promptForzado = """
                Devuelve ÚNICAMENTE un JSON válido.
                No incluyas explicaciones, ni texto adicional.
                No utilices bloques Markdown como ```json.
                SOLO devuelve un JSON válido, sin texto fuera del JSON.

                Aquí están los datos:
                """ + prompt;

        Map<String, Object> request = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", promptForzado)
                        })
                }
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(apiUrl, HttpMethod.POST, entity, Map.class);

        try {
            // 🔥 Extraer texto
            Map candidate = (Map) ((java.util.List) response.getBody().get("candidates")).get(0);
            Map content = (Map) candidate.get("content");
            java.util.List parts = (java.util.List) content.get("parts");
            Map part = (Map) parts.get(0);

            String texto = part.get("text").toString();

            // 🔥 Limpieza obligatoria
            return limpiarMarkdownJson(texto);

        } catch (Exception e) {
            e.printStackTrace();
            return """
            { "error": "Error procesando respuesta de Gemini en backend" }
            """;
        }
    }
}
