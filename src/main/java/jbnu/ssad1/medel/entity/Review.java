package jbnu.ssad1.medel.entity;

public class Review {
    private Long id;
    private Booking booking;
    private Member reviewer;
    private String content;

    public Review(Booking booking, Member reviewer, String content) {
        this.booking = booking;
        this.reviewer = reviewer;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Member getReviewer() {
        return reviewer;
    }

    public void setReviewer(Member reviewer) {
        this.reviewer = reviewer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
