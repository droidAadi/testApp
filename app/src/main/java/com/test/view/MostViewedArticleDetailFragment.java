package com.test.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.R;
import com.test.view.pojo.ArticleListPojo;
import com.test.viewmodel.ArticleViewModel;

public class MostViewedArticleDetailFragment extends Fragment {

    private MainActivity mMainActivity;
    private TextView mTitleTextView;
    private TextView mAbstractTextView;
    private TextView mSourceView;
    private TextView mDateTextView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mMainActivity = (MainActivity) context;
        } catch (ClassCastException e) {
            Log.e("Exception", e.getMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_most_viewed_article_detail, null);
        mTitleTextView = rootView.findViewById(R.id.title);
        mAbstractTextView = rootView.findViewById(R.id.abstract_text);
        mSourceView = rootView.findViewById(R.id.source);
        mDateTextView = rootView.findViewById(R.id.date);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        observerViewModel(position);
    }

    private void observerViewModel(int position){
        final ArticleViewModel viewModel = ViewModelProviders.of(mMainActivity).
                get(ArticleViewModel.class);
        viewModel.getArticlePojoLiveData(position).observe(this, new Observer<ArticleListPojo.ArticlePojo>() {
            @Override
            public void onChanged(@Nullable ArticleListPojo.ArticlePojo article) {
                if(article != null){
                    mTitleTextView.setText(article.getTitle());
                    mAbstractTextView.setText(article.getAbstract());
                    mSourceView.setText(article.getByLine());
                    mDateTextView.setText(article.getPublishedDate());
                }
            }
        });
    }
}
