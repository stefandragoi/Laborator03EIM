package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneDialerActivity extends AppCompatActivity {

    private EditText EditText;
    private Button digitButton;
    private Button bspaceButton;
    private Button callButton;
    private Button endButton;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText.setText(EditText.getText().toString() + ((Button)view).getText().toString());
        }
    }

    private BspaceClickListener bspaceClickListener = new BspaceClickListener();
    private class BspaceClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String oldNumber = EditText.getText().toString();
            if (oldNumber.length() > 0) {
                String newNumber = oldNumber.substring(0, oldNumber.length() - 1);
                EditText.setText(newNumber);
            }
        }
    }

    private CallClickListener callClickListener = new CallClickListener();
    private class CallClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        PhoneDialerActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + EditText.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private EndClickListener endClickListener = new EndClickListener();
    private class EndClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText.setText(EditText.getText().toString() + ((Button)view).getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        EditText = (EditText)findViewById(R.id.editText);

        bspaceButton = (Button)findViewById(R.id.b_button);
        bspaceButton.setOnClickListener(bspaceClickListener);

        callButton = (Button)findViewById(R.id.c_button);
        callButton.setOnClickListener(callClickListener);

        endButton = (Button)findViewById(R.id.e_button);
        endButton.setOnClickListener(endClickListener);

        digitButton = (Button)findViewById(R.id.number_0_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_1_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_2_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_3_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_4_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_5_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_6_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_7_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_8_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_9_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.number_0_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.s_button);
        digitButton.setOnClickListener(genericButtonClickListener);

        digitButton = (Button)findViewById(R.id.d_button);
        digitButton.setOnClickListener(genericButtonClickListener);
    }
}
