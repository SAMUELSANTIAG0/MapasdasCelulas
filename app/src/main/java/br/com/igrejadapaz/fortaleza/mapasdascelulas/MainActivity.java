package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;
import br.com.igrejadapaz.fortaleza.mapasdascelulas.Dao.CelulaDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        android.support.v7.app.ActionBar bar = getSupportActionBar();
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#39afe3")));
//        bar.hide();
        celulasCadastros();
    }

    public void goMaps(View view) {
        Intent intent = new Intent(MainActivity.this, MapsCelulas.class);
        startActivity(intent);
    }

    public void celulasCadastros() {

        CelulaDao dao = new CelulaDao(MainActivity.this);
        dao.reset();

        /** Cadastrar Celulas aqui!
         *  TODO: parametros do construtor (String nome, String endereco, String liderNome,
         *  TODO: String telefoneInformacao, String diaHora, Double latitude, Double longitude,
         *  TODO: int semanaID, int tipoID, int redeID)
         */

        dao.inserirRegistro(new CelulaBean("MDA", "Av A, nº20 - José Walter", "Samuel", "99150-5007", "Sábados as 16h", -3.82568256, -38.55116218, 7, 3, 1));
        dao.inserirRegistro(new CelulaBean("Geração Eleita", "Av Desembargador Praxedes, nº1441 - Montese", "Renata Granjeiro", "98821-7272", "Quintas as 20h", -3.7633416, -38.54193, 5, 3, 1));
        dao.inserirRegistro(new CelulaBean("Eleitos por Cristo", "Rua Prof Isaías Gomes, nº157 - Edson Queiroz", "Cezar Peixoto", "99922-3309", "Quartas as 20h", -3.7588539, -38.4808816, 4, 4, 2));
        dao.inserirRegistro(new CelulaBean("Crianças pra Cristo", "Av Desembargador Praxedes, nº1441 - Montese", "Rosemary", "98821-7272", "Quartas as 20h", -3.7633416, -38.54193, 5, 3, 1));

        dao.close();
    }
}
