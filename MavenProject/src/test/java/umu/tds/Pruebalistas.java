package umu.tds;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import modelo.Etiqueta;
import modelo.Video;

public class Pruebalistas {

	public static void main(String[] args) {
		Video v1 = new Video("a","n1", new HashSet<Etiqueta>());
		Video v2 = new Video("aa","n2", new HashSet<Etiqueta>());
		List<Video> l1 = new LinkedList<Video>();
		l1.add(v1);
		l1.add(v2);
		List<Video> l2 = new LinkedList<Video>();
		l2.addAll(l1);
		l2.addAll(l2);
		System.out.println(l2.size());
		System.out.println(l2.get(1));
	}

}
