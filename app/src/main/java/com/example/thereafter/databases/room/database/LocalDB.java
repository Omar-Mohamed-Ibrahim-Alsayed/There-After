package com.example.thereafter.databases.room.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.example.thereafter.databases.room.dao.ActivityItemDao;
import com.example.thereafter.databases.room.dao.PostItemDao;
import com.example.thereafter.databases.room.dao.SermonDao;
import com.example.thereafter.databases.room.dao.UserDao;
import com.example.thereafter.databases.room.entities.ActivityItemEntity;
import com.example.thereafter.databases.room.entities.PostItemEntity;
import com.example.thereafter.databases.room.entities.SermonEntity;
import com.example.thereafter.databases.room.entities.UserEntity;

@Database(entities = {SermonEntity.class, ActivityItemEntity.class, PostItemEntity.class, UserEntity.class}, version = 1)
public abstract class LocalDB extends RoomDatabase {

    private static volatile LocalDB INSTANCE;

    public static LocalDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LocalDB.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract SermonDao sermonDao();

    public abstract ActivityItemDao activityItemDao();

    public abstract PostItemDao postItemDao();

    public abstract UserDao userDao();
}
