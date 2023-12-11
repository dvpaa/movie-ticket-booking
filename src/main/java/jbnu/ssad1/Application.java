package jbnu.ssad1;

import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.medel.entity.*;
import jbnu.ssad1.money.Money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {

    private final FrontController frontController;
    private boolean state = false;
    private String email;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Application() {
        this.frontController = new FrontController();
    }

    public void run() throws IOException {

        while (true) {
            System.out.println("------------------");
            if (!state) {
                System.out.println("1: 로그인");
                System.out.println("2: 회원가입");
                System.out.println("3: 영화 검색");
                System.out.println("4: 현재 상영작 조회");
                System.out.println("5: 상영 예정작 조회");
                System.out.println("6: 에매 내역 조회");
                System.out.println("7: 종료");
            } else {
                System.out.println("3: 영화 검색");
                System.out.println("4: 현재 상영작 조회");
                System.out.println("5: 상영 예정작 조회");
                System.out.println("6: 에매 내역 조회");
                System.out.println("8: 종료");
            }
            System.out.println("------------------");

            System.out.print("선택: ");
            int choice = Integer.parseInt(this.reader.readLine());

            switch (choice) {
                case 1:
                    signIn();
                    break;

                case 2:
                    signUp();
                    break;

                case 3:
                    search();
                    break;

                case 4:
                    findScreeningMovies();
                    break;

                case 5:
                    findUpcomingMovies();
                    break;

                case 6:
                    findBookings();
                    break;

                case 7:
                    exit();

                default:
                    System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
            }

        }
    }

    private static void exit() {
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
    }

    private void findBookings() throws IOException {
        if (!state) {
            System.out.println();
            System.out.println("로그인이 필요합니다.");
            return;
        }
        List<Booking> bookingList = frontController.findBookings(email);

        if (bookingList.isEmpty()) {
            System.out.println("예매 내역이 없습니다.");
            return;
        }

        System.out.println("------------------");
        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println(i + 1 + ": " + bookingList.get(i).getScreening());
        }
        System.out.println("------------------");
        System.out.println("0: 홈화면");
        System.out.println("1: 예매취소");
        System.out.println("2: 리뷰");
        System.out.println();
        System.out.print("선택: ");

        int input = Integer.parseInt(this.reader.readLine());
        if (input == 0) {
            return;
        }
        if (input == 1) {
            cancleBooking(bookingList);
        } else if (input == 2) {
            review(bookingList);
        } else {
            System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
        }
    }

    private void review(List<Booking> bookingList) throws IOException {
        System.out.print("작성할 예매 선택: ");
        int input = Integer.parseInt(this.reader.readLine());
        if (input <= 0 || input > bookingList.size()) {
            System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
            return;
        }
        System.out.println("리뷰를 작성해주세요.");
        String content = this.reader.readLine();
        frontController.writeReview(bookingList.get(input - 1), content);
    }

    private void cancleBooking(List<Booking> bookingList) throws IOException {
        System.out.print("취소할 예매 선택: ");
        int input = Integer.parseInt(this.reader.readLine());
        if (input <= 0 || input > bookingList.size()) {
            System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
            return;
        }

        frontController.cancelBooking(bookingList.get(input - 1));
    }

    private void findUpcomingMovies() throws IOException {
        List<Movie> movieList = frontController.findUpcomingMovies();
        System.out.println();
        showMovies(movieList);
    }

    private void showMovies(List<Movie> movieList) throws IOException {
        if (movieList.isEmpty()) {
            System.out.println("해당하는 영화가 존재하지 않습니다.");
            return;
        }

        System.out.println("------------------");
        System.out.println("0: 홈 화면");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println(i+1 + ": " + movieList.get(i).getTitle());
        }
        System.out.println("------------------");

        System.out.print("선택: ");
        int input = Integer.parseInt(this.reader.readLine());

        if (input == 0) {
            return;
        }

        if (input > movieList.size()) {
            System.out.println("올바르지 않은 선택입니다.");
            return;
        }

        movieDetail(movieList, input);
    }

    private void movieDetail(List<Movie> movieList, int input) throws IOException {
        Movie movie = frontController.getMovieDetail(movieList, input - 1);
        List<Review> reviews = frontController.findReview(movie);
        System.out.println(movie);
        if (!reviews.isEmpty()) {
            System.out.println("대표 리뷰: " + reviews.get(reviews.size() - 1));
        }
        System.out.println("------------------");
        System.out.println("0: 홈화면");
        System.out.println("1: 예매하기");
        System.out.println("------------------");

        System.out.print("선택: ");
        int input2 = Integer.parseInt(this.reader.readLine());

        switch (input2) {
            case 0:
                break;

            case 1:
                showScreenings(movie);
                break;

            default:
                System.out.println("올바르지 않은 선택입니다.");
        }
    }

    private void showScreenings(Movie movie) throws IOException {
        if (!state) {
            System.out.println();
            System.out.println("로그인이 필요합니다.");
            return;
        }

        List<Screening> screenings = frontController.findScreenings(movie);
        System.out.println("------------------");
        System.out.println("0: 홈 화면");
        for (int i = 0; i < screenings.size(); i++) {
            System.out.println(i + 1 + ": " + screenings.get(i));
        }
        System.out.println("------------------");

        System.out.print("선택: ");
        int input = Integer.parseInt(this.reader.readLine());

        if (input == 0) {
            return;
        }

        if (input > screenings.size()) {
            System.out.println("올바르지 않은 선택입니다.");
            return;
        }

        bookMovie(screenings.get(input - 1));
    }

    private void bookMovie(Screening screening) throws IOException {
        System.out.println("------------------");
        System.out.println("할인 수단");
        System.out.println("1: 쿠폰");
        System.out.println("2: 포인트");
        System.out.println("3: 사용안함");

        Coupon coupon = null;
        Money point = null;

        int input = Integer.parseInt(this.reader.readLine());
        Member member = frontController.findMember(email);

        switch (input) {
            case 1:
                List<Coupon> coupons = member.getCoupons();
                showCoupons(coupons);
                if (coupons.isEmpty()) {
                    return;
                }
                coupon = selectCoupon(coupons);
                payBooking(screening, coupon, point);
                break;
            case 2:
                showPoints(member);
                point = selectPoints(member);
                if (point == null) {
                    return;
                }
                payBooking(screening, coupon, point);
                break;
            case 3:
                payBooking(screening, coupon, point);
                break;
            default:
                System.out.println("올바르지 않은 선택입니다.");

        }
    }

    private void payBooking(Screening screening, Coupon coupon, Money point) {
        Payment payment = frontController.bookMovieTicket(email, screening, coupon, point);
        System.out.println();
        System.out.println("결제 금액: " + payment.getPaymentAmount());
    }

    private Money selectPoints(Member member) throws IOException {
        System.out.print("입력: ");
        Money inputPoints = Money.wons((Double.parseDouble(this.reader.readLine())));
        if (member.getPoint().isLessThan(inputPoints)) {
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        return inputPoints;

    }

    private void showPoints(Member member) {
        System.out.println("------------------");
        System.out.println("Point: " + member.getPoint());
        System.out.println("------------------");
    }

    private Coupon selectCoupon(List<Coupon> coupons) throws IOException {
        System.out.print("선택: ");
        int input = Integer.parseInt(this.reader.readLine());
        if (input <= 0 || coupons.size() < input) {
            return null;
        }

        return coupons.get(input - 1);
    }

    private void showCoupons(List<Coupon> coupons) {
        if (coupons.isEmpty()) {
            System.out.println("사용가능한 쿠폰이 없습니다.");
            return;
        }
        System.out.println("------------------");
        for (int i = 0; i < coupons.size(); i++) {
            System.out.println(i + 1 + ": " + coupons.get(i));
        }
        System.out.println("------------------");
    }

    private void findScreeningMovies() throws IOException {
        List<Movie> movieList = frontController.findScreeningMovies();
        System.out.println();
        showMovies(movieList);
    }

    private void search() throws IOException {
        System.out.println();
        System.out.println("검색어를 입력하세요");
        String query = this.reader.readLine();

        List<Movie> movieList = frontController.search(query);
        System.out.println();
        showMovies(movieList);
    }

    private void signUp() throws IOException {
        System.out.println();
        System.out.println("이메일을 입력하세요");
        String email = this.reader.readLine();
        System.out.println("비밀번호를 입력하세요");
        String password = this.reader.readLine();
        System.out.println("이름을 입력하세요");
        String name = this.reader.readLine();
        frontController.signUp(email, password, name);
    }

    private void signIn() throws IOException {
        System.out.println();
        System.out.println("이메일을 입력하세요");
        String email = this.reader.readLine();
        System.out.println("비밀번호를 입력하세요");
        String password = this.reader.readLine();

        if (frontController.signIn(email, password)) {
            this.state = true;
            this.email = email;
            return;
        }
        System.out.println("로그인에 실패하였습니다.");
    }

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.run();
    }
}
