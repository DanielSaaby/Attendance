/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.BLL;

import attendance.BE.Student;
import attendance.DAL.MockDAO;
import java.util.List;

/**
 *
 * @author Frederik Tubæk
 */
public class PassManager {
    
    private MockDAO mockdao = new MockDAO();
    
    
    public List getStudents()
    {
        return mockdao.getStudents();
    }

    public List getCS2017A() 
    {
        return mockdao.getCS2017A();
    }

    public List getCS2017B() 
    {
        return mockdao.getCS2017B();
    }

    public List getCS2016A() 
    {
        return mockdao.getCS2016A();
    }

    public List getCD2016B() 
    {
        return mockdao.getCS2016B();
    }
}
