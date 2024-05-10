package com.example.barbearia;

import android.graphics.Color;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private int selectedItem = -1;
    private Context context;

    public CustomAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        }

        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(getItem(position));

        // Verifica se o item atual está selecionado e define a cor de fundo
        if (position == selectedItem) {
            textView.setBackgroundColor(context.getResources().getColor(R.color.purple));
            textView.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            textView.setBackgroundColor(Color.TRANSPARENT);
            textView.setTextColor(context.getResources().getColor(R.color.black));
        }

        return view;
    }

    // Define o item selecionado
    public void setSelectedItem(int position) {
        selectedItem = position;
        notifyDataSetChanged();
    }
}
