package com.example.assignmentmad_01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public  class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private final ArrayList<Contact> mContactList;
    private OnItemClickListener mListener;

    public ContactAdapter(ArrayList<Contact> dataList) {

        mContactList = dataList;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView0;
        public TextView mTextView1;
        public TextView mTextView2;

        public ContactViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView0 = itemView.findViewById(R.id.textView);
            //mTextView1 = itemView.findViewById(R.id.textView2);
            //  mTextView2 = itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        return new ContactViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact currentItem = mContactList.get(position);

        holder.mTextView0.setText(currentItem.getName());
       // holder.mTextView1.setText(currentItem.getMail());
      //  holder.mTextView2.setText(currentItem.getPhone());
    }

    @Override
    public int getItemCount(){
        if(mContactList != null) {
            System.out.println("In side=========================================");
            return mContactList.size();
        }
        System.out.println("out side==============================================");
        return 0;
    }

}
