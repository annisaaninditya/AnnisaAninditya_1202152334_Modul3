package com.example.android.annisaaninditya_1202152334_modul3.AirMineral;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Microsoft-10 on 2/25/2018.
 */

class AirAdapter extends RecyclerView.Adapter<AirAdapter.AirViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Air> mAirData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context
     * @param airData ArrayList containing the sports data
     * @param context Context of the application
     */
    AirAdapter(Context context, ArrayList<Air> airData) {
        this.mAirData = airData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.aqua);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View is added after it is
     *               bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create SportsViewHolder.
     */
    @Override
    public AirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AirViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(AirViewHolder holder, int position) {

        //Get the current sport
        Air currentAir = mAirData.get(position);

        //Bind the data to the views
        holder.bindTo(currentAir);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mAirData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class AirViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mAirImage;
        private Context mContext;
        private Air mCurrentAir;
        private GradientDrawable mGradientDrawable;

        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        AirViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.judul);
            mInfoText = (TextView)itemView.findViewById(R.id.keterangan);
            mAirImage = (ImageView)itemView.findViewById(R.id.gambar);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Air currentAir){
            //Populate the textviews with data
            mTitleText.setText(currentAir.getTitle());
            mInfoText.setText(currentAir.getInfo());

            //Get the current sport
            mCurrentAir = currentAir;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentAir.
                    getImageResource()).placeholder(mGradientDrawable).into(mAirImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Air.starter(mContext, mCurrentAir.getTitle(),
                    mCurrentAir.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
