package src;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;

    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();//Intially I dont know which all songs  will be there in my album.But,I need to intialize.
    }

    //find the song
    public boolean findSong(String title){
        for( Song checkSong : this.songs){
            if(checkSong.getTitle().equals(title)){
                System.out.println(" song found!!");
                return true;
            }
        }
        return false;

    }
    // add songs
    public boolean addSongs(String title,double duration){
        if(findSong(title)==true){
            System.out.println("Song is already there !!");
            return false;
        }
        //add
      //  Song newSong= new Song(title, duration); Instead of these I will directly Write
        this.songs.add(new Song(title,duration));
        return  true;
    }


    public boolean addToPlayList(String title, LinkedList<Song>playList){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)) {
                playList.add(checkedSong);
                return true;
            }
        }
        return false;
    }

    // two method bcoz sometimes I only know the title sometimes I know the   Tracknumber.
    public boolean addToPlayList(int trackNumber, LinkedList<Song>playList){
        int index= trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }

}
