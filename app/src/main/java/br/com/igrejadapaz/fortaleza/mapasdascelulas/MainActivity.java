package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;
import br.com.igrejadapaz.fortaleza.mapasdascelulas.Dao.CelulaDao;

public class MainActivity extends AppCompatActivity {

    private String txtFiltroDia = "0";
    private String txtFiltroTipo = "0";
    private ArrayList<CelulaBean> listaDeCelulas = new ArrayList<CelulaBean>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        android.support.v7.app.ActionBar bar = getSupportActionBar();
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#39afe3")));
//        bar.hide();


        celulasCadastros();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void celulasCadastros() {

        CelulaDao dao = new CelulaDao(MainActivity.this);

        /** Cadastrar Celulas aqui!
         *  parametros do construtor (String nome, String endereco, String liderNome,
         *  String telefoneInformacao, String diaHora, Double latitude, Double longitude,
         *  int semanaID, int tipoID, int redeID)
         */

        listaDeCelulas.add(new CelulaBean("Célula MDA", "Av A, nº20 - José Walter", "Samuel", "99150-5007", "Sábados as 16h", -3.82568256, -38.55116218, 7, 3, 1));
        listaDeCelulas.add(new CelulaBean("Célula Geração Eleita", "Av Desembargador Praxedes, nº1441 - Montese", "Renata Granjeiro", "98821-7272", "Quintas as 20h", -3.7633416, -38.54193, 5, 3, 1));
        listaDeCelulas.add(new CelulaBean("Célula Eleitos por Cristo", "Rua Prof Isaías Gomes, nº157 - Edson Queiroz", "Cezar Peixoto", "99922-3309", "Quartas as 20h", -3.7588539, -38.4808816, 4, 4, 2));
        listaDeCelulas.add(new CelulaBean("Célula Crianças pra Cristo", "Av Desembargador Praxedes, nº1441 - Montese", "Rosemary", "98821-7272", "Quartas as 20h", -3.7633416, -38.54193, 5, 1, 1));
        listaDeCelulas.add(new CelulaBean("Célula AdoleSantos", "Rua 23, Jose Walter", "Camylla Oliveira", "98198-9323", "Sábados as 16h", -3.8249069, -38.5511938, 7, 2, 2));
        listaDeCelulas.add(new CelulaBean("Célula Sementes da Fé", "Rua Dr. Francisco Gadelha, 765 - Luciano Cavalcante", "Rodrigo", "99760-3510", "Sábados as 17h", -3.7751283, -38.4903772, 7, 3, 3));
        listaDeCelulas.add(new CelulaBean("Célula Família Real", "Rua Prof. Jacinto Botelho, 1080, Apt. 1205 - Guararapes", "Barreto Neto", "99929-8681", "Quintas as 19h", -3.7630173, -38.4917747, 5, 4, 1));


        if (dao.consultarCelulas().size() < listaDeCelulas.size()) {
            dao.reset();
            Toast.makeText(MainActivity.this, "Banco de dados atualizados",
                    Toast.LENGTH_SHORT).show();
            for (int i = 0; i < listaDeCelulas.size(); i++) {
                dao.inserirRegistro(listaDeCelulas.get(i));
            }
        }

        dao.close();
    }


    public void buttonDiaTodos(View view) {
        txtFiltroDia = "0";
    }

    public void buttonTipoTodos(View view) {
        txtFiltroTipo = "0";
    }

    public void buttonDiaSemana(View view) {
        txtFiltroDia = "1";
    }

    public void buttonDiaSabado(View view) {
        txtFiltroDia = "2";
    }

    public void buttonTipoCriancas(View view) {
        txtFiltroTipo = "1";
    }

    public void buttonTipoAdolecentes(View view) {
        txtFiltroTipo = "2";
    }

    public void buttonTipoJovens(View view) {
        txtFiltroTipo = "3";
    }

    public void buttonTipoAdultos(View view) {
        txtFiltroTipo = "4";
    }


    public void goMaps(View view) {
        Toast.makeText(MainActivity.this, "Carregando Mapa...",
                Toast.LENGTH_LONG).show();

        RadioGroup radioGroupDia = (RadioGroup) findViewById(R.id.filtroDia);
        radioGroupDia.clearCheck();
        RadioGroup radioGroupTipo = (RadioGroup) findViewById(R.id.filtroTipo);
        radioGroupTipo.clearCheck();

        Intent intent = new Intent(MainActivity.this, MapsCelulas.class);
        Bundle parametros = new Bundle();
        parametros.putString("filtroDia", txtFiltroDia);
        parametros.putString("filtroTipo", txtFiltroTipo);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void goLista(View view) {

        RadioGroup radioGroupDia = (RadioGroup) findViewById(R.id.filtroDia);
        radioGroupDia.clearCheck();
        RadioGroup radioGroupTipo = (RadioGroup) findViewById(R.id.filtroTipo);
        radioGroupTipo.clearCheck();

        Intent intent = new Intent(MainActivity.this, ListaCelulas.class);
        Bundle parametros = new Bundle();
        parametros.putString("filtroDia", txtFiltroDia);
        parametros.putString("filtroTipo", txtFiltroTipo);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://br.com.igrejadapaz.fortaleza.mapasdascelulas/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://br.com.igrejadapaz.fortaleza.mapasdascelulas/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
