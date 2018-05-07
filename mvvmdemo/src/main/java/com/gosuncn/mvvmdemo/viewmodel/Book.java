package com.gosuncn.mvvmdemo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gosuncn.mvvmdemo.BR;

import java.io.Serializable;

/**
 * Created by weiye on 2018/5/5 0005.
 * 书籍model绑定
 */

public class Book extends BaseObservable implements Serializable{


    private Integer bookId;

    @Bindable
    private String bookName;

    @Bindable
    private String author;

    @Bindable
    private String publisher;

    @Bindable
    private String publishYear;

    @Bindable
    private String callNum;

    @Bindable
    private String bookType;

    @Bindable
    private String collectionPlace;

    @Bindable
    private Integer borrowNum;

    @Bindable
    private String isbn;

    @Bindable
    private String issn;
    @Bindable
    private String detail;
    @Bindable
    private String searchTime;
    public Book() {
    }

    public Book(String bookName, String author, String publisher,  String callNum, String bookType, String collectionPlace, String isbn, String issn) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.callNum = callNum;
        this.bookType = bookType;
        this.collectionPlace = collectionPlace;
        this.isbn = isbn;
        this.issn = issn;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
        notifyPropertyChanged(BR.searchTime);
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
        notifyPropertyChanged(BR.bookName);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
        notifyPropertyChanged(BR.searchTime);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
        notifyPropertyChanged(BR.publisher);
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear == null ? null : publishYear.trim();
        notifyPropertyChanged(BR.publishYear);
    }

    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum == null ? null : callNum.trim();
        notifyPropertyChanged(BR.callNum);
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
        notifyPropertyChanged(BR.bookType);
    }

    public String getCollectionPlace() {
        return collectionPlace;
    }

    public void setCollectionPlace(String collectionPlace) {
        this.collectionPlace = collectionPlace == null ? null : collectionPlace.trim();
        notifyPropertyChanged(BR.collectionPlace);
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
        notifyPropertyChanged(BR.borrowNum);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
        notifyPropertyChanged(BR.isbn);
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
        notifyPropertyChanged(BR.issn);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
        notifyPropertyChanged(BR.detail);
    }
}
