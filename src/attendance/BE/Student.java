/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.BE;

import java.io.Serializable;

/**
 *
 * @author Frederik Tubæk
 */
public class Student implements Serializable
{
    private String name;
    private int absence;
    
    public Student(String name, int absence)
    {
        this.name = name;
        this.absence = absence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }
    
    
}
