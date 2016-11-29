package Interfaces;

import Model.BaseShip;

public interface IRandomlyLocatedShipFactory {

	BaseShip GenerateRandomShip(int length) throws Exception;
}