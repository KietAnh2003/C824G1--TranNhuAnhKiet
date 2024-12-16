package com.example.thi.model;

import java.time.LocalDate;

public class BookBorrowCard {
    private String codeBorrowBook;
    private String bookCode;
    private int studentCode;
    private boolean status;
    private LocalDate startDay;
    private LocalDate endDay;

    public String getCodeBorrowBook() {
        return codeBorrowBook;
    }

    public void setCodeBorrowBook(String codeBorrowBook) {
        this.codeBorrowBook = codeBorrowBook;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
}
