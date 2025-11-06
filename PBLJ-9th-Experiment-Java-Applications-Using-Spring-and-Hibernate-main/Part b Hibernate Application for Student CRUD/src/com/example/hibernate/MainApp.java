package com.example.hibernate;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // CREATE
        Student s1 = new Student("Mayan", "Java", 90);
        dao.addStudent(s1);

        // READ ALL
        List<Student> students = dao.getAllStudents();
        System.out.println("\n📋 All Students:");
        for (Student s : students) System.out.println(s);

        // READ BY ID
        Student s2 = dao.getStudentById(1);
        if (s2 != null) System.out.println("\n🔍 Found: " + s2);

        // UPDATE
        if (s2 != null) {
            s2.setMarks(95);
            dao.updateStudent(s2);
        }

        // DELETE
        dao.deleteStudent(1);

        HibernateUtil.shutdown();
    }
}
