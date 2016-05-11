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

public class CreateAccountActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private Button create;
    private RequestQueue requestQueue;
    private StringRequest request;
    private static String URL = "http://wolfcrew.se/scripts/adduser_control.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        username = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        email = (EditText) findViewById(R.id.emailField);
        create = (Button) findViewById(R.id.createButton);

        requestQueue = Volley.newRequestQueue(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tempUser = username.getText().toString();
                String tempPass = password.getText().toString();
                String tempEmail = email.getText().toString();

                if (tempUser.matches("") || tempPass.matches("") || tempEmail.matches("")) {
                    System.out.println("Fields are empty fill em!");
                } else {

                    request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                System.out.println("tjo   " + response);
                                JSONObject jsonObject = new JSONObject(response);
                                System.out.println(jsonObject.names().get(0) + "    asdsa");

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("hej");
                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            System.out.println("try1");
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            String tmpusr = "";
                            String tmppass = "";
                            String tmpemail = "";
                            if (username.getText().toString() != null) {
                                tmpusr = username.getText().toString();
                            }
                            if (password.getText().toString() != null) {
                                tmppass = password.getText().toString();
                            }
                            if (email.getText().toString() != null) {
                                tmpemail = email.getText().toString();
                            }

                            hashMap.put("username", tmpusr);
                            hashMap.put("password", tmppass);
                            hashMap.put("email", tmpemail);
                            System.out.println("try2");
                            return hashMap;
                        }

                    };
                    System.out.println("sending request");
                    requestQueue.add(request);

                }
            }


        });


    }
}
