package model;

import components.ConnectionMySql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Person {
    private int id;
    private String fname;
    private String lname;
    private int age;

    public Person() {
    }

    public Person(int id, String fname, String lname, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                '}';
    }

    public ArrayList<Person> select() {
        ArrayList<Person> person = new ArrayList<Person>();
        try {
            ResultSet rs = ConnectionMySql.getInstance().getSt().executeQuery("SELECT * FROM person");

            while (rs.next()) {
                Person p = new Person(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getInt("age"));
                person.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public void insert(Person model) {
        try {
            ConnectionMySql.getInstance().getSt().executeUpdate("INSERT INTO person (id, fname, lname, age) VALUES (NULL,'" + model.fname + "','" + model.lname + "','" + model.age + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person model) {
        try {
            ConnectionMySql.getInstance().getSt().executeUpdate("UPDATE person SET fname = '" + model.fname + "', lname = '" + model.lname + "', age = '" + model.age + "' WHERE id = " + model.id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            ConnectionMySql.getInstance().getSt().executeUpdate("DELETE FROM person WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> view(int id) {
        ArrayList<Person> person = new ArrayList<Person>();
        try {
            ResultSet rs = ConnectionMySql.getInstance().getSt().executeQuery("SELECT * FROM person WHERE id=" + id);

            while (rs.next()) {
                Person p = new Person(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getInt("age"));
                person.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }
}
