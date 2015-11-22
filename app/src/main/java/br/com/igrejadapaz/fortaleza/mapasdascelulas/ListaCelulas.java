package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;
import br.com.igrejadapaz.fortaleza.mapasdascelulas.Dao.CelulaDao;

public class ListaCelulas extends AppCompatActivity {

    private ListView listViewCelula;
    private CelulaBean celulaSelecionado;
    private List<CelulaBean> registrosCelula;
    private ArrayAdapter<CelulaBean> adaptadorLista;
    private int adptadorLayout = android.R.layout.simple_list_item_1;
    private String filtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_celulas);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        filtro = args.getString("filtroDia") + args.getString("filtroTipo");

        listViewCelula = (ListView) findViewById(R.id.listView);
        CelulaDao dao = new CelulaDao(ListaCelulas.this);

        registrosCelula = carregarCelulas(dao);

        adaptadorLista = new ArrayAdapter<CelulaBean>(this, adptadorLayout, registrosCelula);
        listViewCelula.setAdapter(adaptadorLista);

    }

    private List<CelulaBean> carregarCelulas(CelulaDao dao) {

        List<CelulaBean> list = null;

        switch (filtro) {
            case "00":
                list = dao.consultarCelulas();
                break;
            case "01":
                list = dao.consultarCelulasTipoId(1);
                break;
            case "02":
                list = dao.consultarCelulasTipoId(2);
                break;
            case "03":
                list = dao.consultarCelulasTipoId(3);
                break;
            case "04":
                list = dao.consultarCelulasTipoId(4);
                break;
            case "10":
                list = dao.consultarCelulasSemana();
                break;
            case "11":
                list = dao.consultarCelulasSemanaTipoId(1);
                break;
            case "12":
                list = dao.consultarCelulasSemanaTipoId(2);
                break;
            case "13":
                list = dao.consultarCelulasSemanaTipoId(3);
                break;
            case "14":
                list = dao.consultarCelulasSemanaTipoId(4);
                break;
            case "20":
                list = dao.consultarCelulasSabado();
                break;
            case "21":
                list = dao.consultarCelulasSabadoTipoId(1);
                break;
            case "22":
                list = dao.consultarCelulasSabadoTipoId(2);
                break;
            case "23":
                list = dao.consultarCelulasSabadoTipoId(3);
                break;
            case "24":
                list = dao.consultarCelulasSabadoTipoId(4);
                break;
            default:
                list = dao.consultarCelulas();
                Toast.makeText(ListaCelulas.this, "Filtros não aplicados ",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return list;
    }
}
