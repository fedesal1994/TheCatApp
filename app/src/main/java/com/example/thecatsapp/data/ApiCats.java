package com.example.thecatsapp.data;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thecatsapp.Models.Cat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiCats {
    private static ApiCats instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private ApiCats(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized ApiCats getInstance(Context context) {
        if (instance == null) {
            instance = new ApiCats(context);
        }
        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public interface VolleyResponseListener {
        void onResponse(List<Cat> catList);

        void onError(String message);
    }

    public void getCats(VolleyResponseListener listener) {
        String url = "https://api.thecatapi.com/v1/breeds";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Cat> catList = new ArrayList<>();

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject catObject = response.getJSONObject(i);
                        String breedNameCat = catObject.getString("name");
                        String origin = catObject.getString("origin");
                        int affectionLevel = catObject.getInt("affection_level");
                        int intelligence = catObject.getInt("intelligence");
                        String imageUrl = catObject.getJSONArray("image").getJSONObject(0).getString("url");
                        Cat cat = new Cat(breedNameCat, origin, affectionLevel, intelligence, imageUrl);
                        catList.add(cat);
                    }
                    listener.onResponse(catList);
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onError("Error de respuesta del servidor");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError("No se puede conectar con el servidor");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("x-api-key", "bda53789-459e-46cd-9bc42936630fde39");
                return headers;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }
}
