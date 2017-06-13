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

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		
		removeAll();
		
		
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
	}
	
	private void drawGraph(){
		
		GLine topMargin = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		graph.add(topMargin);
		
		GLine botMargin = new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE);
		graph.add(botMargin);
		
		for(int i=1;i<NDECADES;i++){
			
		GLine decadeColumns = new GLine((getWidth()/NDECADES)*i,0,(getWidth()/NDECADES)*i,getHeight());
		graph.add(decadeColumns);
		
		}
		
		
		for(int i= 0;i<NDECADES;i++){
		String label = Integer.toString(START_DECADE+(i*10));	
		GLabel year = new GLabel(label,(getWidth()/NDECADES)*i+5,getHeight()-5);
		graph.add(year); 	
		}
		
		add(graph);
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		graph.removeAll();
		drawGraph();
	}
	
	
	
	
	/* Implementation of the ComponentListener interface */
	private GCompound graph = new GCompound();
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
