package com.example.alexander.applicationtask3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText email_txt;
    EditText password_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_login = (Button) findViewById(R.id.btn_login);
        email_txt = (EditText) findViewById(R.id.editText_email);
        password_txt = (EditText) findViewById(R.id.editText_password);

        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://private-234eb-cobacoba1.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        UserApi user_api = retrofit.create(UserApi.class);
        retrofit.Call<Users> call = user_api.getUsers();
//        Toast.makeText(MainActivity.this, String.valueOf(call), Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(final Response<Users> response, Retrofit retrofit) {
                int status = response.code();
              Toast.makeText(MainActivity.this, String.valueOf(response.body().getUsers()), Toast.LENGTH_SHORT).show();

                        btn_login.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                for (Users.UserItem user : response.body().getUsers()) {
                                    if (String.valueOf(email_txt.getText()) == String.valueOf(user.getEmail()) && String.valueOf(password_txt.getText()) == String.valueOf(user.getPassword())){
                                    Intent intent_obj = new Intent(MainActivity.this, ActivityWelcome.class);
                                        startActivity(intent_obj);
                            }else Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            @Override
            public void onFailure(Throwable t) {
//                tv_respond.setText(String.valueOf(t));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}