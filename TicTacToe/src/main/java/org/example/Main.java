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


            // USER STORY 3: Sieg, Niederlage, Unentschieden anzeigen
            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                switchCurrentPlayer();
            }
        }

    }

    // USER STORY 4: Neues Spiel starten
        System.out.print("Play again? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
        start();
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

        public boolean hasWinner() {
            char m = currentPlayer.getMarker();
            for (int i = 0; i < 3; i++) {
                if (board.getCell(i, 0) == m && board.getCell(i, 1) == m && board.getCell(i, 2) == m) return true;
                if (board.getCell(0, i) == m && board.getCell(1, i) == m && board.getCell(2, i) == m) return true;
            }
            if (board.getCell(0, 0) == m && board.getCell(1, 1) == m && board.getCell(2, 2) == m) return true;
            if (board.getCell(0, 2) == m && board.getCell(1, 1) == m && board.getCell(2, 0) == m) return true;
            return false;
        }

        public static void main(String[] args) {
            Main game = new Main();
            game.start();
        }
}
