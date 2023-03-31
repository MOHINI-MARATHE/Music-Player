package com.jspiders.multiplayer;

import java.util.Scanner;


public class Menu extends SongOperation{
	public Menu(int songId,String songName,String songArtist) {
		super(songId,songName,songArtist);
		// TODO Auto-generated constructor stub
	}
	
	static Scanner sc=new Scanner(System.in);
	static boolean loop=true;
	
	
	public static void menu() {
		System.out.println("Select anything from the menu\n1.PlaySongs\n2.AddSongs\n3.RemoveSong\n4.EditSong\n5.DisplayAllSong\n6.Exit");
		int a =sc.nextInt();
		switch(a) {
		case 1:playSongs();
		break;
		case 2:addSongs();
		break;
		case 3:removeSongs();
		break;
		case 4:editSongs();
		break;
		case 5:displayAllSongs();
		break;
		case 6:
			System.out.println("Thanks for using the Music Player :) ");
			loop=false;
			break;
		default:
			System.out.println("Invalid Input");
			return;
		}
	}
//	play songs
	public static void playSongs() {
		System.out.println("Select from below options\n1.chooseSongToPlay\n2.playAllSongs\n3.playRandomSongs");
		int a=sc.nextInt();
		switch(a) {
		case 1:SongOperation.chooseSongToPlay();
		break;
		case 2:SongOperation.playAllSongs();
		break;
		case 3:SongOperation.playRandomSongs();
		break;
		default:
			System.out.println("wrong option selected");
			return;
		}
		
	}
	
//	add songs
	public static void addSongs() {
		System.out.println("Do you really want to add songs\n1.Yes\n2.No ");
		int a=sc.nextInt();
		switch(a) {
		case 1:SongOperation.addSongs();
			break;
		case 2:
			return;
			
		}
		
	}
	
//remove songs
	public static void removeSongs() {
		System.out.println("Do you really want to remove songs\n1.Yes\n2.No ");
		int a=sc.nextInt();
		switch(a) {
		case 1:SongOperation.removeSongs();
			break;
		case 2:
			return;
		default:
			break;
		}
		
	}

//edit songs	
	public static void editSongs() {
		System.out.println("Do you really want to edit songs\n1.Yes\n2.No ");
		int a=sc.nextInt();
		switch(a) {
		case 1:SongOperation.editSongs();
			break;
		case 2:
			return;
		default:
			break;
		}
		
	}
	
//	display all songs
	public static void displayAllSongs() {
		for(Song var :list) {
			int index=0;
			System.out.println(index+1+" songId "+var.getSongId()+" songName "+var.getSongName()+" songArtist "+var.getSongArtist());
		}
		return;
	}
	
//main method
	public static void main(String[] args) {
		while(loop) {
			System.out.println("Welcome to Music Player 🎵");
			menu();
			
		}
	}

}
