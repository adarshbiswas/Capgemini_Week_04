package design_voting_system;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {
    class Voting {
        private Map<String, Integer> votesCount = new HashMap<>();
        private LinkedHashMap<String, Integer> votingOrder = new LinkedHashMap<>();
        private TreeMap<String, Integer> sortedResult = new TreeMap<>();

        private void castVote(String candidate) {
            votesCount.put(candidate, votesCount.getOrDefault(candidate, 0) + 1);
            votingOrder.put(candidate, votesCount.get(candidate));
            sortedResult.put(candidate, sortedResult.get(candidate));
        }

        public void displayVotesInOrder() {
            System.out.println("\nVotes in the Order of Voting:");
            for (Map.Entry<String, Integer> entry : votingOrder.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
            }
        }

        // Method to display votes sorted alphabetically by candidate name
        public void displaySortedResults() {
            System.out.println("\nVotes Sorted by Candidate Name:");
            for (Map.Entry<String, Integer> entry : sortedResult.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
            }
        }

        public void findWinner() {
            String winner = null;
            int maxVotes = 0;
            for (Map.Entry<String, Integer> entry : votesCount.entrySet()) {
                if (entry.getValue() > maxVotes) {
                    maxVotes = entry.getValue();
                    winner = entry.getKey();
                }
            }
            System.out.println("\n🏆 Winner: " + winner + " with " + maxVotes + " votes!");
        }
    }

    public void main(String[] args) {
        Voting votingSystem = new Voting();

        votingSystem.castVote("Arnav");
        votingSystem.castVote("Nire");
        votingSystem.castVote("Aman");
        votingSystem.castVote("Jadu");
        votingSystem.castVote("Arnav");
        votingSystem.castVote("Abhay");

        // Display results
        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedResults();
        votingSystem.findWinner();
    }
}
