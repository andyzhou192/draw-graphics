package com.graphics;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import org.apache.commons.collections4.list.TreeList;

public class MouseAdapterImpl extends MouseAdapter {

	public static int STRAIGHT_LINE_2D = 0; // 直线
	public static int CURVE_LINE_2D = 1; // 曲线
	public static int RECT_2D = 2; // 直角矩形
	public static int ROUND_RECT_2D = 3; // 圆角矩形
	public static int ELLIPSE_2D = 4; // 椭圆
	public static int DIAMOND_2D = 5; // 菱形
	
	private int startx, starty, endx, endy, height, width;
	private int shape;

	private List<Point> points = new TreeList<Point>();
	private MyCanvas cans;

	public MouseAdapterImpl(){
		this.cans = new MyCanvas();
		this.cans.setBackground(Color.white);
		this.cans.addMouseListener(this);
		this.cans.addMouseMotionListener(this);
	}
	
	public int getShape() {
		return shape;
	}
	
	public void setShape(int shape) {
		this.shape = shape;
	}
	
	public MyCanvas getCans() {
		return cans;
	}
	
	/**
	 * 鼠标按下
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (shape != CURVE_LINE_2D)
			startx = e.getX();
		starty = e.getY();
	}

	/**
	 * 鼠标释放
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (shape != CURVE_LINE_2D) {
			endx = e.getX();
			endy = e.getY();
			if (shape != 0) {
				if ((endx - startx) >= 0) {
					width = endx - startx;
					if ((endy - starty) >= 0)
						height = endy - starty;
					else {
						height = starty - endy;
						starty = endy;
					}
				} else {
					width = startx - endx;
					if ((endy - starty) >= 0) {
						height = endy - starty;
						startx = endx;
					} else {
						height = starty - endy;
						startx = endx;
						starty = endy;
					}
				}
			}
			cans.repaint();
		}
	}

	/**
	 * 鼠标拖动
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (shape == CURVE_LINE_2D) {
			points.add(new Point(e.getX(), e.getY()));
			cans.repaint();
			//cans.paint(cans.getGraphics());
		}
	}
	
	@SuppressWarnings("serial")
	class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.BLACK); // 线条颜色
			g2.setStroke(new BasicStroke(3)); // 线条宽度
			if (shape == STRAIGHT_LINE_2D)
				g2.draw(new Line2D.Double(startx, starty, endx, endy));
			if (shape == CURVE_LINE_2D)
				for (int i = 0; i < points.size(); i++)
					g2.draw(new Line2D.Double(points.get(i), points.get(i + 1)));
			if (shape == RECT_2D)
				g2.draw(new Rectangle2D.Double(startx, starty, width, height));
			if (shape == ROUND_RECT_2D)
				g2.draw(new RoundRectangle2D.Double(startx, starty, width, height, 20, 20));
			if (shape == ELLIPSE_2D)
				g2.draw(new Ellipse2D.Double(startx, starty, width, height));
			if (shape == DIAMOND_2D){
				Polygon polygon=new Polygon();  // 创建多边形对象
				polygon.addPoint(startx, starty);
				polygon.addPoint(startx - width/2, starty + height/2);
				polygon.addPoint(startx, starty + height);
				polygon.addPoint(startx + width/2, starty + height/2);
				g2.drawPolygon(polygon);
			}
		}
	}
}
