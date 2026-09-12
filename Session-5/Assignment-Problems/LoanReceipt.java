public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() {

        // Defensive copy
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(
            int index,
            String newId) {

        String[] newBookIds = bookIds.clone();

        if (index >= 0 && index < newBookIds.length) {
            newBookIds[index] = newId;
        }

        return new LoanReceipt(
            memberId,
            newBookIds
        );
    }
}