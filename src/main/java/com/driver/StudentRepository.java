package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
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
  if(TeacherDb.containsKey(teacher)){
      List<String>TeacherList = StudentTeacherDb.get(teacher);
      TeacherList.add(student); //add given student into given teacherslist
      StudentTeacherDb.put(teacher,TeacherList);
  }
  else {
      List<String>TeacherList = new ArrayList<>();
      TeacherList.add(teacher);
      StudentTeacherDb.put(teacher,TeacherList);
  }
    }
    public Student getStudentByName(String name){
     return StudentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return TeacherDb.get(name);
    }

    public List<String>getStudentsByTeacherName(String teacher){
        return StudentTeacherDb.get(teacher);
    }
    public List<String>getAllStudents(){
        List<String>list = new ArrayList<>();
        for (String st : StudentDb.keySet()){
            list.add(st);
        }
        return list;
    }
    public void deleteTeacherByName(String teacher){
        List<String>studentlist = StudentTeacherDb.get(teacher);
        for (String s : studentlist){
            StudentDb.remove(s);
        }
        StudentTeacherDb.remove(teacher);
        TeacherDb.remove(teacher);
    }
    public void deleteAllTeachers(){
       for(List<String>studentlist : StudentTeacherDb.values()){
           for (String st : studentlist){
               StudentDb.remove(st);
           }
           TeacherDb.clear();
           StudentTeacherDb.clear();
       }
    }

}
