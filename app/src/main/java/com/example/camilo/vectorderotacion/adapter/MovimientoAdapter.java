package com.example.camilo.vectorderotacion.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.camilo.vectorderotacion.databinding.TemplateMovimientoBinding;
import com.example.camilo.vectorderotacion.models.Movimiento;

import java.util.List;

/**
 * Created by camilo on 08/04/2017.
 */
public class MovimientoAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<Movimiento> data;

    public MovimientoAdapter(LayoutInflater layoutInflater, List<Movimiento> data) {
        this.layoutInflater = layoutInflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        TemplateMovimientoBinding binding = TemplateMovimientoBinding.inflate(layoutInflater);
        binding.setMovimiento(data.get(position));

        return binding.getRoot();
    }
}
