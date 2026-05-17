package com.korebit.model;

//import lombok.*;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Network {
    private String name;
    private String classType;
    private String mask;
    private String netDirection;
    private String broadcast;
    private String status;
    private String range;
    private int prefix;
    private int nat;

    public Network(String name, String classType, String mask, String netDirection, String broadcast, String status, String range, int prefix, int nat) {
        this.name = name;
        this.classType = classType;
        this.mask = mask;
        this.netDirection = netDirection;
        this.broadcast = broadcast;
        this.status = status;
        this.range = range;
        this.prefix = prefix;
        this.nat = nat;
    }

    public Network() {
    }
}
