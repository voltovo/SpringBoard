package com.rubypaper;

import java.util.Date;

/**
 * BoardVO
 */
public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate = new Date();
    private int cnt = 0;

    public int getSeq() {
        return this.seq;
    }

    public void setSeq(final int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(final String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public int getCnt() {
        return this.cnt;
    }

    public void setCnt(final int cnt) {
        this.cnt = cnt;
    }

}