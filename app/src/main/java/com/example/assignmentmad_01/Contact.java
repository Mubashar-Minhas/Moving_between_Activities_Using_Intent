package com.example.assignmentmad_01;

import android.os.Parcel;
import android.os.Parcelable;

public
class Contact implements Parcelable {
    private String name;
    private final String mail;
    private final String phone;

    public Contact(String name, String mail, String phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }



    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    protected Contact(Parcel in) {

        name = in.readString();
        mail = in.readString();
        phone = in.readString();

    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(mail);
        parcel.writeString(phone);

    }
}



