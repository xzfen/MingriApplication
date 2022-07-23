package com.fxz.recyclerviewtest;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

public class StaggerAdapter extends RecyclerViewBaseAdapter{
    public StaggerAdapter(List<Contact> contactList) {
        super(contactList);
    }

    @Override
    protected View getSubView(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.stagger_view_item, null);
        return view;
    }
}
