package tests;

import junit.framework.TestCase;
import monopoly.Player;
import monopoly.cells.GoCell;
import monopoly.cells.PropertyCell;
import monopoly.enums.ColorGroup;
import monopoly.gui.InfoFormatter;
import monopoly.gui.infoformatters.GoCellInfoFormatter;
//It starts from the starting point (Go)
public class CellInfoFormatterTest extends TestCase {
    
    public void testGoCellTest() {
        GoCell cell = new GoCell();
        String goLabel = GoCellInfoFormatter.GO_CELL_LABEL;
        assertEquals(goLabel, InfoFormatter.cellInfo(cell));
    }
    //player Own Houses when colllect color Group and order other player to pay rent when landed on it 
    public void testPropertyCellText() {
        String propertyName = "Blue 1";
        ColorGroup propertyColor = ColorGroup.BLUE;
        String ownerName = "Owner1";
        int numHouses = 2;
        int propertyValue = 120;
        int housePrice = 100;
        int rentPrice = 200;
        
        String propertyLabel = "<html><b><font color='" +
                                propertyColor +"'>" + 
                                propertyName + "</font></html>";
        String propertyToolTip = "<html><b><font color='" +
                                propertyColor +"'>" + 
                                propertyName + "</font></b><br>" +
				"Property price: $" + propertyValue +
				"<br>Rent price: $" + rentPrice +
				"<br><br>Owner: " + ownerName +
				"<br><br>Houses ⌂: " + numHouses +
                                "<br>House price: $" + housePrice +
				"</html>";
        PropertyCell cell = new PropertyCell();
        cell.setName(propertyName);
        cell.setPrice(propertyValue);
        cell.setRent(rentPrice);
        cell.setColorGroup(propertyColor);
        cell.setHousePrice(100);
        Player player = new Player(cell);
        player.setName(ownerName);
        cell.setPlayer(player);
        cell.setNumHouses(numHouses);
        assertEquals(propertyLabel, InfoFormatter.cellInfo(cell));
        assertEquals(propertyToolTip, InfoFormatter.cellToolTip(cell));
    }
}
