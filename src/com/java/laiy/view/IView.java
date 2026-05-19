package com.java.laiy.view;

import com.java.laiy.controller.GameController;
import com.java.laiy.model.Point;

public interface IView {

	Point startTurn();

	void showGameName();

	void showPlayers();

	void showBoard();

	void showWinner();

	void showDraw();

	void anotherGame();

	void showPointOccupied();

	GameController getGameController();

}
