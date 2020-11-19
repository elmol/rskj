package co.rsk.scoring;

import com.google.common.annotations.VisibleForTesting;

/**
 * PeerScoringInformation is a simple class to expose
 * the recorded scoring information for a peer
 * <p>
 * Created by ajlopez on 12/07/2017.
 */
public class PeerScoringInformation {
    private final int successfulHandshakes;
    private final int failedHandshakes;
    private final int invalidNetworks;
    private final int repeatedMessages;
    private final int validBlocks;
    private final int validTransactions;
    private final int invalidBlocks;
    private final int invalidTransactions;
    private final int invalidMessages;
    private final int timeoutMessages;
    private final int unexpectedMessages;
    private final int invalidHeader;
    private final int score;
    private final int punishments;
    private final boolean goodReputation;
    private final String id;
    private final String type; //todo(techdebt) use an enum or constants

    public PeerScoringInformation(PeerScoring scoring, String id, String type) {
        this.type = type;
        this.goodReputation = scoring.hasGoodReputation();
        this.successfulHandshakes = scoring.getEventCounter(EventType.SUCCESSFUL_HANDSHAKE);
        this.failedHandshakes = scoring.getEventCounter(EventType.FAILED_HANDSHAKE);
        this.invalidNetworks = scoring.getEventCounter(EventType.INVALID_NETWORK);
        this.repeatedMessages = scoring.getEventCounter(EventType.REPEATED_MESSAGE);
        this.validBlocks = scoring.getEventCounter(EventType.VALID_BLOCK);
        this.invalidBlocks = scoring.getEventCounter(EventType.INVALID_BLOCK);
        this.validTransactions = scoring.getEventCounter(EventType.VALID_TRANSACTION);
        this.invalidTransactions = scoring.getEventCounter(EventType.INVALID_TRANSACTION);
        this.invalidMessages = scoring.getEventCounter(EventType.INVALID_MESSAGE);
        this.timeoutMessages = scoring.getEventCounter(EventType.TIMEOUT_MESSAGE);
        this.unexpectedMessages = scoring.getEventCounter(EventType.UNEXPECTED_MESSAGE);
        this.invalidHeader = scoring.getEventCounter(EventType.INVALID_HEADER);
        this.score = scoring.getScore();
        this.punishments = scoring.getPunishmentCounter();
        this.id = id;
    }

    @VisibleForTesting
    public PeerScoringInformation(String type, boolean goodReputation,
                                  int successfulHandshakes, int failedHandshakes,
                                  int invalidNetworks, int repeatedMessages,
                                  int validBlocks, int invalidBlocks, int validTransactions,
                                  int invalidTransactions, int invalidMessages,
                                  int timeoutMessages, int unexpectedMessages,
                                  int invalidHeader, int score, int punishments, String id) {
        this.type = type;
        this.goodReputation = goodReputation;
        this.successfulHandshakes = successfulHandshakes;
        this.failedHandshakes = failedHandshakes;
        this.invalidNetworks = invalidNetworks;
        this.repeatedMessages = repeatedMessages;
        this.validBlocks = validBlocks;
        this.invalidBlocks = invalidBlocks;
        this.validTransactions = validTransactions;
        this.invalidTransactions = invalidTransactions;
        this.invalidMessages = invalidMessages;
        this.timeoutMessages = timeoutMessages;
        this.unexpectedMessages = unexpectedMessages;
        this.invalidHeader = invalidHeader;
        this.score = score;
        this.punishments = punishments;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @VisibleForTesting
    public String getType() { return this.type; }

    public boolean getGoodReputation() {
        return this.goodReputation;
    }

    public int getSuccessfulHandshakes() { return this.successfulHandshakes; }

    public int getFailedHandshakes() { return this.failedHandshakes; }

    public int getInvalidNetworks() { return this.invalidNetworks; }

    public int getRepeatedMessages() { return this.repeatedMessages; }

    public int getValidBlocks() {
        return this.validBlocks;
    }

    public int getScore() {
        return this.score;
    }

    public int getInvalidBlocks() {
        return this.invalidBlocks;
    }

    public int getValidTransactions() {
        return this.validTransactions;
    }

    public int getInvalidTransactions() {
        return this.invalidTransactions;
    }

    public int getInvalidMessages() {
        return this.invalidMessages;
    }

    public int getUnexpectedMessages() {
        return this.unexpectedMessages;
    }

    public int getTimeoutMessages() {
        return this.timeoutMessages;
    }

    public int getInvalidHeader() {
        return this.invalidHeader;
    }

    public int getPunishments() { return this.punishments; }

    public int goodReputationCount() {
        return getGoodReputation() ? 1 : 0;
    }

    public int badReputationCount() {
        return !getGoodReputation() ? 1 : 0;
    }
}


