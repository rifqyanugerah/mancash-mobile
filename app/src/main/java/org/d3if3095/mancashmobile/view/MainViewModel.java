package org.d3if3095.mancashmobile.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import org.d3if3095.mancashmobile.database.DatabaseClient;
import org.d3if3095.mancashmobile.database.dao.DatabaseDao;
import org.d3if3095.mancashmobile.model.ModelDatabase;
import org.d3if3095.mancashmobile.view.fragment.pengeluaran.PengeluaranViewModel;

import java.util.List;

public class MainViewModel extends PengeluaranViewModel {

    private LiveData<List<ModelDatabase>> mPengeluarans;
    private DatabaseDao databaseDao;
    private LiveData<Integer> mTotalPrice;

    public MainViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
        mPengeluarans = databaseDao.getAllPengeluaran();
        mTotalPrice = databaseDao.getTotalPengeluaranSaldo();
    }

    public LiveData<Integer> getTotalPengeluaranSaldo() { return mTotalPrice; }

}
