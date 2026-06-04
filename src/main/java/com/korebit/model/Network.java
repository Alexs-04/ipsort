package com.korebit.model;

//import lombok.*;
import com.korebit.model.enums.NetworkClass;
import com.korebit.model.enums.NetworkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Network {
    private String name;
    private NetworkClass networkClassType;
    private String mask;
    private String netDirection;
    private String broadcast;
    private NetworkType status;
    private String range;
    private int prefix;
    private int identifier;
}
