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
import entity.UserDAO;
import entity.UserRoomDatabase;

public class LoginActivity extends AppCompatActivity {


    private EditText editTextPhone;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Khởi tạo các thành phần giao diện người dùng
        editTextPhone = findViewById(R.id.edtTextPhone);
        editTextPassword = findViewById(R.id.edtPassWord);

        Button buttonLogin = findViewById(R.id.btLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin người dùng từ EditText
                String phone    = editTextPhone.getText().toString();
                String password = editTextPassword.getText().toString();

                // Truy vấn cơ sở dữ liệu để kiểm tra đăng nhập
                UserDAO userDAO = UserRoomDatabase.getDatabase(LoginActivity.this).getUserDAO();
                User user = userDAO.select(phone, password);

                if (user != null) {
                    // Đăng nhập thành công, chuyển sang màn hình chính
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Hủy màn hình đăng nhập
                } else {
                    // Đăng nhập không thành công, hiển thị thông báo lỗi
                    Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });


        TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the password reset activity
                Intent intent = new Intent(LoginActivity.this, PasswordResetActivity.class);
                startActivity(intent);
            }
        });

        Button btRegister = findViewById(R.id.btRegister);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the registration activity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}