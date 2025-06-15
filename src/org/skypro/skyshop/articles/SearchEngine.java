package org.skypro.skyshop.articles;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String term) {

        Set<Searchable> resultsSet = new TreeSet<>(new SearchableComparator());
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(term)) {
                resultsSet.add(item);
            }
        }
        return resultsSet;
    }

    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            // First compare by name length in reverse order
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            // If lengths are equal, compare by natural order
            return s1.getName().compareTo(s2.getName());
        }
    }


    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable item : searchableItems) {
            if (item != null) {
                int currentCount = countOccurrences(item.getSearchTerm(), search);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

}



