package com.example.toshiba.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toshiba.alertatsunami.R;
import com.example.toshiba.bean.TremorBean;

import java.util.ArrayList;

/**
 * Created by cris_ on 24/11/2017.
 */

public class CardView_Adapter_Alarma extends RecyclerView.Adapter<CardView_Adapter_Alarma.ViewHolder_Alertas> {
    ArrayList<TremorBean> listado;
    TremorBean objTremorBean;
    Context context;

    public CardView_Adapter_Alarma(TremorBean obj) {
        objTremorBean = obj;
    }

    public CardView_Adapter_Alarma(ArrayList<TremorBean> lista, Context context1) {
        listado = lista;
        context = context1;
    }

    @Override
    public ViewHolder_Alertas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_alertar, parent, false);
        CardView_Adapter_Alarma.ViewHolder_Alertas viewHolder = new CardView_Adapter_Alarma.ViewHolder_Alertas(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder_Alertas holder, int position) {
        holder.txtlugar.setText("LUGAR : " + listado.get(position).getPlace());
        holder.txthora.setText("HORA : " + listado.get(position).getDateTime());
        holder.txtmagnitud.setText("MAGNITUD : " + listado.get(position).getMagnitude());
        holder.txtevaluacion.setText("EVALUACION : " + listado.get(position).getEvaluation());
        holder.txtreporte.setText("REPORTE : " + listado.get(position).getReport());
    }

    @Override
    public int getItemCount() {
        return null != listado ? listado.size() : 0;
    }

    public static class ViewHolder_Alertas extends RecyclerView.ViewHolder {
        public TextView txtlugar;
        public TextView txthora;
        public TextView txtmagnitud;
        public TextView txtevaluacion;
        public TextView txtreporte;
        public CardView cardView;
        public ImageView imagen;

        public ViewHolder_Alertas(View itemView) {
            super(itemView);
            //texto para actualizar
            txtlugar = (TextView) itemView.findViewById(R.id.txttemblor_lugar);
            txthora = (TextView) itemView.findViewById(R.id.txttemblor_hora);
            txtmagnitud = (TextView) itemView.findViewById(R.id.txttemblor_magnitud);
            txtevaluacion = (TextView) itemView.findViewById(R.id.txttemblor_evaluacion);
            txtreporte = (TextView) itemView.findViewById(R.id.txttemblor_reporte);
            cardView = (CardView) itemView.findViewById(R.id.cardview_alerta);
            imagen = (ImageView) itemView.findViewById(R.id.imagenalerta);
        }
    }
}
