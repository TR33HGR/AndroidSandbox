package com.example.androidsandbox;

public class PapagoRequestData {
    public String sourceLanguage;
    public String targetLanguage;
    public String textToTranslate;

    public PapagoRequestData(String source, String target, String text) {
        sourceLanguage = source;
        targetLanguage = target;
        textToTranslate = text;
    }
}
