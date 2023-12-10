package jbnu.ssad1.medel.entity;

public class Booking {
    private Long id;
    private Member member;
    private Screening screening;

    public Booking(Member member, Screening screening) {
        this.member = member;
        this.screening = screening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
