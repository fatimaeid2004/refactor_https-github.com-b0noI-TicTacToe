package com.java.laiy.model;

import com.java.laiy.model.exceptions.InvalidBoardSizeException;
import com.java.laiy.model.exceptions.InvalidPointException;

public class Board {

	private static final int MIN_COORDINATE = 0;
	private static final int DEFAULT_BOARD_SIZE = 3;
	private final Figure[][] figures;

	public Board() throws InvalidBoardSizeException {
		this(DEFAULT_BOARD_SIZE);
	}

	public Board(final int customBoardSize) throws InvalidBoardSizeException {
		if (customBoardSize < DEFAULT_BOARD_SIZE) {
			this.figures = new Figure[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
			throw new InvalidBoardSizeException();
		} else {
			this.figures = new Figure[customBoardSize][customBoardSize];
		}
	}

	public void setFigure(final int x, final int y, final Figure figure) throws InvalidPointException {
		if (!checkCoordinates(x, y)) {
			throw new InvalidPointException();
		}
		figures[x][y] = figure;
	}

	public Figure getFigure(final int x, final int y) throws InvalidPointException {
		if (checkCoordinates(x, y)) {
			return figures[x][y];
		} else {
			throw new InvalidPointException();
		}
	}

	public Figure[][] getFiguresArray() {
		return figures;
	}

	public int getBoardHeight() {
		return figures != null ? figures.length : 0;
	}

	private boolean checkCoordinates(final int x, final int y) {
		final boolean xValid = (x >= 0 && x < figures.length);
		final boolean yValid = (y >= 0 && y < figures.length);
		return xValid && yValid;
	}

	public boolean isCoordinateInside(int coord) {
		final boolean condition = coord >= 0 && coord < figures.length;
		return condition ? true : false;
	}

	public Integer getBoardCapacity() {
		final int total = figures.length * figures[0].length;
		return Integer.valueOf(total);
	}
}