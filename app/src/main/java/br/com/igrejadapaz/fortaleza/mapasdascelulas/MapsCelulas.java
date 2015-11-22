package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
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

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Dao.CelulaDao;

public class MapsCelulas extends FragmentActivity implements OnMapReadyCallback {

    private String filtro;
    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        filtro = args.getString("filtroDia") + args.getString("filtroTipo");
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

        LatLng igreja = new LatLng(-3.8129413, -38.449650);
        mMap.addMarker(new MarkerOptions().position(igreja).title("Igreja da Paz").snippet("Sede regional").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ig_paz_55x55)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(igreja, 30));

        CameraPosition cameraPosition = CameraPosition.builder().target(fortaleza).zoom(11).bearing(360).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 5000, null);

        marcarCelulas();

    }

    public void marcarCelulas() {

        CelulaDao celulaDao = new CelulaDao(MapsCelulas.this);

        switch (filtro) {
            case "00":
                celulaDao.getMarkers(mMap);
                break;
            case "01":
                celulaDao.getMarkersTipoId(mMap, 1);
                break;
            case "02":
                celulaDao.getMarkersTipoId(mMap, 2);
                break;
            case "03":
                celulaDao.getMarkersTipoId(mMap, 3);
                break;
            case "04":
                celulaDao.getMarkersTipoId(mMap, 4);
                break;
            case "10":
                celulaDao.getMarkersSemana(mMap);
                break;
            case "11":
                celulaDao.getMarkersSemanaTipoId(mMap, 1);
                break;
            case "12":
                celulaDao.getMarkersSemanaTipoId(mMap, 2);
                break;
            case "13":
                celulaDao.getMarkersSemanaTipoId(mMap, 3);
                break;
            case "14":
                celulaDao.getMarkersSemanaTipoId(mMap, 4);
                break;
            case "20":
                celulaDao.getMarkersSabado(mMap);
                break;
            case "21":
                celulaDao.getMarkersSabadoTipoId(mMap, 1);
                break;
            case "22":
                celulaDao.getMarkersSabadoTipoId(mMap, 2);
                break;
            case "23":
                celulaDao.getMarkersSabadoTipoId(mMap, 3);
                break;
            case "24":
                celulaDao.getMarkersSabadoTipoId(mMap, 4);
                break;
            default:
                celulaDao.getMarkers(mMap);
                Toast.makeText(MapsCelulas.this, "Filtros não aplicados ",
                        Toast.LENGTH_SHORT).show();
                break;
        }


        celulaDao.close();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapsCelulas Page", // TODO: Define a title for the content shown.
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
                "MapsCelulas Page", // TODO: Define a title for the content shown.
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
