package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InputRequestModel {

    private int id;
    private String name;
    private String address;
    private String school;

//    public List<Subject> getSubjDetails() {
//        if(this.subjDetails!=null){
//            return subjDetails;
//        }
//        else
//            return null;
//    }
//
//    public void setSubjDetails(List<Subject> subjDetails) {
//        if(this.subjDetails == null){
//            return;
//        }
//        this.subjDetails = new ArrayList<>(subjDetails);
//    }

    private List<Subject> subjDetails;
}
