package Controllers;

import java.util.Scanner;

import Constants.HitStatus;
import Constants.Constants;
import Factories.RandomlyLocatedShipFactory;
import Interfaces.IRandomlyLocatedShipFactory;
import Model.Battlefield;
import Model.Point;
import Utils.CollisionDetector;
import Utils.DataValidator;
import Utils.RandomGenerator;

public class BattleshipController
{
	private DataValidator validator = new DataValidator();
	private IRandomlyLocatedShipFactory factory = new RandomlyLocatedShipFactory(new RandomGenerator());
	private CollisionDetector detector = new CollisionDetector();

	private Battlefield battleField= new Battlefield(factory, detector, validator);
	private Scanner scanner;
	private int shipsDown;

	public void startGame() throws Exception
	{
		scanner = new Scanner(System.in);	
		this.battleField.init();
		shipsDown = 0;
		while (true)
		{
			System.out.println("Enter your target (e.g. : A3, B4 or D10):");
			String move = scanner.next();
			Point hit = this.validator.tryGetValidInput(move);
			if (hit == null)
			{
				System.out.println("Invalid input. It should contain an upper case character between A and J followed by an integer between 1 and 10, without any spaces. E.g.: \"A10\" or \"B5\"");
			}
			else
			{
				int hitStatus = battleField.tryHit(hit);

				switch(hitStatus)
				{
					case HitStatus.ALREADYHIT:
						System.out.println("Ship was already hit at this target.");
						break;
					case HitStatus.ALREADYSANKED:
						System.out.println("You are trying to attack an already sanked ship.");
						break;
					case HitStatus.MISS:
						System.out.println("You missed :-(, try again.");
						break;
					case HitStatus.SHIPHIT:
						System.out.println("You hit a ship, good job !");
						break;
					case HitStatus.SHIPSANKED:
					{
						System.out.println("Congratulations, you sanked a ship.");
						shipsDown++;
						break;
					}
	
					default:
						// This should be never reached
						System.out.println("Something wrong just happened, sorry for inconvenience");
						return;
				}

				if (shipsDown == Constants.TOTAL_SHIPS_NO)
				{
					System.out.println("Congratulations for VICTORY, you conquered the battlefield.");
					return;
				}
			}
		}
	}
}