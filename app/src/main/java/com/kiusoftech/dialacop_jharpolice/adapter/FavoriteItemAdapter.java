package com.kiusoftech.dialacop_jharpolice.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.activity.ImportantDetailsActivity;
import com.kiusoftech.dialacop_jharpolice.activity.PoliceStationDetailsActivity;
import com.kiusoftech.dialacop_jharpolice.database.DialACopDatabase;
import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

import java.security.AccessController;
import java.util.List;

/**
 * Created by bamakant on 21/1/18.
 */

public class FavoriteItemAdapter extends RecyclerView.Adapter<FavoriteItemAdapter.FavoriteItemViewHolder> {

    private static final String TAG = "Kiu";

    List<FavoriteEntity> mFavoriteEntityList;
    private Context context;

    public FavoriteItemAdapter(Context context,List<FavoriteEntity> mFavoriteEntityList) {
        this.context = context;
        this.mFavoriteEntityList = mFavoriteEntityList;
    }

    public void updateList(List<FavoriteEntity> favoriteEntities){
        this.mFavoriteEntityList = favoriteEntities;
        notifyDataSetChanged();
    }

    public class FavoriteItemViewHolder extends RecyclerView.ViewHolder {

        private TextView favoriteTitleView;
        private ImageView favoriteDeleteImageView;

        public FavoriteItemViewHolder(View itemView) {
            super(itemView);
            favoriteTitleView = itemView.findViewById(R.id.favorite_items_row_item_title_textView);
            favoriteDeleteImageView = itemView.findViewById(R.id.favorite_items_row_delete_imageView);
        }
    }

    @Override
    public FavoriteItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_items_row, parent, false);

        return new FavoriteItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoriteItemViewHolder holder, int position) {

        final FavoriteEntity current = mFavoriteEntityList.get(position);

        holder.favoriteTitleView.setText(current.getFavoriteItemTitle());

        holder.favoriteTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int identifier = current.getIdentifier(); /** identifier is used to know to which activity intent should be called. */
                switch (identifier) {
                    case 1:
                        Intent policeIntent = new Intent(context, PoliceStationDetailsActivity.class);
                        policeIntent.putExtra("PoliceStationName", current.getFavoriteItemTitle());
                        context.startActivity(policeIntent);
                        break;
                    case 2:
                        Intent important = new Intent(context, ImportantDetailsActivity.class);
                        important.putExtra("designation", current.getFavoriteItemTitle());
                        context.startActivity(important);
                        break;
                }
            }
        });

        holder.favoriteDeleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete favorite item from here

                new AlertDialog.Builder(context)
                        .setTitle(current.getFavoriteItemTitle().toUpperCase())
                        .setMessage("Do you really want to delete?")
                        .setIcon(R.drawable.fail)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                new AsyncTask<Void, Void, Void>(){

                                    @Override
                                    protected Void doInBackground(Void... voids) {

                                        int deleteFavorite = DialACopDatabase.getAppDatabase(context).favoriteEntityDao().deleteFavoriteItems(current.getFavoriteItemTitle());
                                        Log.d(TAG,"Deleted : "+deleteFavorite);

                                        return null;
                                    }

                                    @Override
                                    protected void onPostExecute(Void aVoid) {
                                        updateList(mFavoriteEntityList);
                                        Toast.makeText(context, "Deleted, Tap STAR below to refresh.", Toast.LENGTH_SHORT).show();
                                    }
                                }.execute();

                            }
                        })
                        .setNegativeButton("No", null).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG,(mFavoriteEntityList ==null?0:mFavoriteEntityList.size())+" ");
        return mFavoriteEntityList==null?0:mFavoriteEntityList.size();
    }

}
