import java.util.Random;

public class Ant {

	int x, y, steps = 0;
	static boolean[][] map = new boolean[1024][768];

	enum dir {
		NORTH, WEST, SOUTH, EAST
	};

	dir direction;

	Ant(int x, int y) {
		direction = dir.NORTH;
		this.x = x;
		this.y = y;
	}

	Ant() {
		Random r = new Random();
		int d = r.nextInt(5);
		if (d == 1)
			direction = dir.NORTH;
		else if (d == 2)
			direction = dir.WEST;
		else if (d == 2)
			direction = dir.SOUTH;
		else
			direction = dir.EAST;
		this.x = r.nextInt(1024);
		this.y = r.nextInt(768);
	}

	void move() {
		if (map[x][y]) {
			map[x][y] = false;
			turnRight();
		} else {
			map[x][y] = true;
			turnLeft();
		}
		forward();
		steps++;
		edges();
	}

	void turnLeft() {
		if (direction == dir.NORTH)
			direction = dir.WEST;
		else if (direction == dir.EAST)
			direction = dir.NORTH;
		else if (direction == dir.SOUTH)
			direction = dir.EAST;
		else
			direction = dir.SOUTH;
	}

	void turnRight() {
		if (direction == dir.NORTH)
			direction = dir.EAST;
		else if (direction == dir.EAST)
			direction = dir.SOUTH;
		else if (direction == dir.SOUTH)
			direction = dir.WEST;
		else
			direction = dir.NORTH;
	}

	void forward() {
		if (direction == dir.NORTH)
			y -= 1;
		else if (direction == dir.EAST)
			x += 1;
		else if (direction == dir.SOUTH)
			y += 1;
		else
			x -= 1;
	}

	void edges() {
		if (x > 1023)
			x = 0;
		if (x < 0)
			x = 1023;
		if (y > 767)
			y = 0;
		if (y < 0)
			y = 767;
	}
}
