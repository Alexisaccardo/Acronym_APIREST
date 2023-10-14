package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class Controlador {
    @PostMapping("/register_product")
    public Product register_product(@RequestBody Product product) throws SQLException, ClassNotFoundException {

        String id = product.getId();
        String name = product.getName_product();
        String status = product.getStatus();
        String name_acronym = product.getName_acronym();

        if (id == null || id.equals("") || id.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                status == null || status.equals("") || status.length() < 0 ||name_acronym == null ||
                name_acronym.equals("") || name_acronym.length() < 0  ) {

            return new Product(null,null,null, null);
        } else {
           if (status.equalsIgnoreCase("Activo")){
                BD bd = new BD();
                product = bd.register(id, name, status, name_acronym);
            }else {
                return new Product(null,null,"Estado no admitido", null);
            }
        }
        return product;
    }

    @PostMapping("/edit")
    public Product edit(@RequestBody Product product) throws SQLException, ClassNotFoundException {

        String id = product.getId();
        String name = product.getName_product();
        String status = product.getStatus();
        String name_acronym = product.getName_acronym();
        if (id == null || id.equals("") || id.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                status == null || status.equals("") || status.length() < 0 ||name_acronym == null ||
                name_acronym.equals("") || name_acronym.length() < 0  ) {
            return new Product(null,null,null, null);
        } else {
            BD bd = new BD();
            int expirationAcronym = BD.Select_acronym(name_acronym);
            if (expirationAcronym == 0 ) {
                return new Product(null,null,"Expiration acronimo es 0", null);
            } else if (status.equalsIgnoreCase("Inactivo")){
                String creation_date = BD.Select_date(id);
                LocalDateTime dateNow = LocalDateTime.now();
                LocalDateTime dateBD = dateConversion(creation_date);
                LocalDateTime days = dateBD.plusDays(expirationAcronym);
                int comparisonResult = days.compareTo(dateNow);
                if (comparisonResult <= 0){
                    product = bd.editar(id, status);
                }else {
                    return new Product(null,null,"No cumple con la fecha mínima permitida para inactivacion", null);
                }

            }else{
                return new Product(null,null,"Estado no admitido", null);
            }
        }
        return product;
    }



    private LocalDateTime dateConversion(String date){
        int length_milliseconds = 23;
        DateTimeFormatter formatter;
        date = date.substring(0, 23);
        if(date.length() == length_milliseconds){
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        }else if(date.length() == length_milliseconds+1){
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSS");
        }else{
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS");
        }
        return LocalDateTime.parse(date, formatter);
    }

}
