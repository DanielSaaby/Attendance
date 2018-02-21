/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.DAL;

import attendance.BE.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frederik Tubæk
 */
public class MockDAO 
{


    public List getStudents() 
    {            
        
            Student student1 = new Student("Daniel Saaby Rasmussen", 7);
            Student student2 = new Student("Kent Juul Pedersen", 4);
            Student student3 = new Student("Frederik Juul Tubæk", 2);
            Student student4 = new Student("Bent Ladeskov Andersen", 5);
            Student student5 = new Student("Maja Trevl Matthiesen", 14);
            Student student6 = new Student("Andreas Matthiesen", 0);
            Student student7 = new Student("Magnus Friis Nielsen", 25);
            Student student8 = new Student("Mathias Mølholm Hansen", 3);
            Student student9 = new Student("Daniel Octavius Jensen", 20);
            Student student10 = new Student("Ander Krogh", 7);
            Student student11 = new Student("Rasmus Rasmussen", 4);
            Student student12 = new Student("Phillip Højbjerg Jensen", 2);
            Student student13 = new Student("Aung Myo Hoali", 2);
            Student student14 = new Student("Muhammed Al-sahi", 17);
            Student student15 = new Student("Kristine Trevl Kjær", 12);
            Student student16 = new Student("Mikkel Lyst Varum", 6);
            
            List<Student> students = new ArrayList();
            
            students.add(student1);
            students.add(student2);
            students.add(student3);
            students.add(student4);
            students.add(student5);
            students.add(student6);
            students.add(student7);
            students.add(student8);
            students.add(student9);
            students.add(student10);
            students.add(student11);
            students.add(student12);
            students.add(student13);
            students.add(student14);
            students.add(student15);
            students.add(student16);
            
            return students;
    }

    public List getCS2017A() 
    {
            Student student1 = new Student("Daniel Saaby Rasmussen", 7);
            Student student2 = new Student("Kent Juul Pedersen", 4);
            Student student3 = new Student("Frederik Juul Tubæk", 2);
            Student student4 = new Student("Bent Ladeskov Andersen", 5);

            List<Student> students = new ArrayList();
            
            students.add(student1);
            students.add(student2);
            students.add(student3);
            students.add(student4);
            return students;

    }

    public List getCS2017B() 
    {
            Student student5 = new Student("Maja Trevl Matthiesen", 14);
            Student student6 = new Student("Andreas Matthiesen", 0);
            Student student7 = new Student("Magnus Friis Nielsen", 25);
            Student student8 = new Student("Mathias Mølholm Hansen", 3);
            
            List<Student> students = new ArrayList();
            
            students.add(student5);
            students.add(student6);
            students.add(student7);
            students.add(student8);
             return students;
           
    }

    public List getCS2016A() 
    { 
            Student student9 = new Student("Daniel Octavius Jensen", 20);
            Student student10 = new Student("Ander Krogh", 7);
            Student student11 = new Student("Rasmus Rasmussen", 4);
            Student student12 = new Student("Phillip Højbjerg Jensen", 2);
            
            List<Student> students = new ArrayList();
            
             students.add(student9);
            students.add(student10);
            students.add(student11);
            students.add(student12);
            return students;

    }

    public List getCS2016B() 
    {
            Student student13 = new Student("Aung Myo Hoali", 2);
            Student student14 = new Student("Muhammed Al-sahi", 17);
            Student student15 = new Student("Kristine Trevl Kjær", 12);
            Student student16 = new Student("Mikkel Lyst Varum", 6);
            
            List<Student> students = new ArrayList();
            
            students.add(student13);
            students.add(student14);
            students.add(student15);
            students.add(student16);
            return students;

    }
}
