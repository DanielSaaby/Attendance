/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.model;

import attendance.BE.Student;
import attendance.BLL.PassManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Frederik Tubæk
 */
public class Model 
{
    private final ObservableList<Student> obsListStudent;
    
    private PassManager pm = new PassManager();
    
    
    public Model()
    {
        this.obsListStudent = FXCollections.observableArrayList();
        obsListStudent.addAll(pm.getStudents());
    }
    
    public ObservableList getListOfStudents()
    {
        return obsListStudent;
    }
    
    public void getAllStudents()
    {
        obsListStudent.clear();
        obsListStudent.addAll(pm.getStudents());
    }

    public void getCS2017A() 
    {
        obsListStudent.clear();
        obsListStudent.addAll(pm.getCS2017A());
    }

    public void getCS2017B() 
    {
        obsListStudent.clear();
        obsListStudent.addAll(pm.getCS2017B());
    }

    public void getCS2016A() 
    {
        obsListStudent.clear();
        obsListStudent.addAll(pm.getCS2016A());
    }

    public void getCS2016B() 
    {
        obsListStudent.clear();
        obsListStudent.addAll(pm.getCD2016B());
    }
    
}
