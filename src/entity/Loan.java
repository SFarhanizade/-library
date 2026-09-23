package entity;


import java.time.LocalDateTime;

public class Loan {
private int id;
private int  bookId;
private int memberId;
private LocalDateTime loandate;
private LocalDateTime returndate;

    public Loan(int id, int book_id, int member_id, LocalDateTime loan_date, LocalDateTime returnDate) {
        this.id = id;
        this.bookId = book_id;
        this.memberId = member_id;
        this.loandate = loan_date;
        this.returndate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int book_id) {
        this.bookId = book_id;
    }

    public int getMember_id() {
        return memberId;
    }

    public void setMember_id(int member_id) {
        this.memberId = member_id;
    }

    public LocalDateTime getLoan_date() {
        return loandate;
    }

    public void setLoan_date(LocalDateTime loan_date) {
        this.loandate = loan_date;
    }

    public LocalDateTime getReturnDate() {
        return returndate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returndate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book_id=" + bookId +
                ", member_id=" + memberId +
                ", loan_date=" +  loandate+
                ", returnDate=" + returndate +
                '}';
    }
}
