package khanhdang.ueh.edu.vn.btbuoi2_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        textView= findViewById(R.id.textView);
        String value = getIntent().getStringExtra("value");
        textView.setText(value);
    }
}