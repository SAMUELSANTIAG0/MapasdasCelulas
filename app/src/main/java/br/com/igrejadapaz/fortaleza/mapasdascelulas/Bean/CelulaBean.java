package br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean;

import android.os.Parcel;
import android.os.Parcelable;

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

    public CelulaBean(Parcel in) {
        readFromParcelable(in);
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

}
