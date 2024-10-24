/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package index;


import controlador.HotelC;
import vista.HotelV;


/**
 *
 * @author Usuario
 */
public class Index {

    public static void main(String[] args) {

    
        HotelV hotel = new HotelV();
        HotelC hot = new HotelC(hotel);

    }
}
