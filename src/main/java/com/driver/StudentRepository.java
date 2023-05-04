package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student>StudentDb = new HashMap<>();
    HashMap<String,Teacher>TeacherDb = new HashMap<>();
    HashMap<String, List<String>>StudentTeacherDb = new HashMap<>();

    public void addStudent(Student student){
        StudentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        TeacherDb.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
      /*  List<String>students= new ArrayList<>();
        if (StudentTeacherDb.containsKey(teacher)){
            students = StudentTeacherDb.get(teacher);
            students.add(student); //add given student into given teacherslist
      StudentTeacherDb.put(teacher,students);
        }
  else {
      //List<String>TeacherList = new ArrayList<>();
      students.add(teacher);
      StudentTeacherDb.put(teacher,students);
  }*/
        if(!StudentTeacherDb.containsKey(teacher)){
            StudentTeacherDb.put(teacher,new ArrayList<>());
        }
        StudentTeacherDb.get(teacher).add(student);
    }
    public Student getStudentByName(String name){
    /* for(String s : StudentDb.keySet()){
         if(s.equals(name))return StudentDb.get(name);
     }*/
        return StudentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
       /* for (String t : TeacherDb.keySet()){
        if(t.equals(name))
            return TeacherDb.get(name);
        }*/
        return TeacherDb.get(name);
    }

    public List<String>getStudentsByTeacherName(String teacher){
       // List<String>studentList = new ArrayList<>();
       // if(StudentTeacherDb.containsKey(teacher))
        return StudentTeacherDb.get(teacher);
       // return studentList;
    }
    public List<String>getAllStudents(){
        List<String>list = new ArrayList<>();
        for (String st : StudentDb.keySet()){
            list.add(st);
        }
        return list;
    }
    public void deleteTeacherByName(String teacher){
        List<String> studentNames = new ArrayList<>();
        if (StudentTeacherDb.containsKey(teacher)){

            for (String s : StudentTeacherDb.get(teacher)){

                StudentDb.remove(s);
            }
        }
 if(TeacherDb.containsKey(teacher))
     TeacherDb.remove(teacher);

        StudentTeacherDb.remove(teacher);

    }
    public void deleteAllTeachers(){
        //TeacherDb = new HashMap<>();
       // HashSet<String> studentSet = new HashSet<>();
 for (String tName : TeacherDb.keySet()){
           deleteTeacherByName(tName);
             }
 }

    }


