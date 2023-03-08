package edu.asm.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import edu.asm.quanlythuvien.DAO.ThuThuDAO;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button btnLogin, btnCancel;
    CheckBox RPass;
    boolean passwordVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.Username);
        Password =findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        RPass = findViewById(R.id.RPass);

        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if (checkbox.equals("true")){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else if (checkbox.equals("false")){
            Toast.makeText(this, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
        }





        RPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isChecked()) {
                    SharedPreferences sPef = getSharedPreferences("checkbock", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sPef.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }else if (!compoundButton.isChecked()){

                    SharedPreferences sPef = getSharedPreferences("checkbock", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sPef.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }


            }
        });
        ThuThuDAO thuThuDAO = new ThuThuDAO(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Username.getText().toString();
                String pass = Password.getText().toString();
                if(thuThuDAO.checkDN(user,pass)){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("matt",user);
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }
                    },1500);
                }else{
                    Toast.makeText(LoginActivity.this,  "Username và password không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }


}