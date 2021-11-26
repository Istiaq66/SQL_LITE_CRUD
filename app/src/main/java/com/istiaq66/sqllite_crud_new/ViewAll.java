package com.istiaq66.sqllite_crud_new;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class ViewAll extends AppCompatActivity {

    ListView list;
    public ArrayAdapter<String> adapter;
    ArrayList<String> tempList1;
    //String name,email;
    UserFunctions userFunction;

    ArrayList<CustomList> listCampaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_listview);


        userFunction = new UserFunctions();
        list = (ListView) findViewById(R.id.listView1);

          //-----------section-1
        showDataAtListView();
        //-----------section-1

        //-------------------------add button

       ImageButton btnAdd=(ImageButton)findViewById(R.id.btnAddd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getBaseContext(), Insert.class);
                startActivity(i);



            }
        });
        //-------------------------add button



        //----------------------setion-2
        datapassing();


        //----------------------setion-2


    } //slb




    //-------------- //-----------section-1-------------------------------

    public void showDataAtListView() {

        //asa();

        tempList1 = new ArrayList<String>();

        // for campaign
        listCampaign = userFunction.getAllInfo(getApplicationContext());


        for (int i = 0; i < listCampaign.size(); i++) {

            if (!listCampaign.get(i).getStrName().isEmpty())
            {
                tempList1.add("ID:"+listCampaign.get(i).getStrId()+", " +
                          "Name:"+listCampaign.get(i).getStrName()+"," +
                          "Mobile:"+listCampaign.get(i).getStrMobile());

            }
        }


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tempList1);
        list.setAdapter(adapter);

    }

    //-----------section-1







    @Override
    protected void onStart() {
        super.onStart();
        //asa();
    }




    //-------------------------------section 2--

    public void datapassing()

    {


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
//				Toast.makeText(getBaseContext(), tempList1.get(arg2),
//					Toast.LENGTH_SHORT).show();

                StringTokenizer str=new StringTokenizer(tempList1.get(arg2),":,");
                String str1=str.nextToken();
                String str2=str.nextToken();
                String str3=str.nextToken();
                String str4=str.nextToken();
                String str5=str.nextToken();
                String str6=str.nextToken();





                String id=str2;
                String name=str4;
                String mobile=str6;


                Intent intent1 = new Intent();
                intent1.setClass(getApplicationContext(),EditDeleteMainSms.class);
                Bundle b = new Bundle();
                b.putString("id", id);
                b.putString("name", name);
                b.putString("mobile1", mobile);



                intent1.putExtras(b);
                startActivity(intent1);
                finish();





            }
        });
    }





}