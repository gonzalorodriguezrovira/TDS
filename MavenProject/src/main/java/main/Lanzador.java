package main;

import java.awt.EventQueue;

import tds.video.VideoWeb;
import vista.AppVideo;

public class Lanzador {	
	
	public static VideoWeb videoWeb;//ROBERTO
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					videoWeb = new VideoWeb(); //ROBERTO
					AppVideo frame = new AppVideo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
