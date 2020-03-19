package com.nuc.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

public class CityChooseActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private String[] province = {"山西", "山东", "河北", "河南"};
    private String[][] cities = {{"太原", "大同", "长治"}, {"济南", "青岛", "淄博"},
            {"石家庄"}, {"郑州"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_choose);

        expandableListView = findViewById(R.id.expandableList);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putString("city", province[groupPosition] + "/" + cities[groupPosition][childPosition]);
                intent.putExtras(bundle);
                setResult(0, intent);
                finish();
                return false;
            }
        });

        expandableListView.setAdapter(new ExpandableListAdapter(
                this, province, cities));

    }
}
