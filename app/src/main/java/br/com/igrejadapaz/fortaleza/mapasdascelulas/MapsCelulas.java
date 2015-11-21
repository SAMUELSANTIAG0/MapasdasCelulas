package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;

public class MapsCelulas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private CelulaBean celulaTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_celulas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        popularCelulaTeste();
    }


    private void popularCelulaTeste() {
        celulaTeste = new CelulaBean("Célula MDA", "Av A, nº20 - José Walter", "Samuel", "99150-5007", "Sábados as 16h", -3.82568256, -38.55116218, 7);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setContentDescription("Celulas em Fortaleza");

        LatLng fortaleza = new LatLng(-3.7913514, -38.5192009);
//        mMap.addMarker(new MarkerOptions().position(fortaleza).title("Fortaleza"));

        LatLng unifor = new LatLng(-3.76908106, -38.48176003);
        mMap.addMarker(new MarkerOptions().position(unifor).title("Unifor").snippet("Universidade de Fortaleza"));

        LatLng igreja = new LatLng(-3.8129413, -38.449650);
        mMap.addMarker(new MarkerOptions().position(igreja).title("Igreja da Paz").snippet("Sede regional").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ig_paz)));

        mMap.addMarker(celulaTeste.getMarkerOptions());

//        LatLng celula = new LatLng(celulaTeste.getLatitude(),celulaTeste.getLongitude());
//        mMap.addMarker(new MarkerOptions().position(celula).title(celulaTeste.getNome()).snippet(celulaTeste.getDiaHora()+" Líder "+celulaTeste.getLiderNome()+" contato: "+celulaTeste.getTelefoneInformacao()).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).anchor(0.0f, 0.0f));

//        mMap.addPolyline(new PolylineOptions().add(unifor).add(celula).color(R.color.aqua).geodesic(true));

//        Geocoder geocoder = new Geocoder(MapsCelulas.this, Locale.getDefault());
//        Location loc;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fortaleza, 2));

//        CameraPosition cp = CameraPosition.builder().target(fortaleza).zoom(2).bearing(90).build();
//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp),2000,null);

        CameraPosition cameraPosition = CameraPosition.builder().target(fortaleza).zoom(12).bearing(360).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 5000, null);

    }

}
