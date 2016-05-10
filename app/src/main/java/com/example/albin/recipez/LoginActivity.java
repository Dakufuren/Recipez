package com.example.albin.recipez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private RequestQueue requestQueue;
    private static String URL = "http://wolfcrew.se/scripts/login_control.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        login = (Button) findViewById(R.id.loginButton);

        requestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            System.out.println("test " + response);
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject.names().get(0) + "    asdsa");
                            if(jsonObject.names().get(0).equals("success")) {
                                startActivity(new Intent(getApplicationContext(), ShuffleRecipeActivity.class));
                            } else if (jsonObject.names().get(0).equals("failure")) {
                                System.out.println("FEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEL");
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("hej");
                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        System.out.println("try1");
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        String tmpusr = "";
                        String tmppass = "";
                        if (username.getText().toString() != null) {
                            tmpusr = username.getText().toString();
                        }
                        if (password.getText().toString() != null) {
                           tmppass = password.getText().toString();
                        }

                        hashMap.put("username", tmpusr);
                        hashMap.put("password", tmppass);
                        System.out.println("try2");
                        return hashMap;
                    }

                };
                System.out.println("sending request");
                requestQueue.add(request);

            }
        });

    }
}
