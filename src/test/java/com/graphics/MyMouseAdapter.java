package com.graphics;

import java.awt.Color;

import java.awt.Frame;

import java.awt.Graphics;

import java.awt.Point;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.util.ArrayList;

import java.util.Iterator;

public class MyMouseAdapter {
	public static void main(String[] args) {
		new MyFrame5("drawing");
	}
}

class MyFrame5 extends Frame {
	ArrayList points = null;
	MyFrame5(String s) {
		super(s);
		points = new ArrayList();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		this.setBackground(new Color(204, 204, 255));
		setVisible(true);
		this.addMouseListener(new Monitor5());
	}

	public void paint(Graphics g) {
		Iterator i = points.iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			g.setColor(Color.blue);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}

	public void addPoint(Point p) {
		points.add(p);
	}
}

class Monitor5 extends MouseAdapter { // MouseAdapter实现了MouseListener接口
	public void mousePressed(MouseEvent e) {
		MyFrame5 f = (MyFrame5) e.getSource();
		f.addPoint(new Point(e.getX(), e.getY()));
		f.repaint(); // 让Frame强制经行重画
	}

}
