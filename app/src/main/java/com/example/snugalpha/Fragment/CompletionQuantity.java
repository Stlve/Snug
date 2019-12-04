package com.example.snugalpha.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snugalpha.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class CompletionQuantity extends Fragment {

    private View view;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.completion_quantity,container,false);
        mContext = view.getContext();

        GraphView graph = (GraphView) view.findViewById(R.id.completion_quantity_graph);
        initGraph(graph);

        return view;
    }

    public void initGraph(GraphView graph) {

        DataPoint[] points = new DataPoint[50];
        for (int i = 0; i < 50; i++) {
            points[i] = new DataPoint(i, (int)(1+Math.random()*(10-1+1)));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);

        // enable scrolling
        graph.getViewport().setScrollable(true);

//        series.setTitle("Random Curve");

        graph.addSeries(series);
//        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(points);
//        series.setSpacing(50); // 50% spacing between bars
//        series.setAnimated(true);
//        series.setDrawValuesOnTop(true);
//        series.setValuesOnTopColor(Color.BLUE);
//        graph.addSeries(series);
//
//        graph.getViewport().setScrollable(true);
//
//
//
//        // set the viewport wider than the data, to have a nice view
//        graph.getViewport().setMinX(0d);
//        graph.getViewport().setMaxX(4d);
//        graph.getViewport().setXAxisBoundsManual(true);
    }

}
