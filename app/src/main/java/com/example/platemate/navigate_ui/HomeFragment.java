package com.example.platemate.navigate_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platemate.R;
import com.example.platemate.adapters.HomeHorizontalAdapter;
import com.example.platemate.adapters.HomeVerticalAdapter;
import com.example.platemate.adapters.VerticalDetails;
import com.example.platemate.models.HomeHorizontalModel;
import com.example.platemate.models.HomeVerticalModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements VerticalDetails {
    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorizontalModel> homeHorizontalModelList;
    HomeHorizontalAdapter homeHorizontalAdapter;
    ArrayList<HomeVerticalModel> homeVerticalModelList;
    HomeVerticalAdapter homeVerticalAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);


        homeHorizontalModelList = new ArrayList<>();
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.burger, "Burgers"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.italian, "Italian"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.asian, "Asian"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.vegetarian, "Vegetarian"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.coffee, "Coffee"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.desserts, "Desserts"));

        homeHorizontalAdapter = new HomeHorizontalAdapter(this, getActivity(), homeHorizontalModelList);
        homeHorizontalRec.setAdapter(homeHorizontalAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        homeVerticalModelList = new ArrayList<>();

        homeVerticalAdapter = new HomeVerticalAdapter(getActivity(), homeVerticalModelList);
        homeVerticalRec.setAdapter(homeVerticalAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        return root;
    }

    @Override
    public void retriever(int position, ArrayList<HomeVerticalModel> list) {
        homeVerticalAdapter = new HomeVerticalAdapter(getActivity(), list);
        homeVerticalAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerticalAdapter);
    }
}