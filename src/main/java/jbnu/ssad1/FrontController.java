package jbnu.ssad1;

import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.medel.entity.*;
import jbnu.ssad1.money.Money;
import jbnu.ssad1.service.booking.BookingService;
import jbnu.ssad1.service.member.MemberService;
import jbnu.ssad1.service.movie.MovieService;
import jbnu.ssad1.service.payment.PaymentService;
import jbnu.ssad1.service.review.ReviewService;
import jbnu.ssad1.service.screening.ScreeningService;

import java.util.List;

public class FrontController {

    private final AppConfig appConfig;

    private BookingService bookingService;
    private MemberService memberService;
    private MovieService movieService;
    private PaymentService paymentService;
    private ReviewService reviewService;
    private ScreeningService screeningService;

    public FrontController() {
        this.appConfig = new AppConfig();
        init();
    }

    public boolean signUp(String email, String password, String name) {
        return memberService.register(email, password, name);
    }

    public boolean signIn(String email, String password) {
        return memberService.login(email, password);
    }

    public Payment bookMovieTicket(String email, Screening screening, Coupon coupon, Money point) {
        Member member = memberService.findMemberByEmail(email);
        Booking booking = new Booking(member, screening);
        bookingService.book(booking);
        return pay(booking, coupon, point);

    }

    public Payment pay(Booking booking, Coupon coupon, Money point) {
        Payment payment = new Payment(booking, coupon, point);
        paymentService.pay(payment);
        return payment;
    }

    public void cancelBooking(Booking booking) {
        bookingService.deleteBooking(booking.getId());
        Payment payment = paymentService.findPaymentByBookingId(booking.getId());
        paymentService.cancelPayment(payment.getId());
    }

    public List<Movie> search(String query) {
        return movieService.findByMovieTitle(query);
    }

    private void init() {
        this.bookingService = appConfig.bookingService();
        this.memberService = appConfig.memberService();
        this.movieService = appConfig.movieService();
        this.paymentService = appConfig.paymentService();
        this.reviewService = appConfig.reviewService();
        this.screeningService = appConfig.screeningService();
    }

    public List<Movie> findScreeningMovies() {
        return movieService.findScreeningMovies();
    }

    public List<Movie> findUpcomingMovies() {
        return movieService.findUpcomingSoonMovies();
    }

    public List<Booking> findBookings(String memberEmail) {
        return bookingService.findBookingsByMemberEmail(memberEmail);
    }

    public List<Screening> findScreenings(Movie movie) {
        return screeningService.findScreeningsByMovie(movie);
    }

    public Member findMember(String email) {
        return memberService.findMemberByEmail(email);
    }

    public void writeReview(Booking booking, String content) {
        Review review = new Review(booking, content);
        reviewService.writeReview(review);
    }

    public List<Review> findReview(Movie movie) {
        return reviewService.findReviewByMovieId(movie.getId());
    }

    public Movie getMovieDetail(List<Movie> movieList, int idx) {
        return movieList.get(idx);
    }
}
