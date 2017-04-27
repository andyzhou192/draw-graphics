package com.graphics;

import java.awt.BorderLayout;
//import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JToolBar;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("绘图");
		JRootPane pane = new JRootPane();
		frame.setLayout(new BorderLayout());
		frame.add(pane);
		frame.setSize(900, 600);
//		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Graphics g = pane.getGraphics();
//		final Graphics2DUtil gu = new Graphics2DUtil(g);
		final MouseAdapterImpl adapter = new MouseAdapterImpl();
		JButton drawLineBtn = new JButton(new AbstractAction("DrawLine"){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				//gu.draw2DLine();
				adapter.setShape(MouseAdapterImpl.STRAIGHT_LINE_2D);
			}
		});
		JButton drawDiamondBtn = new JButton(new AbstractAction("DrawDiamond"){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				//gu.draw2DDiamond();
				adapter.setShape(MouseAdapterImpl.DIAMOND_2D);
			}
		});
		JButton drawRectBtn = new JButton(new AbstractAction("DrawRect"){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				//gu.draw2DRect();
				adapter.setShape(MouseAdapterImpl.RECT_2D);
			}
		});
		JButton drawRoundRectBtn = new JButton(new AbstractAction("DrawRoundRect"){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				//gu.draw2DRoundRect();
				adapter.setShape(MouseAdapterImpl.ROUND_RECT_2D);
			}
		});
		JButton drawEllipseBtn = new JButton(new AbstractAction("DrawEllipse"){
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				//gu.drawEllipse();
				adapter.setShape(MouseAdapterImpl.ELLIPSE_2D);
			}
		});
		JToolBar toolBar = new JToolBar();
		toolBar.add(drawLineBtn);
		toolBar.add(drawDiamondBtn);
		toolBar.add(drawRectBtn);
		toolBar.add(drawRoundRectBtn);
		toolBar.add(drawEllipseBtn);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(adapter.getCans(), BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
