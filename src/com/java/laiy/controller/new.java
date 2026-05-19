package com.java.laiy.controller;

import java.util.ArrayList;
import java.util.List;

import com.java.laiy.model.Player;
import com.java.laiy.model.Point;
import com.java.laiy.model.exceptions.PointOccupiedException;
import com.java.laiy.view.IView;

public class Game {

	private final IView iview;
	private final GameController gameController;

	public Game(IView iview) {
		this.iview = iview;
		this.gameController = iview.getGameController();
	}

	public void theGame() {

		while (gameController.getNextTurn()) {
			final Point point = iview.startTurn();
			try {
				final Player currentPlayer = gameController.getCurrentPlayer(gameController.getPlayers()[0]);
				gameController.move(point.getX(), point.getY(), currentPlayer);
			} catch (PointOccupiedException e) {
				iview.showPointOccupied();
			}
			iview.showBoard();
		}

		if (gameController.getWinner() != null) {
			iview.showWinner();
		} else {
			iview.showDraw();
		}

		iview.anotherGame();
	}

	public void logPlayers() {
		final List<String> playerNames = new ArrayList<>();
		for (int i = 0; i < gameController.getPlayers().length; i++) {
			playerNames.add(gameController.getPlayers()[i].getName());
		}
	}

	protected GameController getGameController() throws Exception {
		return gameController;
	}
}