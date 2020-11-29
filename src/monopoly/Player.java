package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import monopoly.cells.PropertyCell;
import monopoly.cells.RailRoadCell;
import monopoly.cells.UtilityCell;
import monopoly.enums.ColorGroup;

public class Player {
    private final int INITIAL_MONEY = 1500;
    private boolean inJail;
    private int money;
    private String name;
    private boolean isOutOfGame;
    private Color playerColor;
    private Cell position;
    private List<PropertyCell> properties = new ArrayList<>();
    //the key of propertyColors is the name of the playerColor group.
    private final Map<ColorGroup, Integer> propertyColors = new HashMap<>();
    private List<RailRoadCell> railroads = new ArrayList<>();
    private List<UtilityCell> utilities = new ArrayList<>();
    
    public Player(Cell position) {
        this.position = position;
        inJail = false;
        isOutOfGame = false;
        playerColor = Color.GREEN;
        money = INITIAL_MONEY;
    }
    
    //adding money
    public void addMoney(int money) {
        this.money += money;
    }

    public void addProperty(PropertyCell property) {
        properties.add(property);
        addPropertyColor(property.getColorGroup());
    }
    
    private void addPropertyColor(ColorGroup colorGroup) {
        propertyColors.put(colorGroup, getPropertyNumberForColor(colorGroup) + 1);
    }
    
    public void addRailRoad(RailRoadCell railroad) {
        railroads.add(railroad);
        addPropertyColor(ColorGroup.RAILROAD);
    }
    
    public void addUtility (UtilityCell utility) {
        utilities.add(utility);
        addPropertyColor(ColorGroup.UTILITY);
    }

    public boolean checkProperty(String property) {
        return properties.stream().map((propertie) -> 
                (Cell) propertie).anyMatch((cell) -> 
                (cell.getName().equals(property)));
    }

    public List<Cell> getAllProperties() {
        List<Cell> list = new ArrayList<>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return list;
    }

    //return the amount of money to this player
    public int getMoney() {
            return this.money;
    }

    //return the player name
    public String getName() {
        return name;
    }
    
    //return the player color
    public Color getPlayerColor() {
        return playerColor;
    }

    //return the cell postion
    public Cell getPosition() {
        return this.position;
    }
	
    public PropertyCell getProperty(int index) {
        return properties.get(index);
    }
    
    public List<PropertyCell> getPropertyCells() {
        return properties;
    }
    
    public Map<ColorGroup, Integer> getPropertyColors() {
        return propertyColors;
    }
	
    public int getPropertyCount() {
        return properties.size();
    }
    
    //return number of cells have the same color
    private int getPropertyNumberForColor(ColorGroup colorGroup) {
        Integer number = propertyColors.get(colorGroup);
        if (number != null) {
            return number;
        }
        return 0;
    }
    
    public List<RailRoadCell> getRailRoadCells() {
        return railroads;
    }

    public List<UtilityCell> getUtilityCells() {
        return utilities;
    }
    
    //check if the player has money or not
    public boolean isBankrupt() {
        return money <= 0;
    }

    //check if the player at the jail or not
    public boolean isInJail() {
        return inJail;
    }

    //check if the player in the game or out
    public boolean isOutOfGame() {
        return isOutOfGame;
    }
    
    public int numberOfRailroads() {
        return railroads.size();
    }

    public int numberOfUtilities() {
        return utilities.size();
    }
    
    public void removePropertyCell(PropertyCell property) {
        properties.remove(property);
        removePropertyColor(property.getColorGroup());
    }
    
    private void removePropertyColor(ColorGroup colorGroup) {
        propertyColors.remove(colorGroup);
    }
    
    public void removeRailroadCell(RailRoadCell railroad) {
        railroads.remove(railroad);
        removePropertyColor(ColorGroup.RAILROAD);
    }
    
    public void removeUtilityCell(UtilityCell utility) {
        utilities.remove(utility);
        removePropertyColor(ColorGroup.UTILITY);
    }
    
    public void resetProperties() {
        properties = new ArrayList<>();
        railroads = new ArrayList<>();
        utilities = new ArrayList<>();
    }
    
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setOutOfGame() {
        isOutOfGame = true;
    }
    
    public void setPlayerColor(Color color) {
        this.playerColor = color;
    }

    public void setPosition(Cell newPosition) {
        this.position = newPosition;
    }
    
    public void subtractMoney(int money) {
        this.money -= money;
    }
  
    @Override
    public String toString() {
        return name;
    }
}
