package org.skypro.skyshop.articles;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count = 0;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count++] = item;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(term)) {
                results[resultCount++] = item;
                if (resultCount == 5) break;
                if (resultCount == results.length) {
                    break;
                }
            }
        }
        return results;
    }
}