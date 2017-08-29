package com.er0r.tejas.myapplication;

import android.location.Location;

/**
 * Created by Tejas on 27-07-2017.
 */

public class h_sale extends Person{

    String H_name;
    String Add_lin1;
    String Add_line2;
    String Area;
    String City;
    String State;
    String Landmark;
    Double lat;
    Double lot;
    int pin;

    h_sale(String Name, String phone_no, String ID,String H_name, String Add_lin1, String Add_line2, String Area, String City, String State, String Landmark,int pin,Double lat, Double lot) {
        super(Name, phone_no, ID);
        this.H_name = H_name;
        this.Add_lin1=Add_lin1;
        this.Add_line2 = Add_line2;
        this.Area = Area;
        this.City = City;
        this.State = State;
        this.Landmark = Landmark;
        this.pin = pin;
        this.lat = lat;
        this.lot = lot;


    }

    double get_lat(){
        return(lat);
    }
    double get_lot(){
        return(lot);
    }

    String user_details(){
        return("Name :-" +Name + "\nPhone NO." + phone_no + "\nAddress :- " +H_name +"\n\t"+ Add_lin1 + "\n\t" + Add_line2 + Area + "\n" + City + "-" + pin);
    }
}

