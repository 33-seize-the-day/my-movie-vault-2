//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

public class MyMovieVault {

    //定義一個靜態類別叫 Movie
    static class Movie{

        //建立了一個屬性，名稱是 title，資料型別是 String
        String movieTitle;
        String movieGenre;

        //建立了一個方法，這是"建構子"，名稱是 Movie
        Movie(String titleInput, String genreInput){
            movieTitle=titleInput; //參數進來，會放進參數變數 titleInput再配指派到 movieTitle 欄位中
            movieGenre=genreInput;
        }

        //註解(annotation)，重寫父類別的方法 toString()
        @Override
        //一個方法 toString()
        public String toString(){
            return"片名"+movieTitle+"/類型:"+movieGenre;
        }
    }

    public static void main(String[] args){
        ArrayList<Movie> movieList=new ArrayList();
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
                    movieList.add(new Movie(titleInput, genreInput));
                    System.out.println("已新增電影！");
                    break;

                case 2:
                    System.out.println("\n電影清單：");
                    if (movieList.isEmpty()){
                        System.out.println("(目前沒有任何電影)");
                    }
                    else {
                        for (Movie movie:movieList){
                            System.out.print(movie);
                        }
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