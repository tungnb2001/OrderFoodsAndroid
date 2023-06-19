package entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    void inser(User user);

    @Update(onConflict = OnConflictStrategy.ROLLBACK)
    void update(User user);

    @Query("SELECT * FROM USER_TABLE u WHERE u.userPhone  =:userPhone  and u.password =:password ")
    User select(String userPhone , String password);




}
