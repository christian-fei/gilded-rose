package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {
    
    @Test
	public void
	increases_quality_by_3_for_concert_ticket_when_sellin_less_than_6_and_quality_less_than_50() throws Exception {
        int initialQuality = 30;
		Item[] items = createItemsWith("Backstage passes to a TAFKAL80ETC concert", 5, initialQuality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(initialQuality + 3, app.items[0].quality);    	
	}
    
    @Test
	public void
	increases_quality_by_2_for_concert_ticket_when_sellin_less_than_11_and_quality_less_than_50() throws Exception {
        int initialQuality = 30;
		Item[] items = createItemsWith("Backstage passes to a TAFKAL80ETC concert", 10, initialQuality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(initialQuality + 2, app.items[0].quality);    	
	}
    
    @Test
	public void
	increases_quality_for_aged_brie_while_quality_is_less_than_50() throws Exception {
    	for(int initialQuality=0; initialQuality <= 50; initialQuality++) {
    		Item[] items = createItemsWith("Aged Brie", 10, initialQuality);
    		GildedRose app = new GildedRose(items);
    		app.updateQuality();
    		if( initialQuality < 50 ){
    			assertEquals(initialQuality + 1, app.items[0].quality);    	
    		} else {
    			assertEquals(initialQuality, app.items[0].quality);    	
    		}
    	}
	}

	private Item[] createItemsWith(String itemName, int itemSellin, int initialQuality) {
		return new Item[] { new Item(itemName, itemSellin, initialQuality) };
	}

}
