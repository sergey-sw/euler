package org.skywind.one;

import org.skywind.util.ResourceTools;

import java.util.*;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 30/05/2017.
 */
public class P054 {

    public static void main(String[] args) throws Exception {
        int p1Win = 0;
        for (String line : ResourceTools.lines("/p054-cards.txt")) {
            List<String> cards = Arrays.asList(line.split("\\s+"));
            Hand hand1 = new FiveCards(cards.subList(0, 5)).getBest();
            Hand hand2 = new FiveCards(cards.subList(5, 10)).getBest();

            int p1Score = hand1.score();
            int p2Score = hand2.score();

            if (p1Score > p2Score || p1Score == p2Score && hand1.compareTo(hand2) > 0) {
                p1Win++;
            }
        }
        System.out.println(p1Win);
    }

    static class FiveCards {

        Map<Integer, List<Character>> rank2Suits = new HashMap<>();
        int[] ranks = new int[5];
        char[] suits = new char[5];

        FiveCards(List<String> strings) {
            int n = 0;
            for (String string : strings) {
                Card card = Card.parse(string);
                ranks[n] = card.getRank();
                suits[n] = card.getSuit();
                rank2Suits.computeIfAbsent(card.rank, r -> new ArrayList<>()).add(card.getSuit());
                n++;
            }
            Arrays.sort(ranks);
            Arrays.sort(suits);
        }

        Hand getBest() {
            for (Hand hand : createHand()) {
                if (hand.match(this)) {
                    return hand;
                }
            }
            throw new IllegalStateException("at least 1 hand should match");
        }

        boolean isFlush() {
            char suit = suits[0];
            for (char s : suits) {
                if (suit != s) return false;
            }
            return true;
        }
    }

    static class Card {
        int rank;
        char suit;

        int getRank() {
            return rank;
        }

        char getSuit() {
            return suit;
        }

        static Card parse(String str) {
            Card card = new Card();
            card.rank = card2Score.get(str.substring(0, 1));
            card.suit = str.charAt(str.length() - 1);
            return card;
        }
    }

    private static final Map<String, Integer> card2Score = new HashMap<>();

    static {
        int val = 2;
        for (String v : Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A")) {
            card2Score.put(v, val++);
        }
    }

    interface Hand<T extends Hand<T>> extends Comparable<T> {

        boolean match(FiveCards cards);

        int score();
    }

    static class HighCard implements Hand<HighCard> {

        int[] r;

        @Override
        public boolean match(FiveCards cards) {
            r = cards.ranks;
            return true;
        }

        @Override
        public int compareTo(HighCard o) {
            for (int i = 4; i >= 0; i++) {
                int cmp = Integer.compare(r[i], o.r[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        }

        @Override
        public int score() {
            return 1;
        }
    }

    static class Group implements Hand<Group> {

        final int size;
        int val;
        int[] r;

        Group(int size) {
            this.size = size;
        }

        @Override
        public boolean match(FiveCards fiveCards) {
            for (Map.Entry<Integer, List<Character>> e : fiveCards.rank2Suits.entrySet()) {
                if (e.getValue().size() == size) {
                    val = e.getKey();
                }
            }
            r = fiveCards.ranks;
            return val != 0;
        }

        @Override
        public int compareTo(Group o) {
            int cmp = Integer.compare(val, o.val);
            if (cmp == 0) {
                for (int i = 4; i >= 0; i++) {
                    cmp = Integer.compare(r[i], o.r[i]);
                    if (cmp != 0) return cmp;
                }
                return 0;
            }
            return cmp;
        }

        @Override
        public int score() {
            return size == 2 ? 2 : size == 3 ? 4 : 8;
        }
    }

    static class TwoPairs implements Hand<TwoPairs> {

        int lowPair;
        int highPair;
        int highCard;

        @Override
        public boolean match(FiveCards fiveCards) {
            int[] r = fiveCards.ranks;
            if (r[0] == r[1] && r[2] == r[3]
                    || r[0] == r[1] && r[3] == r[4]
                    || r[1] == r[2] && r[3] == r[4]) {
                lowPair = r[1];
                highPair = r[3];
                highCard = Arrays.stream(r).filter(x -> x != lowPair && x != highPair).max().getAsInt();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(TwoPairs o) {
            if (highPair > o.highPair) return 1;
            else if (highPair < o.highPair) return -1;
            else {
                if (lowPair > o.lowPair) return 1;
                else if (lowPair < o.lowPair) return -1;
                else return Integer.compare(highCard, o.highCard);
            }
        }

        @Override
        public int score() {
            return 3;
        }
    }

    static class Straight implements Hand<Straight> {

        int max;

        @Override
        public boolean match(FiveCards cards) {
            for (int i = 1; i < 5; i++) {
                if (cards.ranks[i] != cards.ranks[i - 1] + 1) {
                    return false;
                }
            }
            max = cards.ranks[4];
            return true;
        }

        @Override
        public int score() {
            return 5;
        }

        @Override
        public int compareTo(Straight o) {
            return Integer.compare(max, o.max);
        }
    }

    static class Flush implements Hand<Flush> {

        int[] r;

        @Override
        public boolean match(FiveCards cards) {
            if (!cards.isFlush()) return false;
            r = cards.ranks;
            return true;
        }

        @Override
        public int score() {
            return 6;
        }

        @Override
        public int compareTo(Flush o) {
            for (int i = 4; i >= 0; i++) {
                int cmp = Integer.compare(r[i], o.r[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        }
    }

    static class FullHouse implements Hand<FullHouse> {

        int max;

        @Override
        public boolean match(FiveCards cards) {
            int[] r = cards.ranks;

            if (r[0] == r[1] && r[2] == r[3] && r[3] == r[4]) {
                max = r[3];
                return true;
            } else if (r[0] == r[1] && r[1] == r[2] && r[3] == r[4]) {
                max = r[0];
                return true;
            }
            return false;
        }

        @Override
        public int score() {
            return 7;
        }

        @Override
        public int compareTo(FullHouse o) {
            return Integer.compare(max, o.max);
        }
    }

    static class StraightFlush implements Hand<StraightFlush> {

        int max;

        @Override
        public boolean match(FiveCards cards) {
            for (int i = 1; i < 5; i++) {
                if (cards.ranks[i] != cards.ranks[i - 1] + 1) {
                    return false;
                }
            }
            max = cards.ranks[4];
            return true;
        }

        @Override
        public int score() {
            return 9;
        }

        @Override
        public int compareTo(StraightFlush o) {
            return Integer.compare(max, o.max);
        }
    }

    static class RoyalFlush implements Hand<RoyalFlush> {

        @Override
        public boolean match(FiveCards cards) {
            for (int i = 1; i < 5; i++) {
                if (cards.ranks[i] != cards.ranks[i - 1] + 1) {
                    return false;
                }
            }
            return cards.ranks[4] == 14;
        }

        @Override
        public int score() {
            return 10;
        }

        @Override
        public int compareTo(RoyalFlush o) {
            return 0;
        }
    }

    static List<Hand> createHand() {
        List<Hand> list = Arrays.asList(
                new HighCard(),
                new Group(2),
                new TwoPairs(),
                new Group(3),
                new Straight(),
                new Flush(),
                new FullHouse(),
                new Group(4),
                new StraightFlush(),
                new RoyalFlush()
        );
        Collections.reverse(list);
        return list;
    }
}
