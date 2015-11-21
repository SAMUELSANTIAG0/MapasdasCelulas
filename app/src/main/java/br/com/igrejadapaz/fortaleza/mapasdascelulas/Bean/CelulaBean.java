package br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.R;

/**
 * Created by Samuel Santiago on 20/11/2015.
 */
public class CelulaBean implements Parcelable {

    private int id;
    private String nome;
    private String endereco;
    private String liderNome;
    private String telefoneInformacao;
    private String diaHora;
    private Double latitude;
    private Double longitude;
    private int semanaID;
    private LatLng posicao;
    private MarkerOptions markerOptions;

    public CelulaBean(Parcel in) {
        readFromParcelable(in);
    }

    public CelulaBean() {
        // TODO
    }

    public CelulaBean(String nome, String endereco, String liderNome, String telefoneInformacao, String diaHora, Double latitude, Double longitude, int semanaID) {
        this.nome = nome;
        this.endereco = endereco;
        this.liderNome = liderNome;
        this.telefoneInformacao = telefoneInformacao;
        this.diaHora = diaHora;
        this.latitude = latitude;
        this.longitude = longitude;
        this.semanaID = semanaID;
    }

    //    public static final Creator<CelulaBean> CREATOR = new Creator<CelulaBean>() {
//        @Override
//        public CelulaBean createFromParcel(Parcel in) {
//            return new CelulaBean(in);
//        }
//
//        @Override
//        public CelulaBean[] newArray(int size) {
//            return new CelulaBean[size];
//        }
//    };

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcelable(Parcel in){
        id = in.readInt();
        nome = in.readString();
        endereco = in.readString();
        liderNome = in.readString();
        telefoneInformacao = in.readString();
        diaHora = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(liderNome);
        dest.writeString(telefoneInformacao);
        dest.writeString(diaHora);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }


    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CelulaBean createFromParcel(Parcel in) {
            return new CelulaBean(in);
        }

        public CelulaBean[] newArray(int size) {
            return new CelulaBean[size];
        }
    };

    public String toString(){
        return "Célula "+nome;
    }

    public static Parcelable.Creator getCREATOR() {
        return CREATOR;
    }

    public LatLng getPosicao() {
        setPosicao();
        return posicao;
    }

    public void setPosicao() {
        LatLng posicao = new LatLng(this.latitude, this.longitude);
        this.posicao = posicao;
    }

    public MarkerOptions getMarkerOptions() {
        setMarkerOptions();
        return markerOptions;
    }

    public void setMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).position(getPosicao()).title(getNome()).snippet(getDiaHora() + " Contato: " + getTelefoneInformacao() + " -" + getLiderNome());
        this.markerOptions = markerOptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLiderNome() {
        return liderNome;
    }

    public void setLiderNome(String liderNome) {
        this.liderNome = liderNome;
    }

    public String getTelefoneInformacao() {
        return telefoneInformacao;
    }

    public void setTelefoneInformacao(String telefoneInformacao) {
        this.telefoneInformacao = telefoneInformacao;
    }

    public String getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(String diaHora) {
        this.diaHora = diaHora;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getSemanaID() {
        return semanaID;
    }

    public void setSemanaID(int semanaID) {
        this.semanaID = semanaID;
    }
}
