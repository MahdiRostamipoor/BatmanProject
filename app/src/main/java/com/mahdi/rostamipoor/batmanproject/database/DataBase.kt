package com.mahdi.rostamipoor.batmanproject.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.mahdi.rostamipoor.batmanproject.model.DetailMovieModel
import com.mahdi.rostamipoor.batmanproject.model.Search

@Database(entities = [Search::class , DetailMovieModel::class], version = 4, exportSchema = false)
abstract class DataBase : RoomDatabase(){

    companion object{

        @Volatile
        private var appDatabase: DataBase? = null

        open fun getInstance(context: Context?): DataBase? {
            synchronized(this) {
                if (appDatabase == null) {
                    appDatabase = databaseBuilder(
                        context!!, DataBase::class.java,
                        "db_movie"
                    ).allowMainThreadQueries().build()
                }
                return appDatabase
            }
        }

    }



    abstract val movieDao: DataDao

}