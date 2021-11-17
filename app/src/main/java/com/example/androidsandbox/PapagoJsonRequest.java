package com.example.androidsandbox;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PapagoJsonRequest extends JsonObjectRequest{
    private final PapagoRequestData requestData;
    public PapagoJsonRequest(PapagoRequestData data, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) throws JSONException {
        super(Request.Method.POST, "https://openapi.naver.com/v1/papago/n2mt", data.getData(), listener, errorListener);
        super.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestData = data;
    }

    @Override
    public byte[] getBody() {
        return requestData.getHttpPostBody().getBytes();
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return requestData.getDataMap();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("charset", "UTF-8");
        headers.put("X-Naver-Client-Id", "hY9VLNNfCMuQXzHuXsNg");
        headers.put("X-Naver-Client-Secret", "VmtfBzhWuf");
        return headers;
    }
}
