//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyMovieVault {

    //定義一個靜態類別叫 Movie
    static class Movie{

        //建立了一個屬性，名稱是 title，資料型別是 String
        int movieId;
        String movieTitle;
        String movieGenre;

        //建立了一個方法，這是"建構子"，名稱是 Movie
        Movie(int idInput, String titleInput, String genreInput){
            movieId=idInput;
            movieTitle=titleInput; //參數進來，會放進參數變數 titleInput再配指派到 movieTitle 欄位中
            movieGenre=genreInput;
        }

        public int getMovieId(){
            return movieId;
        }

        public void setMovieId(int movieId){

        }

        public String getMovieTitle(){
            return movieTitle;
        }

        public void setMovieTitle(String title){
            movieTitle=title;
        }

        public String getMovieGenre(){
            return movieGenre;
        }

        public void setMovieGenre(String genre){
            movieGenre=genre;
        }




        //註解(annotation)，重寫父類別的方法 toString()
        @Override
        //一個方法 toString()
        public String toString(){
            return"片名"+movieTitle+"/類型:"+movieGenre;
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        boolean running=true;

        System.out.println("歡迎來到 My Movie Vault!");

        while(running){
            System.out.println("\n請選擇操作:");
            System.out.println("1. 新增電影");
            System.out.println("2. 查看電影清單");
            System.out.println("3. 離開");
            System.out.print("輸入選項(1-3):");

            int choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("請輸入電影名稱:");
                    String titleInput=scanner.nextLine();
                    System.out.print("請輸入電影類型：");
                    String genreInput=scanner.nextLine();

                    try{
                        Connection conn = DriverManager.getConnection("jdbc:sqlite:mmv.db");

                        String sql="INSERT INTO movie(title, genre) VALUES(?,?)";
                        PreparedStatement pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        pstmt.setString(1, titleInput);
                        pstmt.setString(2, genreInput);

                        int affectedRows=pstmt.executeUpdate();

                        if(affectedRows>0){
                            ResultSet generatedKeys=pstmt.getGeneratedKeys();
                            if(generatedKeys.next()){
                                int newId=generatedKeys.getInt(1);
                                System.out.println("已新增電影，ID:"+newId);
                            }
                        }

                        pstmt.close();
                        conn.close();
                    }
                    catch(SQLException e){
                        System.out.println("新增電影失敗:"+e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n電影清單：");

                    try{
                        Connection conn = DriverManager.getConnection("jdbc:sqlite:mmv.db");                        String sql="SELECT*FROM movie";
                        Statement stmt=conn.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);

                        boolean hasResult=false;
                        while(rs.next()){
                            int id=rs.getInt("id");
                            String title=rs.getString("title");
                            String genre=rs.getString("genre");
                            System.out.println("ID:"+id+"｜片名"+title+"｜類型："+genre);
                            hasResult=true;
                        }

                        if(!hasResult){
                            System.out.println("（目前沒有任何電影）");
                        }

                        rs.close();
                        stmt.close();
                        conn.close();
                    }
                    catch(SQLException e){
                        System.out.println("查詢失敗："+e.getMessage());
                    }

                    break;

                case 3:
                    running=false;
                    System.out.println("感謝使用 My Movie Vault");
                    break;

                default:
                    System.out.println("無效的選項，請重新輸入。");
            }

        }
    scanner.close();
    }
}