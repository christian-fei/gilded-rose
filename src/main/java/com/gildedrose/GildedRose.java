package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !isConcertTicket(i)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    	decreaseItemQuality(items[i]);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseItemQuality(items[i]);

                    if (isConcertTicket(i)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseItemQuality(items[i]);
            }

            if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!isConcertTicket(i)) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								decreaseItemQuality(items[i]);
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
                    if (items[i].quality < 50) {
                        increaseItemQuality(items[i]);
                    }
                }
            }
        }
    }

	private int decreaseItemQuality(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private void increaseItemQuality(Item item) {
		item.quality = item.quality + 1;
	}

	private boolean isConcertTicket(int index) {
		return items[index].name.equals("Backstage passes to a TAFKAL80ETC concert");
	}
}
