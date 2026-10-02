import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    // Public no-argument constructor
    public LibraryMember() {
    }

    // Write-once membershipId
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Premium member
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only security answer
    public void setSecurityAnswer(String answer) {

        try {

            MessageDigest md =
                MessageDigest.getInstance("SHA-256");

            byte[] hash =
                md.digest(
                    answer.getBytes(
                        StandardCharsets.UTF_8
                    )
                );

            StringBuilder hex = new StringBuilder();

            for (byte b : hash) {
                hex.append(
                    String.format("%02x", b)
                );
            }

            securityAnswer = hex.toString();

        } catch (Exception e) {
            securityAnswer = null;
        }
    }

    public static void main(String[] args) {

        LibraryMember m = new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(
            m.getMembershipId()
        );

        // Second call is ignored
        m.setMembershipId("FAKE-0000");

        System.out.println(
            m.getMembershipId()
        );

        System.out.println(
            m.isPremiumMember()
        );

        m.setSecurityAnswer("BlueMountain");

        System.out.println(
            "Security answer stored securely."
        );
    }
}