package gui;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */

import geo.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;



public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;

	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(@NotNull GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);

	}
	public GUIShape(String line) {
		init(line.split(","));
	}

	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;

	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape (this);
		return cp;
	}
	@Override
	public String toString() {
		if(_g instanceof Circle_2D)		{_g = (Circle_2D)_g;}
		if(_g instanceof Polygon_2D)	{_g = (Polygon_2D)_g;}
		if(_g instanceof Rect_2D)		{_g = (Rect_2D)_g;}
		if(_g instanceof Segment_2D)	{_g = (Segment_2D)_g;}
		if(_g instanceof Triangle_2D)	{_g = (Triangle_2D)_g;}
		return ("GUIShape," + (_color.getBlue() + _color.getGreen() * 256 + _color.getRed() * 65536) + "," + _fill + "," + _tag + "," +_g.toString());
	}
	private void init(String[] ww) {

	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	@Override
	public void setShape(GeoShape g) {
		// TODO Auto-generated method stub
		this._g = g;

	}
}
