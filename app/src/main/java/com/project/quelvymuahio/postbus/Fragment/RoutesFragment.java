package com.project.quelvymuahio.postbus.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.quelvymuahio.postbus.Adapter.TicketAdapter;
import com.project.quelvymuahio.postbus.Model.Bilhete;
import com.project.quelvymuahio.postbus.Model.CarModel;
import com.project.quelvymuahio.postbus.Model.Carro;
import com.project.quelvymuahio.postbus.Model.Rota;
import com.project.quelvymuahio.postbus.Model.RouteModel;
import com.project.quelvymuahio.postbus.Model.Ticket;
import com.project.quelvymuahio.postbus.Model.TicketModel;
import com.project.quelvymuahio.postbus.R;

import java.util.ArrayList;
import java.util.List;

public class RoutesFragment extends Fragment {

    private RecyclerView recyclerView;
    private TicketAdapter ticketAdapter;

    private List<TicketModel> ticketsList;
    private List<Ticket> list;
    private List<Bilhete> listaBilhetes;
    private List<Carro> listaCarros;
    private List<Rota> listaRotas;
    private DatabaseReference mDatabaseRef;

    public RoutesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_routes, container, false);

        ticketsList = new ArrayList<>();
        list = new ArrayList<>();
        listaBilhetes = new ArrayList<>();
        listaCarros = new ArrayList<>();
        listaRotas = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        addDataToList();

        //addDataToTheRecycleView(ticketsList);

        ticketAdapter = new TicketAdapter(getContext(), list);
        recyclerView.setAdapter(ticketAdapter);

        return view;
    }

    private void addDataToList() {

        //listaCarros.clear();
        //listaBilhetes.clear();
        //listaRotas.clear();
        list.clear();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("bilhete");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //Bilhete bilhete = snapshot.getValue(Bilhete.class);
                    //listaBilhetes.add(bilhete);
                    Ticket ticket = snapshot.getValue(Ticket.class);
                    list.add(ticket);
                    Toast.makeText(getContext(), ticket.getBilhete_id() +" - " + ticket.getBilhete_estado(), Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(getContext(), "Tamanho da lista: "+list.size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        /*mDatabaseRef = FirebaseDatabase.getInstance().getReference("rota");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Rota rota = snapshot.getValue(Rota.class);
                    listaRotas.add(rota);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("carro");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Carro carro = snapshot.getValue(Carro.class);
                    listaCarros.add(carro);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });*/
    }

    private void addDataToTheRecycleView(List<TicketModel> ticketsList) {
        ticketsList.clear();
        for (Bilhete bilhete : listaBilhetes) {

            CarModel carModel = new CarModel();
            RouteModel routeModel = new RouteModel();

            for (Carro carro : listaCarros) {

                if (!carro.getCarro_id().equals(bilhete.getBilhete_autocarro_id())){
                    continue;
                }

                carModel = new CarModel(carro.getCarro_id(), carro.getCarro_motorista(), carro.getCarro_imagem_url(), carro.getCarro_assentos(), carro.getCarro_matricula());
            }

            for (Rota rota : listaRotas) {

                if (!bilhete.getBilhete_rota_id().equals(rota.getRota_id())){
                    continue;
                }
                routeModel = new RouteModel(rota.getRota_id(), carModel, rota.getRota_nome(), rota.getRota_distancia());
            }

            ticketsList.add(new TicketModel(bilhete.getBilhete_id(), bilhete.getBilhete_total(), bilhete.getBilhete_data_partida(), bilhete.getBilhete_data_chegada(), bilhete.getBilhete_preco(), bilhete.getBilhete_hora_partida(), bilhete.getBilhete_hora_chegada(), bilhete.getBilhete_estado(), routeModel));

        }

    }

}
