package com.rikin.jain.instagramcloner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave;
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);
        edtName = findViewById(R.id.edtName);
        edtPunchSpeed=findViewById(R.id.edtPunchSpeed);
        edtPunchPower=findViewById(R.id.edtPunchPower);
        edtKickSpeed = findViewById(R.id.edtKickSpeed);
        edtKickPower= findViewById(R.id.edtKickPower);

    }


    @Override
    public void onClick(View v) {
       try {
           final ParseObject kickBoxer = new ParseObject("KickBoxer");
           kickBoxer.put("name", edtName.getText().toString());
           kickBoxer.put("punch_speed", Integer.parseInt(edtPunchSpeed.getText().toString()));
           kickBoxer.put("punch_power", Integer.parseInt(edtPunchPower.getText().toString()));
           kickBoxer.put("kick_speed", Integer.parseInt(edtKickSpeed.getText().toString()));
           kickBoxer.put("kick_power", Integer.parseInt(edtKickPower.getText().toString()));
           kickBoxer.saveInBackground(new SaveCallback() {
               @Override
               public void done(ParseException e) {
                   if (e == null) {
                       FancyToast.makeText(SignUp.this, kickBoxer.get("name") + " is saved successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                   } else {
                       Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               }
           });
       } catch (Exception e){
           FancyToast.makeText(this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

       }

    }
}
