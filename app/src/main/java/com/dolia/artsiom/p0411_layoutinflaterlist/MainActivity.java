package com.dolia.artsiom.p0411_layoutinflaterlist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    final String LOG_TAG = "myLog";

    String[] names = { "John", "Mary", "Peter", "Antony", "Pit", "Chris", "Greg"};
    String[] positions = { "Accountant", "Dev", "Dev", "Accountant", "CEO", "Dev", "Guard" };
    int salaries[] = { 130000, 100000, 130000, 100000, 150000, 130000, 80000 };
    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < names.length; i++){
            Log.d(LOG_TAG, "i = " + i);

            View item = ltInflater.inflate(R.layout.item, linLayout, false);

            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(names[i]);

            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Position " + positions[i]);

            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Salary " + String.valueOf(salaries[i]));

            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);

            linLayout.addView(item);
        }
    }
}
