/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java111;

/**
 *
 * @author student
 */
import java.util.Scanner;
import java.sql.*;
public class empinfo {
      int empid;
    String fname;
    String lname;
    int rank;
    String department;
    String position;
    float salary;
   
public static void main(String[] args){
empinfo s= new empinfo();
s.userinput();
s.insert();
}
void userinput(){
Scanner in = new Scanner(System.in);
askdata("ID");
this.empid = in.nextInt();
askdata("Firstname");
this.fname = in.next();
askdata("Lastname");
this.lname = in.next();
askdata("Rank");
this.rank = in.nextInt();
askdata("Department");
this.department = in.next();
askdata("Position");
this.position = in.next();
if(rank == 1){
    salary = 25000;
}
else if(rank == 2){
    salary = 15000;
}
else if(rank == 3){
    salary = 12000;
}
else{
    salary = 0;
}
System.out.println(this.salary);
}

void askdata(String data){
    System.out.println("input"+data+":");
}
void insert(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/jdbc","root","");
            Statement st = con.createStatement();
            String sql = "insert into empinfo values (" + this.empid+ ",'" + this.fname+ "','" + this.lname+ "'," + this.rank + ",'" + this.department + "','" + this.position+ "'," + this.salary + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
            con.close();
        } catch(Exception e){System.out.print(e);}
}
}

    
