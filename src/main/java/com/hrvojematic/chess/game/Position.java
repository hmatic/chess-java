package com.hrvojematic.chess.game;

/**
 * Encapsulates coordinate data for position on chess board.
 * Provides cached Position objects for positions on 8x8 chess board.
 * @author Hrvoje Matić
 * @version 1.0
 */
public class Position {
	/**
	 * X-axis coordinate.
	 */
	private final int x;
	/**
	 * Y-axis coordinate.
	 */
	private final int y;
	
	/** Minimum x coordinate on chess board. */
	private static final int MIN_X = 1;
	/** Maximum x coordinate on chess board. */
	private static final int MAX_X = 8;
	/** Minimum y coordinate on chess board. */
	private static final int MIN_Y = 1;
	/** Maximum y coordinate on chess board. */
	private static final int MAX_Y = 8;
	
	/**
	 * Two-dimensional array of cached Position objects.
	 */
	private static final Position[][] POSITION_CACHE = 
			new Position[MAX_X][MAX_Y];
	
	static {
		for(int x=MIN_X; x<=MAX_X; x++) {
			for(int y=MIN_Y; y<=MAX_Y; y++) {
				POSITION_CACHE[x-1][y-1] = new Position(x,y);
			}
		}
	}
	
	/**
	 * Private default constructor for Position.
	 * Will throw exception if coordinates given in 
	 * arguments are out of bounds.
	 * @param x x-axis coordinate
	 * @param y y-axis coordinate
	 * @throws IllegalArgumentException if coordinates are out of bounds
	 */
	private Position(int x, int y) {
		if(x<MIN_X || x>MAX_X || y<MIN_Y || y>MAX_Y) {
			throw new IllegalArgumentException("Bounds for position "
					+ "coordinates are: x[" + MIN_X + "," + MAX_X +
					"] y[" + MIN_Y + "," + MAX_Y + "]. Given coordinates"
							+ " were: x=" + x + ",y=" + y + ".");
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for x coordinate.
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter for y coordinate.
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Factory method for Position. Used to construct Position 
	 * object outside of this class as it provides support for cache.
	 * @param x x-axis coordinate
	 * @param y y-axis coordinate
	 * @return produced Position object
	 */
	public static Position get(int x, int y) {
		if(x>=MIN_X && x<=MAX_X && y>=MIN_Y && y<=MAX_Y) {
			return POSITION_CACHE[x-1][y-1];
		} else {
			return new Position(x,y);
		}
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
