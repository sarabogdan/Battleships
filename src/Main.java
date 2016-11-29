import Controllers.BattleshipController;

public class Main {

	public static void main(String[] args) {

		BattleshipController bc = new BattleshipController();
		try {
			System.out.println("Welcome to Battleship :)");
			bc.startGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


