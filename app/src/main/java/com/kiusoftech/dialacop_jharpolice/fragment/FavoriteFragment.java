package com.kiusoftech.dialacop_jharpolice.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.adapter.FavoriteItemAdapter;
import com.kiusoftech.dialacop_jharpolice.database.DialACopDatabase;
import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

import java.util.List;


public class FavoriteFragment extends Fragment {

    private View rootView;
    private RecyclerView favoriteRecyclerView;
    private FavoriteItemAdapter favoriteItemAdapter;
    List<FavoriteEntity> favoriteList;

    private static final String TAG = "Kiu";

    ImageView favoriteEmptyImage;
    TextView favoriteEmptyText;


    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_favorite, container, false);

        favoriteRecyclerView = rootView.findViewById(R.id.favorite_fragment_recyclerView);
        favoriteEmptyImage = rootView.findViewById(R.id.favorite_fragment_empty_image);
        favoriteEmptyText = rootView.findViewById(R.id.favorite_fragment_empty_textView);


        favoriteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        BackTask task = new BackTask();
        task.execute();

        return rootView;
    }

    public class BackTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {

            favoriteList = DialACopDatabase.getAppDatabase(getActivity().getApplicationContext()).favoriteEntityDao().getAllFavoriteItems();

            Log.d(TAG,"Total Favorite Items "+favoriteList.size());

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            if (!favoriteList.isEmpty()) {

                favoriteItemAdapter = new FavoriteItemAdapter(getActivity(), favoriteList);

                favoriteRecyclerView.setAdapter(favoriteItemAdapter);
                favoriteItemAdapter.notifyDataSetChanged();

                Toast.makeText(getActivity().getApplicationContext(), "Total Favorite Items : "+favoriteList.size(), Toast.LENGTH_SHORT).show();
                favoriteEmptyImage.setVisibility(View.GONE);
                favoriteEmptyText.setVisibility(View.GONE);

            }

        }
    }

}

