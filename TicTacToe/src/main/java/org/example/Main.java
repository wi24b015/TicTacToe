package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public Main() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void start() {
        board.clear();
        boolean gameOver = false;
        while (!gameOver) {
            // USER STORY 1: Spieler wählt ein freies Feld
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print(); // USER STORY 2: Spielstand anzeigen

            int x = ask("Row (0-2): ");
            int y = ask("Column (0-2): ");

            if (x < 0 || x > 2 || y < 0 || y > 2 || !board.isCellEmpty(x, y)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.place(x, y, currentPlayer.getMarker());
        }
    }

    private int ask(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 0 and 2.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
}