package main;

import java.sql.SQLException;
import java.util.List;

import logic.Student;

import DAO.Factory;
import logic.Role;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        //Создадим двух студентов
        Student s1 = new Student();
        Student s2 = new Student();
        Role r1 = new Role();
        r1.setTitle("Староста");
        Role r2 = new Role();
        r2.setTitle("Второй");
        
        //Проинициализируем их
        s1.setName("Ivanov Ivan");
        s1.setAge(21l);
        s1.setRole(r1);
        s2.setName("Petrova Alisa");
        s2.setAge(24l);
        s2.setRole(r2);
                
        //Сохраним их в бд, id будут сгенерированы автоматически
        Factory.getInstance().getStudentDAO().addStudent(s1);
        Factory.getInstance().getStudentDAO().addStudent(s2);       
        
        //Выведем всех студентов из бд
        List<Student> studs = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("========Все студенты=========");
        for(Student s : studs) {
                System.out.println("Имя студента : " + 
                        s.getName() + ", Возраст : " + 
                        s.getAge() +",  id : " + 
                        s.getId() + ", role : " /*+ s.getRole()*/);
                System.out.println("=============================");              
        }       
    }
}