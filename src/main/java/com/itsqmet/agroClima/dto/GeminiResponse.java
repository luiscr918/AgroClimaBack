package com.itsqmet.agroClima.dto;

public class GeminiResponse {
    private String resultado;

    public GeminiResponse() {}
    public GeminiResponse(String resultado) { this.resultado = resultado; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
