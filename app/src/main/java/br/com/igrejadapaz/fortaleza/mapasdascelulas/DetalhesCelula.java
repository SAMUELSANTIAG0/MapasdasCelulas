package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;

public class DetalhesCelula extends AppCompatActivity implements OnMapReadyCallback {

    private CelulaBean celulaSelecionada;
    private GoogleMap mMap;


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
        TextView dia = (TextView) findViewById(R.id.textViewDiaHora);
        dia.setText(celulaSelecionada.getDiaHora());
        TextView tipo = (TextView) findViewById(R.id.textViewTipo);
        tipo.setText("Célula de " + celulaSelecionada.getTipo() + " - " + celulaSelecionada.getRede());


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

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

    public void toShared(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, celulaSelecionada.toShared());
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setContentDescription("Celulas em Fortaleza");
        CameraPosition cameraPosition = CameraPosition.builder().target(getLatLngFromAddress("City of Fortaleza, Brazil")).zoom(8).build();
        mMap.addMarker(celulaSelecionada.getMarkerOptions());
        mMap.stopAnimation();
        CameraPosition cameraPositionCelula = CameraPosition.builder().target(celulaSelecionada.getPosicao()).zoom(17).bearing(360).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionCelula), 5000, null);

    }


    public LatLng getLatLngFromAddress(String endereco) {
        Geocoder geocoder = new Geocoder(this);
        List<Address> listaEnderecos = null;
        Double latitude = null;
        Double longitude = null;
        try {
            listaEnderecos = geocoder.getFromLocationName(endereco, 3);
            if (listaEnderecos == null) {
                return null;
            }
            Address address = listaEnderecos.get(0);
            latitude = address.getLatitude();
            longitude = address.getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LatLng(latitude, longitude);
    }
}
