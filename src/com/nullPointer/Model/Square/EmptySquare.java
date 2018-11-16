package com.nullPointer.Model.Square;
import com.nullPointer.Model.GameEngine;
import com.nullPointer.Model.Player;

public class EmptySquare extends Square {

	public EmptySquare(String n, String t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void evaluateSquare(GameEngine gameEngine) {
		gameEngine.publishEvent("doNothing");
	}

}
