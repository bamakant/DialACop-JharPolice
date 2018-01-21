package com.kiusoftech.dialacop_jharpolice.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.kiusoftech.dialacop_jharpolice.dao.FavoriteEntityDao;
import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

/**
 * Created by bamakant on 21/1/18.
 */

@Database(entities = {FavoriteEntity.class},version = 1)
public abstract class DialACopDatabase extends RoomDatabase{

    private static DialACopDatabase INSTANCE;

    public abstract FavoriteEntityDao favoriteEntityDao();

    public static DialACopDatabase getAppDatabase(Context context){

        if (INSTANCE == null){
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DialACopDatabase.class, "favorite_table")
                            //.allowMainThreadQueries()
                            .fallbackToDestructiveMigration() //this should not call because it re-creates all the tables
                            .build();
        }
        return INSTANCE;
    }
}
