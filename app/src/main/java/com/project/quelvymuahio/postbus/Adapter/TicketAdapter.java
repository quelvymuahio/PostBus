package com.project.quelvymuahio.postbus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.quelvymuahio.postbus.Model.Bilhete;
import com.project.quelvymuahio.postbus.R;
import com.project.quelvymuahio.postbus.TicketDetailActivity;
import com.project.quelvymuahio.postbus.ViewHolder.TicketHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketHolder> {

    private Context context;
    private List<Bilhete> lista;

    public TicketAdapter(Context context, List<Bilhete> lista) {
        this.context = context;
        this.lista = lista;
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
        final Bilhete bilhete = lista.get(position);

        final String imageUrl = bilhete.getCarro_imagem();
        final String routeName = bilhete.getRota_partida() +" - "+ bilhete.getRota_destino();
        final String price = bilhete.getPreco();
        final String availableTickets = bilhete.getTotal();
        final String date = bilhete.getData_partida();

        Picasso.with(context).load(imageUrl).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.imageView);
        holder.name.setText(routeName);
        holder.price.setText(price + " MT");
        holder.availableTicket.setText(availableTickets +" Bilhetes");
        holder.date.setText(date);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, TicketDetailActivity.class);
                intent.putExtra("rota", routeName);
                intent.putExtra("preco", bilhete.getPreco());
                intent.putExtra("bilhetes", bilhete.getTotal());
                intent.putExtra("estado", bilhete.getEstado());
                intent.putExtra("data_partida", bilhete.getData_partida());
                intent.putExtra("data_chegada", bilhete.getData_chegada());
                intent.putExtra("hora_partida", bilhete.getHora_chegada());
                intent.putExtra("hora_chegada", bilhete.getHora_chegada());
                intent.putExtra("partida", bilhete.getRota_partida());
                intent.putExtra("destino", bilhete.getRota_destino());
                intent.putExtra("distancia", bilhete.getRota_distancia());
                intent.putExtra("motorista", bilhete.getCarro_motorista());
                intent.putExtra("matricula", bilhete.getCarro_matricula());
                intent.putExtra("assentos", bilhete.getCarro_assentos());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return lista.size();
    }
}
