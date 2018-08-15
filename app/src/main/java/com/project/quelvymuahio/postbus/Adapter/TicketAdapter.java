package com.project.quelvymuahio.postbus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.quelvymuahio.postbus.Model.Ticket;
import com.project.quelvymuahio.postbus.Model.TicketModel;
import com.project.quelvymuahio.postbus.R;
import com.project.quelvymuahio.postbus.TicketDetailActivity;
import com.project.quelvymuahio.postbus.ViewHolder.TicketHolder;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketHolder> {

    private Context context;
    private List<TicketModel> ticketsList;
    private List<Ticket> list;

    public TicketAdapter(Context context, List<Ticket> list) {
        this.context = context;
        //this.ticketsList = ticketsList;
        this.list = list;
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
        //TicketModel ticketModel = ticketsList.get(position);
        Ticket ticket = list.get(position);

        /*final String imageUrl = ticketModel.getRoute().getCar().getImageUrl();
        final String routeName = ticketModel.getRoute().getName(), price = ticketModel.getPrice();
        final String availableTickets = ticketModel.getAvailableTickets();
        final String date = ticketModel.getDepartueDate();*/

        final String imageUrl = "https://firebasestorage.googleapis.com/v0/b/postbus-dc2fa.appspot.com/o/imagem_carro%2Fbackground2.jpg%20-%20Fri%20Aug%2010%202018%2012%3A37%3A18%20GMT%2B0200%20(South%20Africa%20Standard%20Time)?alt=media&token=3b904c11-c77f-478b-87d5-d0937900fd67";
        final String routeName = "Maputo - Inhambane";
        final String price = ticket.getBilhete_preco();
        final String availableTickets = ticket.getBilhete_total();
        final String date = ticket.getBilhete_hora_partida();
        //Drawable drawableImage = context.getResources().getDrawable(imageUrl);

        Picasso.with(context).load(imageUrl).into(holder.imageView);
        holder.name.setText(routeName);
        holder.price.setText(price + " MT");
        holder.availableTicket.setText(availableTickets +" Bilhetes");
        holder.date.setText(date);

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

        //return ticketsList.size();
        return list.size();
    }
}
