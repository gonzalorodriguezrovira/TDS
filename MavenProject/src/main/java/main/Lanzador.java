package main;

import java.awt.EventQueue;

import vista.AppVideo;

public class Lanzador {	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppVideo frame = new AppVideo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
