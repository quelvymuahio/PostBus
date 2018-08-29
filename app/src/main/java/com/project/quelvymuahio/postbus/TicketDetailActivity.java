package com.project.quelvymuahio.postbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicketDetailActivity extends AppCompatActivity {

    private String routeName = "";
    private String preco = "";
    private String data_partida = "";
    private String hora_partida = "";
    String bilhetes, estado, data_chegada,  hora_chegada, partida;
    String destino, distancia, motorista, matricula, assentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TextView ticket_price = (TextView) findViewById(R.id.ticket_price);
        TextView tickets_available = (TextView) findViewById(R.id.tickets_available);
        TextView tickets_status = (TextView) findViewById(R.id.tickets_status);
        TextView tickets_departue_date = (TextView) findViewById(R.id.tickets_departue_date);
        TextView tickets_departue_hour = (TextView) findViewById(R.id.tickets_departue_hour);
        TextView tickets_arrival_date = (TextView) findViewById(R.id.tickets_arrival_date);
        TextView tickets_arrival_hour = (TextView) findViewById(R.id.tickets_arrival_hour);
        TextView route_departure = (TextView) findViewById(R.id.route_departure);
        TextView route_arrival = (TextView) findViewById(R.id.route_arrival);
        TextView route_distance = (TextView) findViewById(R.id.route_distance);
        TextView car_driver = (TextView) findViewById(R.id.car_driver);
        TextView car_registration = (TextView) findViewById(R.id.car_registration);
        TextView car_seatingSeats = (TextView) findViewById(R.id.car_seatingSeats);

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            routeName = (String) bundle.get("routeName");
            preco = (String) bundle.get("preco");
            bilhetes = (String) bundle.get("bilhetes");
            estado = (String) bundle.get("estado");
            data_partida = (String) bundle.get("data_partida");
            data_chegada = (String) bundle.get("data_chegada");
            hora_partida = (String) bundle.get("hora_partida");
            hora_chegada = (String) bundle.get("hora_chegada");
            partida = (String) bundle.get("partida");
            destino = (String) bundle.get("destino");
            distancia = (String) bundle.get("distancia");
            motorista = (String) bundle.get("motorista");
            matricula = (String) bundle.get("matricula");
            assentos = (String) bundle.get("assentos");

            ticket_price.setText(preco);
            tickets_available.setText(bilhetes);
            tickets_status.setText(estado);
            tickets_departue_date.setText(data_partida);
            tickets_arrival_date.setText(data_chegada);
            tickets_departue_hour.setText(hora_partida);
            tickets_arrival_hour.setText(hora_chegada);
            route_departure.setText(partida);
            route_arrival.setText(destino);
            route_distance.setText(distancia);
            car_driver.setText(motorista);
            car_registration.setText(matricula);
            car_seatingSeats.setText(assentos);

            CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

            getSupportActionBar().setTitle((String) bundle.get("routeName"));
            toolbarLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.map));
            toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        }

        Button buyTicket = (Button) findViewById(R.id.buy_ticket_btn);
        buyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketDetailActivity.this, BuyTicketActivity.class );
                intent.putExtra("rota", routeName);
                intent.putExtra("preco", preco);
                intent.putExtra("data", data_partida);
                intent.putExtra("hora", hora_partida);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                startActivity(new Intent(TicketDetailActivity.this, PostBus.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}