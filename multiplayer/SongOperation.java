package com.jspiders.multiplayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SongOperation extends Song {
	static ArrayList<Song> list = new ArrayList<Song>();
	static Scanner sc = new Scanner(System.in);

//constructor
	public SongOperation(int songId, String songName, String songArtist) {
		
		super(songId, songName, songArtist);
	}

	//	choose song to play
	public static void chooseSongToPlay() {
		int index = 0;
		if (list.isEmpty()) {
			System.out.println("No songs found!! download some or add");

		} else {
			for (Song var : list) {
				System.out.println("press " + (index + 1) + " to select " + var.getSongName());
				index++;
			}
			int a = sc.nextInt();
			System.out.println(list.get(a-1).songName + " is now running");
		}

		return;

	}

//	play all songs
	public static void playAllSongs() {
		if (list.isEmpty()) {
			System.out.println("No songs found in the library");
		} else {
			for (Song var : list) {
				System.out.println(var.getSongName() + " is now running ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
// play random songs
	public static void playRandomSongs() {
		if (list.isEmpty()) {
			System.out.println("no songs found!!");
		} else {
			System.out.println("Playing random songs........");
			int max = list.size()-1;
			int min = 0;
			System.out.println(list.get((int) (Math.random() * (max - min + 1) + min)).getSongName() + " is now running ");
//			Random rand=new Random();
//		System.out.println(list.get((int) (rand.nextInt( list.size() ) ) ).getSongName() + "is now running ");
		}
	}
	
// add songs
	public static void addSongs() {
		System.out.println("please enter the song details(id,sname,sartist");
		try {
		list.add(new Song(sc.nextInt(), sc.next(), sc.next()));
		System.out.println("song added successfully");
		}catch(InputMismatchException e) {
			System.out.println("please enter the details again\nwrong credentials were added\n");
		}
		
	}
	
//	remove songs
	public static void removeSongs() {
		if (list.isEmpty()) {
			System.out.println("no songs found!!");
			return;
		} else {
			int index = 0;
			System.out.println("which song you want to remove");
			for (Song var : list) {
				System.out.println(index + 1 + " " + var.songName);
				index++;
			}
			int a = sc.nextInt();
			System.out.println(list.get(a - 1).getSongName() + " song removed");
			list.remove(a - 1);
		}
	}
	
//edit songs
	public static void editSongs() {
		if (list.isEmpty()) {
			System.out.println("no songs found!!");
			return;
		} else {
			System.out.println("which song you want to edit");
			int index = 0;
			for (Song var : list) {
				
				System.out.println((index+1) + " " + var.songName);
				index++;
			}
			int a = sc.nextInt();
			
			System.out.println("What you want to change in the song\n1.songId\n2.songName\n3.songArtist");
			int b = sc.nextInt();

			switch (b) {
			case 1:
				list.get(a - 1).setSongId(sc.nextInt());
				System.out.println("Song Id changed to " + list.get(a - 1).getSongId());
				break;
			case 2:
				list.get(a - 1).setSongName(sc.next());
				System.out.println("song Name changed to " + list.get(a - 1).getSongName());
				break;
			case 3:
				list.get(a - 1).setSongArtist(sc.next());
				System.out.println("Song Artist changed to " + list.get(a - 1).getSongArtist());
				break;

			}

		}

	}
	
	public static void back() {
		return;
	}
}
