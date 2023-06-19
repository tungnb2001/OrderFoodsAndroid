package entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class} , version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO();

    public static UserRoomDatabase INSTANCE = null;

    public static UserRoomDatabase getDatabase(Context context) {
        synchronized (UserRoomDatabase.class){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context , UserRoomDatabase.class , "UserDatabase")
                        .enableMultiInstanceInvalidation()
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCE;
    }
}
