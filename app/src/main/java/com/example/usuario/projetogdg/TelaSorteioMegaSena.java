package com.example.usuario.projetogdg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Random;

public class TelaSorteioMegaSena extends AppCompatActivity implements View.OnClickListener {

    private ListView listaSorteio;
    private ImageButton gerarSorteio;
    private ArrayAdapter<String> adpLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sorteio_mega_sena);

        gerarSorteio = (ImageButton) findViewById(R.id.gerarSorteio);
        listaSorteio = (ListView) findViewById(R.id.sorteios_list_view);

        gerarSorteio.setOnClickListener(this);

        adpLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listaSorteio.setAdapter(adpLista);
    }

    @Override
    public void onClick(View v) {

        TextView num1 = (TextView) findViewById(R.id.num1_text_view);
        TextView num2 = (TextView) findViewById(R.id.num2_text_view);
        TextView num3 = (TextView) findViewById(R.id.num3_text_view);
        TextView num4 = (TextView) findViewById(R.id.num4_text_view);
        TextView num5 = (TextView) findViewById(R.id.num5_text_view);
        TextView num6 = (TextView) findViewById(R.id.num6_text_view);

        Random r = new Random();

        final int[] sorteio = new int[6];

        for (int i = 0; i < 6; ) {

            boolean encontrou = false;

            int valor = r.nextInt(60) + 1;

            for (int j = 0; j < sorteio.length; j++) {

                if (sorteio[j] == valor) {
                    encontrou = true;
                    break;
                }
            }

            if (encontrou == false) {
                sorteio[i] = valor;
                i++;
            }
        }

        Arrays.sort(sorteio);

        num1.setText(String.valueOf(sorteio[0]));
        num2.setText(String.valueOf(sorteio[1]));
        num3.setText(String.valueOf(sorteio[2]));
        num4.setText(String.valueOf(sorteio[3]));
        num5.setText(String.valueOf(sorteio[4]));
        num6.setText(String.valueOf(sorteio[5]));

        String itemLista = "";

        for (int i = 0; i < sorteio.length; i++) {
            itemLista += sorteio[i] + "   ";
        }

        adpLista.add(itemLista);
    }
}
