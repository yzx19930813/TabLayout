package com.kim_yzx.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MyFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teach, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TeachAdapter(getActivity()));
        return rootView;
    }


    class TeachAdapter extends RecyclerView.Adapter<TeachAdapter.TeachViewHolder> {

        private List<String> data;

        private LayoutInflater inflater;

        public TeachAdapter(Context context) {
            data = new ArrayList<>();
            int i = 0;
            while (i < 50) {
                data.add("测试数据--" + i++);
            }
            inflater = LayoutInflater.from(context);
        }

        @Override
        public TeachViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layout = inflater.inflate(R.layout.item, parent, false);
            return new TeachViewHolder(layout);
        }

        @Override
        public void onBindViewHolder(TeachViewHolder holder, int position) {
            holder.name.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class TeachViewHolder extends RecyclerView.ViewHolder {

            TextView name;

            public TeachViewHolder(View itemView) {
                super(itemView);
                name = ((TextView) itemView.findViewById(R.id.name));
            }
        }
    }

}
