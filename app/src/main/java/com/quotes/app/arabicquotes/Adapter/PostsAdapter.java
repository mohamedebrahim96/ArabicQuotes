package com.quotes.app.arabicquotes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.quotes.app.arabicquotes.Model.Data;
import com.quotes.app.arabicquotes.R;

import java.util.List;

/**
 * Created by Home on 2017-07-16.
 */

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<Data> qoutes;
    public List<Data> reemList;
    public Context context;

    public Vibrator vibe;
    MediaPlayer mp;
    public PostsAdapter(List<Data> reemList,List<Data> qoutes, Context context) {
        this.qoutes = qoutes;
        this.context = context;
        this.reemList = reemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view;

        if (viewType == 0)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false);
            return new PostsViewHolder(view);
        }
        if(viewType==1)
        {

            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.reem_layout, parent, false);

            return new SimpleText(view);

        }

        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
            return new PostsViewHolder(view);
        }



    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        int itemType = holder.getItemViewType();


        if(position != 0){


            if (itemType == 2 && qoutes.get(position) != null) {

                    mp = MediaPlayer.create(context, R.raw.woosh);
                    vibe = (Vibrator) context.getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    Typeface face = Typeface.createFromAsset(context.getAssets(),
                            "fonts/reqaa-Regular.ttf");
                    ((PostsViewHolder) holder).qoute.setTypeface(face);
                    String x = qoutes.get(position).getText();
                    String my_new_str = x.replaceAll("[A-Za-z0-9!@#$.//__:%^&*]", "");

                    if (qoutes.get(position).extendedEntities != null) {
                        Glide.with(context)
                                .load(qoutes.get(position).getExtendedEntities().getMedia().get(0).getMediaUrl())
                                .into(((PostsViewHolder) holder).thumbnail);
                    }
                    is_Liked(position, ((PostsViewHolder) holder));

                    ((PostsViewHolder) holder).qoute.setText(my_new_str);
                    ((PostsViewHolder) holder).seen_count.setText(qoutes.get(position).getRetweetCount());

                    ((PostsViewHolder) holder).like_button.setLiked(false);
                    ((PostsViewHolder) holder).share_button.setLiked(false);
                    ((PostsViewHolder) holder).like_button.setOnLikeListener(new OnLikeListener() {
                        @Override
                        public void liked(LikeButton likeButton) {
                            Toast.makeText(context, "Liked!", Toast.LENGTH_SHORT).show();
                            vibe.vibrate(30);
                            ((PostsViewHolder) holder).favourit_count.setText(String.valueOf(Integer.parseInt(((PostsViewHolder) holder).favourit_count.getText().toString()) + 1));
                            mp.start();
                        }

                        @Override
                        public void unLiked(LikeButton likeButton) {
                            Toast.makeText(context, "disliked", Toast.LENGTH_SHORT).show();
                            vibe.vibrate(10);
                            ((PostsViewHolder) holder).favourit_count.setText(String.valueOf(Integer.parseInt(((PostsViewHolder) holder).favourit_count.getText().toString()) - 1));
                        }
                    });

                    ((PostsViewHolder) holder).share_button.setOnLikeListener(new OnLikeListener() {
                        @Override
                        public void liked(LikeButton likeButton) {
                            Toast.makeText(context, "Liked!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT, "your massage\n\n\n Google play Acount");
                            context.startActivity(Intent.createChooser(intent, "Share fuck"));
                            vibe.vibrate(100);
                            mp.start();
                        }

                        @Override
                        public void unLiked(LikeButton likeButton) {
                            Toast.makeText(context, "disliked", Toast.LENGTH_SHORT).show();
                        }
                    });

            }else if(itemType ==1&& reemList.get(position) != null)
            {

                    ((SimpleText)holder).Reem_post.setText(reemList.get(position).getText());
            }
        }




    }
    public void is_Liked(int position,final PostsViewHolder holder)
    {
        if (qoutes.get(position).retweetedStatus != null) {


            holder.favourit_count.setText(qoutes.get(position).getRetweetedStatus().getFavorite_count());

        } else {
            holder.favourit_count.setText(qoutes.get(position).getFavoriteCount());
        }
    }



    @Override
    public int getItemCount() {

        return qoutes.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        } else if ((position%2)==0){
            return 1;
        }else {
            return 2;
        }
    }
    public class PostsViewHolder extends RecyclerView.ViewHolder {

        public TextView qoute, favourit_count, seen_count;
        public ImageView thumbnail;
        public LikeButton like_button,share_button;
        View itemView;

        public PostsViewHolder(final View itemView) {
            super(itemView);
            this.itemView = itemView;

            qoute = itemView.findViewById(R.id.qoutes);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            favourit_count = itemView.findViewById(R.id.favourit);
            seen_count = itemView.findViewById(R.id.seen_count);

            like_button = (LikeButton) itemView.findViewById(R.id.like_button);
            share_button = (LikeButton) itemView.findViewById(R.id.share);

        }
    }





    public  class SimpleText extends RecyclerView.ViewHolder {
        public TextView Reem_post;

        public SimpleText(View v) {
            super(v);
            this.Reem_post = (TextView) v.findViewById(R.id.Reem_post);
        }
    }

}