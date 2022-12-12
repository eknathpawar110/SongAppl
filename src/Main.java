package src;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Album album1=new Album("album1","Alean Walker");
         album1.addSongs("Alone",5.2);
         album1.addSongs("Faded",4.5);

        LinkedList<Song> myPlaylist =new LinkedList<>();
        album1.addToPlayList("Alone",myPlaylist);
        album1.addToPlayList("Faded",myPlaylist);

        play(myPlaylist);

    }
    public static  void play(LinkedList<Song> playList){
        Scanner sc= new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Your are now listening :" +itr.next());
        showMenu();

        while(true){
            int option= sc.nextInt();

            switch (option){

                case 0:
                    System.out.println("Thank you for Listening ");
                    return;

                case 1:
                    showMenu();
                    break;

                case 2:
                    printList(playList);
                    break;

                case 3:
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of playlist");
                    }else{
                        System.out.println("You have listening to "+ itr.next());
                    }

                case 4:
                    if(!itr.hasPrevious()){
                        System.out.println("You have reached the start of playlist");
                    }else{
                        System.out.println("You have listening to "+ itr.previous());
                    }
            }
        }
    }


    public static void printList(LinkedList<Song>playList){
        ListIterator<Song> itr= playList.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        return;
    }
    public static void showMenu(){
        System.out.println("0,Exit");
        System.out.println("1,Print Menu");
        System.out.println("2,Show the list of all Songs in the playlist");
        System.out.println("3,Play next Song");
        System.out.println("4,Play previous Song");
        System.out.println("5, Repeat the song");
        System.out.println("6, Delete the song");
    }
}
