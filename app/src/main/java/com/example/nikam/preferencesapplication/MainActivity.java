package com.example.nikam.preferencesapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login,display,clear;
    EditText user,pass;
    TextView display_userpass;


    public static final String MyPREFERENCES = "MyPrefs";
    public static final String username="userkey";
    public static final String password="passkey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.btn_login);
        display = (Button) findViewById(R.id.btn_display);
        clear=(Button)findViewById(R.id.btn_clear);
        user = (EditText) findViewById(R.id.edtxt_username);
        pass = (EditText) findViewById(R.id.edtxt_password);
        display_userpass = (TextView) findViewById(R.id.txt_userpass_view);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String u  = user.getText().toString();
        String p  = pass.getText().toString();

        SharedPreferences.Editor editor=sharedpreferences.edit();

        editor.putString("username",u);
        editor.putString("password",p);

        editor.commit();

        Toast.makeText(MainActivity.this, "Information Saved...!!!", Toast.LENGTH_SHORT).show();
    }
});

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


                SharedPreferences.Editor editor=sharedpreferences.edit();

                String u= sharedpreferences.getString("username","");
                String p=sharedpreferences.getString("password","");

                display_userpass.setText(u+""+p);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                user.setText("");
                pass.setText("");
                display_userpass.setText("");
              /*  editor.remove("username");
                editor.remove("password");*/
               /* editor.clear();*/
                editor.commit();

            }
        });
    }

  /*  public void loginInfo(View view)
    {
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String u  = user.getText().toString();
        String p  = pass.getText().toString();

        SharedPreferences.Editor editor=sharedpreferences.edit();

        editor.putString("username",u);
        editor.putString("password",p);

        //editor.commit();
        editor.commit();

        Toast.makeText(MainActivity.this, "Information Saved...!!!", Toast.LENGTH_SHORT).show();
    }*/

   /* public void displayInfo(View view)
    {
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

       *//* String u  = user.getText().toString();
        String p  = pass.getText().toString();*//*

        SharedPreferences.Editor editor=sharedpreferences.edit();

      String u= sharedpreferences.getString("username","");
       String p=sharedpreferences.getString("password","");

        display_userpass.setText(u+""+p);

    }*/

   /* public void clearInfo(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.clear();
        editor.commit();



    }
*/
}
