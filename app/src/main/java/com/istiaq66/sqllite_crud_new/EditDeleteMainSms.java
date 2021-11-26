package com.istiaq66.sqllite_crud_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class EditDeleteMainSms extends AppCompatActivity {

    String id,name,email,desg,mobile,fax,office;
    UserFunctions userfunction;

    DBAdapter_up_del db=new DBAdapter_up_del(EditDeleteMainSms.this);  ///here user function add.....



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_delete);

        userfunction=new UserFunctions();

        final EditText tx1d=(EditText)findViewById(R.id.txtId);
        final EditText txtn=(EditText)findViewById(R.id.txtname);
        final EditText txtm=(EditText)findViewById(R.id.txtmobilee);



        ImageButton btnEdit=(ImageButton)findViewById(R.id.btnEditt);
        ImageButton btndelete=(ImageButton)findViewById(R.id.btndeletee);




        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        name = b.getString("name");
        mobile=b.getString("mobile1");



        tx1d.setText(id);
        txtn.setText(name);
        txtm.setText(mobile);



















        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendSMS(txt3.getText().toString(), txt4.getText().toString());
                db.open();
                if (db.deleteMisContact(Integer.parseInt(tx1d.getText().toString()))){
                    Toast.makeText(getBaseContext(), "Delete successful.", Toast.LENGTH_LONG)
                            .show();

                }
                else{
                    Toast.makeText(getBaseContext(), "Delete failed.", Toast.LENGTH_LONG).show();

                }db.close();

                finish();
//
                Intent intent=new Intent(getApplicationContext(), ViewAll.class);
                startActivity(intent);

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.open();
                if (db.updateMisContact(Integer.parseInt(tx1d.getText().toString()),
                        txtn.getText().toString(),
                        txtm.getText().toString()
                        ))
                    Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();
                db.close();

                finish();

                Intent intent=new Intent(getApplicationContext(), ViewAll.class);
                startActivity(intent);

            }
        });





    }

}
