
/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);
		entryArray = new ArrayList<NameSurferEntry>();
	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		entryArray.clear();
		update();

	}

	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display. Note
	 * that this method does not actually draw the graph, but simply stores the
	 * entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {

		entryArray.add(entry);

	}

	private void drawGraph() {
		/* adds top and bottom horizontal lines */

		GLine topMargin = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		graph.add(topMargin);

		GLine botMargin = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
		graph.add(botMargin);

		/* adds column lines */
		for (int i = 1; i < NDECADES; i++) {

			GLine decadeColumns = new GLine((getWidth() / NDECADES) * i, 0, (getWidth() / NDECADES) * i, getHeight());
			graph.add(decadeColumns);

		}

		/* adds date labels */

		for (int i = 0; i < NDECADES; i++) {
			String label = Integer.toString(START_DECADE + (i * 10));
			GLabel year = new GLabel(label, (getWidth() / NDECADES) * i + 5, getHeight() - 5);
			graph.add(year);
		}

		add(graph);
	}

	/**
	 * Updates the display image by deleting all the graphical objects from the
	 * canvas and then reassembling the display according to the list of
	 * entries. Your application must call update after calling either clear or
	 * addEntry; update is also called whenever the size of the canvas changes.
	 */
	public void update() {
		removeAll();
		graph.removeAll();
		drawGraph();

		for (int i = 0; i < entryArray.size(); i++) {

			drawEntry(entryArray.get(i),i);
			
			
		}
	}

	private void drawEntry(NameSurferEntry entry,int color) {
		double spacing = getWidth() / NDECADES;
		for (int i = 0; i < NDECADES - 1; i++) {

			GLine data = new GLine(spacing * i, getRankY(entry.getRank(i)),
					spacing * (i + 1), getRankY(entry.getRank(i + 1)));
			
			data.setColor(colorCycle(color));
			add(data);
		}
	}

	private double getRankY(int rank) {
		double rankD = rank;
		
		if (rank != 0) {
			rankD = ((rankD / MAX_RANK) * getHeight()-2*GRAPH_MARGIN_SIZE) 
			
			
		} else {
			rankD = getHeight() - GRAPH_MARGIN_SIZE;
			
		}
		return rankD;
	}

	private Color colorCycle(int color) {
		
		switch (color) {

		case 0:
			return Color.BLACK;
		case 1:
			return Color.RED;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.MAGENTA;

		}
		return Color.BLACK;

	}

	/* Implementation of the ComponentListener interface */

	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
		update();
	}

	public void componentShown(ComponentEvent e) {
	}

	/* instance variables */
	private int color = 0;
	private GCompound graph = new GCompound();
	private ArrayList<NameSurferEntry> entryArray;
}