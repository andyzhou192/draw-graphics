package com.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Graphics2DUtil {
	
	private Graphics2D d2;
	private BasicStroke defaultStroke;
	public Graphics2DUtil(Graphics graphics){
		this.d2 = (Graphics2D) graphics;//转换d为2D对象
		this.defaultStroke = new BasicStroke(2);
	}

	/**
	 * 画直线
	 * @param graphics
	 */
	public void draw2DLine(){
		d2.setStroke(defaultStroke);
	    d2.setColor(Color.BLACK);
	    Line2D line=new Line2D.Double(100,100,100,500);//创建line对象
	    d2.draw(line);//画出2D直线

	}

	/**
	 * 画矩形
	 * @param graphics
	 */
	public void draw2DRect(){
		d2.setStroke(defaultStroke);
	    d2.setColor(Color.BLACK);
	    Rectangle2D rect=new Rectangle2D.Double(100,100,100,60);//创建矩形对象
	    d2.draw(rect);//画出矩形

	}
	
	/**
	 * 画圆角矩形
	 * @param graphics
	 */
	public void draw2DRoundRect(){
		d2.setStroke(defaultStroke);
	    d2.setColor(Color.BLACK);
	    RoundRectangle2D rect=new RoundRectangle2D.Double(250,100,100,60,20,20);//创建矩形对象
	    d2.draw(rect);//画出矩形
	}
	
	/**
	 * 画出椭圆
	 * @param graphics
	 */
	public void drawEllipse(){
		d2.setStroke(defaultStroke);
	    d2.setColor(Color.BLACK);
	    Ellipse2D  ellipse =new Ellipse2D.Double(200,100,100,60);//创建椭圆对象
	    d2.draw(ellipse);//画出椭圆
	}
	
	/**
	 * 画菱形
	 * @param graphics
	 */
	public void draw2DDiamond(){
		d2.setStroke(defaultStroke);
		d2.setColor(Color.BLACK);
		Polygon polygon=new Polygon();  // 创建多边形对象
		polygon.addPoint(250,300);
		polygon.addPoint(200,270);
		polygon.addPoint(250,240);
		polygon.addPoint(300,270);
		d2.drawPolygon(polygon);
	}
}
