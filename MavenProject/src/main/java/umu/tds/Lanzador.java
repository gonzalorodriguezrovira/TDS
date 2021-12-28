package umu.tds;

import java.awt.EventQueue;

import umu.tds.nuevoInterfaz.AppVideo;

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
