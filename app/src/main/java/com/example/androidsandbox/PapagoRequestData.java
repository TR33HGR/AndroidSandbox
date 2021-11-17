package com.example.androidsandbox;

import org.json.JSONException;
import org.json.JSONObject;

public class PapagoRequestData {
    public String sourceLanguage;
    public String targetLanguage;
    public String textToTranslate;

    public PapagoRequestData(String source, String target, String text) {
        sourceLanguage = source;
        targetLanguage = target;
        textToTranslate = text;
    }
    public JSONObject getData() throws JSONException {
        JSONObject data = new JSONObject();
        data.put("source", sourceLanguage);
        data.put("target", targetLanguage);
        data.put("text", textToTranslate);
        return data;
    }

    public String getHttpPostBody() {
        return "source=%s&target=%s&text=%s".format(sourceLanguage, targetLanguage, textToTranslate);
    }

}
