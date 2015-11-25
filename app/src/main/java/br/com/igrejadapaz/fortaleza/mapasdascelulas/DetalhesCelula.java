package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;

public class DetalhesCelula extends AppCompatActivity {

    private CelulaBean celulaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_celula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        celulaSelecionada = getIntent().getExtras().getParcelable("celulaSelecionada");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesCelula.this, MapsCelulas.class);
                Bundle parametros = new Bundle();
                parametros.putString("filtroDia", "9");
                parametros.putString("filtroTipo", "9");
                intent.putExtras(parametros);
                intent.putExtra("celulaSelecionada", (Parcelable) celulaSelecionada);
                startActivity(intent);

            }
        });


        TextView nome = (TextView) findViewById(R.id.textViewNome);
        nome.setText(celulaSelecionada.getNome());
        TextView endereco = (TextView) findViewById(R.id.textViewEndereco);
        endereco.setText(celulaSelecionada.getEndereco());
        TextView lider = (TextView) findViewById(R.id.textViewNomeLider);
        lider.setText(celulaSelecionada.getLiderNome());
        TextView telefone = (TextView) findViewById(R.id.textViewTelefone);
        telefone.setText(celulaSelecionada.getTelefoneInformacao());
        TextView rede = (TextView) findViewById(R.id.textViewRede);
        rede.setText(celulaSelecionada.getRede());
        TextView dia = (TextView) findViewById(R.id.textViewDiaHora);
        dia.setText(celulaSelecionada.getDiaHora());
        TextView tipo = (TextView) findViewById(R.id.textViewTipo);
        tipo.setText(celulaSelecionada.getTipo());


    }

    public void ligar(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: " + celulaSelecionada.getTelefoneInformacao()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void whatsapp(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, " " + celulaSelecionada.getNome() + " " + celulaSelecionada.getEndereco());
        sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, celulaSelecionada.getTelefoneInformacao());
        sendIntent.setData(Uri.parse("sms: " + celulaSelecionada.getTelefoneInformacao()));
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }
}
