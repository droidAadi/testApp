package com.test.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.test.R;
import com.test.view.listener.RecyclerViewListener;
import com.test.view.pojo.ArticleListPojo;

import java.util.List;

public class MostViewedArticleAdapter extends RecyclerView.Adapter<MostViewedArticleAdapter.ArticleViewHolder> {


    private List<ArticleListPojo.ArticlePojo> mArticleList;
    private RecyclerViewListener mRecyclerViewListener;


    public MostViewedArticleAdapter(List<ArticleListPojo.ArticlePojo> articleList,
                                    RecyclerViewListener recyclerViewListener){
        mArticleList = articleList;
        mRecyclerViewListener = recyclerViewListener;
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_article, viewGroup, false);
        return new ArticleViewHolder(itemView, mRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {

        final ArticleListPojo.ArticlePojo articleListPojo = mArticleList.get(i);
        articleViewHolder.mTitleTextView.setText(articleListPojo.getTitle());
        articleViewHolder.mAuthorTextView.setText(articleListPojo.getByLine());
        articleViewHolder.mDateTextView.setText(articleListPojo.getPublishedDate());
        articleViewHolder.mSourceTextView.setText(articleListPojo.getSource());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        TextView mTitleTextView;
        TextView mAuthorTextView;
        TextView mDateTextView;
        TextView mSourceTextView;
        private RecyclerViewListener mRecyclerViewListener;
        public ArticleViewHolder(@NonNull View itemView, RecyclerViewListener recyclerViewListener) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.title);
            mAuthorTextView = itemView.findViewById(R.id.byline);
            mDateTextView = itemView.findViewById(R.id.date);
            mSourceTextView = itemView.findViewById(R.id.source);
            mRecyclerViewListener = recyclerViewListener;
            itemView.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            mRecyclerViewListener.onItemClicked(getAdapterPosition());
        }
    }
}
