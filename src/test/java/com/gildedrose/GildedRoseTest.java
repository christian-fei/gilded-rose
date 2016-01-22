package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {
	
	@Test
	public void test_nothing() throws Exception {
		int initialQuality = 30;
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].name, "Backstage passes to a TAFKAL80ETC concert");
	}

}