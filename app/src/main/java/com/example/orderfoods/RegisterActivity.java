package com.example.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entity.User;
import entity.UserRoomDatabase;

public class RegisterActivity extends AppCompatActivity {


    private EditText edtRegisterName;
    private EditText edtRegisterPhone;
    private EditText edtRegisterPassWord;
    private EditText edtRegisterConfirmPassWord;
    private EditText edtRegisterEmail;
    private EditText edtAddress;

    private Button btSubmit;
    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Khai báo biến cho các EditText
        edtRegisterName = findViewById(R.id.edtRegisterName);
        edtRegisterPhone = findViewById(R.id.edtRegisterPhone);
        edtRegisterPassWord = findViewById(R.id.edtRegisterPassWord);
        edtRegisterConfirmPassWord = findViewById(R.id.edtRegisterConfirmPassWord);
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        edtAddress = findViewById(R.id.edtAddress);

        // Khai báo biến cho nút Submit và Back
        btSubmit = findViewById(R.id.btSubmit);
        tvBack = findViewById(R.id.tvBack);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText
                String userName = edtRegisterName.getText().toString();
                String phone = edtRegisterPhone.getText().toString();
                String password = edtRegisterPassWord.getText().toString();
                String confirmPassword = edtRegisterConfirmPassWord.getText().toString();
                String email = edtRegisterEmail.getText().toString();
                String address = edtAddress.getText().toString();

                // Kiểm tra mật khẩu có khớp với xác nhận mật khẩu hay không
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo đối tượng User và lưu vào database
                User user = new User();
                user.setUserName(userName);
                user.setPhone(phone);
                user.setPassword(password);
                user.setEmail(email);
                user.setAddress(address);

                UserRoomDatabase.getDatabase(RegisterActivity.this).getUserDAO().inser(user);

                // Chuyển hướng về trang HomeActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng về trang HomeActivity
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}