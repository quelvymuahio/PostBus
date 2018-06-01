package com.project.quelvymuahio.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.quelvymuahio.myapplication.Model.TicketModel;
import com.project.quelvymuahio.myapplication.R;
import com.project.quelvymuahio.myapplication.TicketDetailActivity;
import com.project.quelvymuahio.myapplication.ViewHolder.TicketHolder;

import java.util.Date;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketHolder> {

    private Context context;
    private List<TicketModel> ticketsList;

    public TicketAdapter(Context context, List<TicketModel> ticketsList) {
        this.context = context;
        this.ticketsList = ticketsList;
    }

    @NonNull
    @Override
    public TicketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_support, null);
        return new TicketHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketHolder holder, int position) {
        TicketModel ticketModel = ticketsList.get(position);

        final int image = ticketModel.getRoute().getCar().getImage();
        final String routeName = ticketModel.getRoute().getName(), price = ticketModel.getPrice();
        final Integer availableTickets = ticketModel.getAvailableTickets();
        final Date date = ticketModel.getDepartueDate();
        Drawable drawableImage = context.getResources().getDrawable(image);

        holder.imageView.setImageDrawable(drawableImage);
        holder.name.setText(routeName);
        holder.price.setText(price + " MT");
        holder.availableTicket.setText(availableTickets +" Bilhetes");
        holder.date.setText(date.getDay()+"/"+date.getMonth()+"/"+date.getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, TicketDetailActivity.class);
                //intent.putExtra("image", image);
                intent.putExtra("routeName", routeName);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return ticketsList.size();
    }
}
