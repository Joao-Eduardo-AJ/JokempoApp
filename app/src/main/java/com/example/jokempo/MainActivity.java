package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int escolhaDoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        opcaoSelecionada(0);
    }

    public void selecionarPapel(View view) {
        opcaoSelecionada(1);
    }

    public void selecionarTesoura(View view) {
        opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int user) {
        ImageView imageView = findViewById(R.id.result);
        TextView textView = findViewById(R.id.textResult);
        int bot = this.escolhaDoApp;

        int opcaoSelecionada = new Random().nextInt(3);
        this.escolhaDoApp = opcaoSelecionada;

       switch (bot) {
           case 0: {
                imageView.setImageResource(R.drawable.pedra);
               break;
           }
           case 1: {
               imageView.setImageResource(R.drawable.papel);
               break;
           }
           default: {
               imageView.setImageResource(R.drawable.tesoura);
           }
       }

        if((user == 0 && bot == 1) || (user == 1 && bot == 2) || (user == 2 && bot == 0)) {
            textView.setText("Você perdeu!");
        } else if ((bot == 0 && user == 1) || (bot == 1 && user == 2) || (bot == 2 && user == 0)) {
            textView.setText("Você ganhou!");
        } else {
            textView.setText("Empatou!");
        }
    }

    public int getEscolhaDoApp() {
        return escolhaDoApp;
    }

    public void setEscolhaDoApp(int escolhaDoApp) {
        this.escolhaDoApp = escolhaDoApp;
    }
}