import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
	private static final int PITS = 6;
	private static final int PLAYERS = 2;
	private int balls = 3;
	private int[][] playerPits = new int[PLAYERS][PITS];
	private int[] kolahas = new int[PLAYERS];
	private boolean running = true;
	private int player = 0;
	private Scanner in = new Scanner(System.in);

	private void initiateBoard(int balls) {
		this.balls = balls;
		for (int player=0 ; player<PLAYERS; player++) {
			for (int pit=0; pit<PITS; pit++ ) {
				playerPits[player][pit] = balls;
			}
		}
		for (int player=0;  player<PLAYERS; player++) {
			kolahas[player] = balls;
		}
	}

	private void draw() {
		System.out.println("\t\t\t  Player 2");
		System.out.println("\t\t6\t5\t4\t3\t2\t1");
		System.out.format("\t\t%d\t%d\t%d\t%d\t%d\t%d%n", playerPits[1][5], playerPits[1][4],
				playerPits[1][3], playerPits[1][2], playerPits[1][1], playerPits[1][0]);
		System.out.format("\t%d\t\t\t\t\t\t\t%d%n", kolahas[1], kolahas[0]);
		System.out.format("\t\t%d\t%d\t%d\t%d\t%d\t%d%n", playerPits[0][0], playerPits[0][1],
				playerPits[0][2], playerPits[0][3], playerPits[0][4], playerPits[0][5]);
		System.out.println("\t\t1\t2\t3\t4\t5\t6");
		System.out.println("\t\t\t  Player 1");
	}

	private void welcome() {
		System.out.println("Welcome to Kohala");
		initiateBoard(readNumberOfBalls());
	}

	private int readNumberOfBalls() {
		System.out.print("Enter number of balls you want to play? [1-6]: ");
		return in.nextInt();
	}

	private void run() {
		while (running) {
			draw();
			inputplayer();
			nextPlayer();
		}
	}

	private void nextPlayer() {
		if (player == 0) {
			player = 1;
			return;
		}
		player = 0;
	}

	public void endGame() {
		running = false;
	}

	public void drawPit(int player, int pit, int balls) {
		playerPits[player][pit] = balls;
		draw();
	}

	public void drawKohala(int player, int balls) {
		kolahas[player] = balls;
		draw();
	}

	private int inputplayer() {
		System.out.format("Player %d, enter the pit to sow [1-6]: ", player+1);
		return player = in.nextInt();
	}

	public static void main(String[] args) {
		Board board = new Board();
		board.welcome();
		board.run();
	}

}
