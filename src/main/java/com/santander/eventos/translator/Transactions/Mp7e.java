package com.santander.eventos.translator.Transactions;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
public class Mp7e implements Serializable{

    private String Nombre;
    private String Edad;
    private String email;
    private String reftrans;
    private String eventMetadata;


    

}
