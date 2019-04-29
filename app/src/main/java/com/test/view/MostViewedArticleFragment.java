package com.test.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.R;
import com.test.view.adapters.MostViewedArticleAdapter;
import com.test.view.listener.FragmentListener;
import com.test.view.listener.RecyclerViewListener;
import com.test.view.pojo.ArticleListPojo;
import com.test.viewmodel.ArticleViewModel;

import java.util.List;

public class MostViewedArticleFragment extends Fragment implements RecyclerViewListener {

    private RecyclerView mRecylerView;
    private MainActivity mMainActivity;
    private MostViewedArticleAdapter mMostViewedArticleAdapter;
    private FragmentListener mFragmentListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mMainActivity = (MainActivity) context;
            mFragmentListener = (FragmentListener) context;
        } catch (ClassCastException e) {
            Log.e("Exception", e.getMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_most_viewed_article, null);
        mRecylerView = rootView.findViewById(R.id.article_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mMainActivity);
        mRecylerView.setLayoutManager(layoutManager);
        mRecylerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }


    private void setAdapter(List<ArticleListPojo.ArticlePojo> articleList) {
        if (mMostViewedArticleAdapter == null) {
            mMostViewedArticleAdapter = new MostViewedArticleAdapter(articleList, this);
            mRecylerView.setAdapter(mMostViewedArticleAdapter);
        } else {
            mMostViewedArticleAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArticleViewModel viewModel = ViewModelProviders.of(mMainActivity).
                get(ArticleViewModel.class);

        observeViewModel(viewModel);
    }


    private void observeViewModel(ArticleViewModel articleViewModel) {
        articleViewModel.getArticleListLiveData().observe(this,
                new Observer<ArticleListPojo>() {
                    @Override
                    public void onChanged(@Nullable ArticleListPojo articleListPojo) {
                        if (articleListPojo != null) {
                            setAdapter(articleListPojo.getArticleList());
                        }
                    }
                });
    }

    @Override
    public void onItemClicked(final int position) {
        mFragmentListener.onItemClick(position);
    }
}
