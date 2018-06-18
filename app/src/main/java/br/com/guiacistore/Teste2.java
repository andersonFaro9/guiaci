package br.com.guiacistore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Teste2 extends AppCompatActivity {
    TextView Title, Message;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                if (key.equals("title")) {
                    Title.setText(getIntent().getExtras().getString(key));
                }
                else if (key.equals("messagem")) {
                    Message.setText(getIntent().getExtras().getString(key));
                }
            }
        }
    }
}
