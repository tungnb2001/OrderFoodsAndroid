package entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "user_table")
public class User {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    private int id;

    @NonNull
    @ColumnInfo(name = "userName")
    private String userName;

    @NonNull
    @ColumnInfo(name = "gender")
    private String gender;

    @NonNull
    @ColumnInfo(name = "dob")
    private Date dob;
    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @ColumnInfo(name = "userEmail")
    private String email;
    @NonNull
    @ColumnInfo(name = "userAddress")
    private String address;

    @NonNull
    @ColumnInfo(name = "userPhone")
    private String phone;

    @NonNull
    @ColumnInfo(name = "pronoun")
    private String pronoun;

    @NonNull
    @ColumnInfo(name = "SecurityQuestion")
    private String SecurityQuestion;

    @NonNull
    @ColumnInfo(name = "coin")
    private String coin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public Date getDob() {
        return dob;
    }

    public void setDob(@NonNull Date dob) {
        this.dob = dob;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(@NonNull String pronoun) {
        this.pronoun = pronoun;
    }

    @NonNull
    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(@NonNull String securityQuestion) {
        SecurityQuestion = securityQuestion;
    }

    @NonNull
    public String getCoin() {
        return coin;
    }

    public void setCoin(@NonNull String coin) {
        this.coin = coin;
    }
}
