package com.example.lp.myrecyleview.ui.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lp.myrecyleview.R;
import com.example.lp.myrecyleview.adapter.CommonAdapter;
import com.example.lp.myrecyleview.ui.BaseFragment;
import com.example.lp.myrecyleview.ui.DividerItemDecoration;


import java.util.ArrayList;
import java.util.List;

/**
 * lp
 * 2019年3月30日
 * 模仿GridView
 */
public class RecyclerViewFragment_GridView extends BaseFragment {

    private RecyclerView mRecyclerView;
    private List<String> listData;
    private CommonAdapter commonAdapter;

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_recycle_view,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        listData = new ArrayList<String>();

        for (int i = 'A'; i < 'z'; i++) {
            listData.add("" + (char) i);
            listData.add("" + (char) i);
        }

        //设置GridLayoutManager布局管理器，实现GridView效果,每行展示四个item
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,4));
        //添加水平分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.VERTICAL_LIST));
        //添加竖直分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.HORIZONTAL_LIST));
        //设置默认动画，添加addData()或者removeData()时候的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        commonAdapter = new CommonAdapter(mActivity,listData);
        mRecyclerView.setAdapter(commonAdapter);
        commonAdapter.setOnItemClickLitener(new CommonAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                commonAdapter.addData(position,"insert new Data");
            }

            @Override
            public void onItemLongClick(View view, int position) {
                commonAdapter.removeData(position);
            }
        });
    }

}
