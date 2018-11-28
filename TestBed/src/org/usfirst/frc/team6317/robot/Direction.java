package org.usfirst.frc.team6317.robot;

public enum Direction {
	LEFT('L'),
	RIGHT('R');
	
	public static final Direction[] VALUES = values();
	
	private final char c;
	
	private Direction(char c) {
		this.c = c;
	}
	
	public char toChar() {
		return this.c;
	}
	
	public Direction opposite() {
		switch (this) {
			case LEFT: return RIGHT;
			case RIGHT: return LEFT;
			default: return null;
		}
	}
	
	public static Direction fromChar(char c) {
		for (Direction d : VALUES)
			if (d.toChar() == c)
				return d;
		return null;
	}
}
