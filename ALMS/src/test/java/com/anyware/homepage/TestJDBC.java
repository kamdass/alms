package com.anyware.homepage;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestJDBC
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://umj7-009.cafe24.com:3306/anyware11"; // jdbc:mysql://127.0.0.1:3306/여러분이 만드신 스키마이름
    private static final String USER = "anyware11"; //DB 사용자명
    private static final String PW = "dosldnpdjdb@@";   //DB 사용자 비밀번호

    @Test
    public void test() throws Exception
    {
        Class.forName(DRIVER);
        
        try(Connection con = DriverManager.getConnection(URL, USER, PW)){
         System.out.println("성공");
         System.out.println(con);
        }catch (Exception e) {
         System.out.println("에러발생");
         e.printStackTrace();
        }
       }

//        fail("Not yet implemented");
    }
