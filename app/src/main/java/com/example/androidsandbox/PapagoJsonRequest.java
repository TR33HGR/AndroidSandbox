package com.example.androidsandbox;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PapagoJsonRequest extends JsonObjectRequest{

    public PapagoJsonRequest(JSONObject requestData, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(Request.Method.POST, "https://openapi.naver.com/v1/papago/n2mt", requestData, listener, errorListener);
    }

    @Override
    public Map<java.lang.String, java.lang.String> getHeaders() throws AuthFailureError {
        Map headers = new HashMap();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Naver-Client-Id", "hY9VLNNfCMuQXzHuXsNg");
        headers.put("X-Naver-Client-Secret", "VmtfBzhWuf");
        Log.d("DEBUG", "%s".format(headers.toString()));
        return headers;
    }
}
