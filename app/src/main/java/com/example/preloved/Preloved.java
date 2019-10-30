package com.example.preloved;

import android.os.Parcel;
import android.os.Parcelable;

public class Preloved implements Parcelable {
    public Preloved() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    private String name, remarks, photo, description, size, warna, harga;

    protected Preloved(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.description = in.readString();
        this.size = in.readString();
        this.warna = in.readString();
        this.harga = in.readString();
    }

    public static final Creator<Preloved> CREATOR = new Creator<Preloved>() {
        @Override
        public Preloved createFromParcel(Parcel in) {
            return new Preloved(in);
        }

        @Override
        public Preloved[] newArray(int size) {
            return new Preloved[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.description);
        dest.writeString(this.size);
        dest.writeString(this.warna);
        dest.writeString(this.harga);
    }
}
