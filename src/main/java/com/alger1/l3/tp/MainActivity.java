package com.alger1.l3.tp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


        EditText emdsec,emdbdd,emdmob,emdinf,tdsec,tdbdd,tdmob,tdinf,tpsec,tpbdd,tpmob,tpinf,emdred;
        TextView ressec,resmob,resinf,resbdd,resred,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Mythem);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emdsec=(EditText)findViewById(R.id.emdsec);
        emdbdd=(EditText)findViewById(R.id.emdbdd);
        emdmob=(EditText)findViewById(R.id.emdmob);
        emdinf=(EditText)findViewById(R.id.emdinf);
        emdred=(EditText)findViewById(R.id.emdred);
        tdsec=(EditText)findViewById(R.id.tdsec);
        tdbdd=(EditText)findViewById(R.id.tdbdd);
        tdmob=(EditText)findViewById(R.id.tdmob);
        tdinf=(EditText)findViewById(R.id.tdinf);
        tpsec=(EditText)findViewById(R.id.tpsec);
        tpbdd=(EditText)findViewById(R.id.tpbdd);
        tpmob=(EditText)findViewById(R.id.tpmob);
        tpinf=(EditText)findViewById(R.id.tpinf);


        ressec=(TextView)findViewById(R.id.ressec) ;
        resmob=(TextView)findViewById(R.id.resmob) ;
        resinf =(TextView)findViewById(R.id.resinf) ;
        resbdd=(TextView)findViewById(R.id.resbdd) ;
        resred=(TextView)findViewById(R.id.resred);

        result=(TextView)findViewById(R.id.result);



    }

        //verifier la valure des champs EditText
    public Double check(EditText ed){
         Double edt;
        if(ed.getText().toString().isEmpty()) edt=0.0;
        else  edt = Double.parseDouble(ed.getText().toString());

            return edt;
    }
    public void  calc(View v){
        Button btn=(Button)findViewById(R.id.btn);
        //TextView result=(TextView)findViewById(R.id.result) ;



        // sécurite
        Double emd1=check(emdsec);
       Double tp1=check(tdsec);

        Double sum1=2*emd1;
        Double  msec = (tp1+sum1)/3;
        //ressec.setText(Double.toString(msec));
        ressec.setText(new DecimalFormat("##.##").format(msec).toString());

        //application mobile
        Double emd2 = check(emdmob);
        Double tp2 = check(tpmob);
        Double td2 = check(tdmob);
        Double  sum2 = (tp2 + td2)/2;
        Double ssum2=2 * emd2;
        Double  mmob = (sum2+ssum2)/3;
        resmob.setText(new DecimalFormat("##.##").format(mmob).toString());
                //(Double.toString(mmob));


        //Bdd
        Double emd3 = check(emdbdd);
        Double td3 = check(tpbdd);
        Double sum3= 2*emd3;
        Double  mbdd = (sum3+td3)/3;
        resbdd.setText(new DecimalFormat("##.##").format(mbdd).toString());
                //(Double.toString(mbdd));

        //Infographie
        Double emd4 = check(emdinf);
        Double tp4 = check(tdinf);
        Double sum4=2*emd4;
        Double  minf = (sum4+tp4)/3;
        resinf.setText(new DecimalFormat("##.##").format(minf).toString());
                //(Double.toString(minf));

        //redaction
        Double mred=check(emdred);
        resred.setText(new DecimalFormat("##.##").format(mred).toString());
                //(emdred.getText().toString());



            /* *********************moyenne generale *********** */

            Double moyenne =((msec*3)+(mmob*3)+(mbdd*2)+(minf*2)+mred)/11;

            result.setText(new DecimalFormat("##.##").format(moyenne).toString());
            Toast t1;
            if(moyenne>10.00){
                t1=Toast.makeText(this,"Admis",Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.BOTTOM,0,0);
                t1.show();
            }else {
               t1= Toast.makeText(this, "Ajour ", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.BOTTOM, 0, 0);
                t1.show();
            }


    }

    public void efac(View view) {
        emdsec.getText().clear(); tdsec.getText().clear(); ressec.setText("");
        emdmob.getText().clear(); tpmob.getText().clear(); tdmob.getText().clear(); resmob.setText("");
        emdbdd.getText().clear(); tpbdd.getText().clear(); resbdd.setText("");
        emdinf.getText().clear(); tdinf.getText().clear(); resinf.setText("");
        emdred.getText().clear();  resred.setText("");

        result.setText("");

    }
    /*
    @Override
    public void onBackPressed() {
         AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Fermer L'application<")
                .setMessage("Voulez-vous vraiment quitter l'application?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       MainActivity.super.onBackPressed();
                    }

                })
                .setNegativeButton("Non", null).setCancelable(false);

                AlertDialog alert=builder.create();
                alert.show();
    }*/
}

