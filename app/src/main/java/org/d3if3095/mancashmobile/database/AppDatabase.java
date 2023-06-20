package org.d3if3095.mancashmobile.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.d3if3095.mancashmobile.database.dao.DatabaseDao;
import org.d3if3095.mancashmobile.model.ModelDatabase;

@Database(entities = {ModelDatabase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}

