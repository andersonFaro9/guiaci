package br.com.guiacistore.lojas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

import br.com.guiacistore.StorageActivity;

public class Teste extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void show (Map<String, String> dados) {

        Intent intent = new Intent(this, StorageActivity.class);
        Bundle bundle = new Bundle();

        for (String key: dados.keySet()) {
            String valor = dados.get(key).toString();
            bundle.putString(key,valor);

        }

        intent.putExtras(bundle);
    }
}
