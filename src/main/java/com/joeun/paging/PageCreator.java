package com.joeun.paging;

public class PageCreator {


    private PageVO paging; // PageVO객체
    private int beginPage;
    private int endPage;
    private int totalArticles; //조회한 총 게시물
    private boolean prev;
    private boolean next;

    private final int displayPage = 4; //한화면에 보여질 페이지수

    public void calc() { // 4가지 정보를 계산하는 메서드
        endPage =  (int)Math.ceil(paging.getPage() / (double)displayPage) * displayPage;
        beginPage = endPage - displayPage + 1;
        prev = (beginPage == 1) ? false : true;
        next = (totalArticles > endPage * paging.getCountPerPage()) ? true : false;
        if(!next) {
            endPage = (int)Math.ceil((double)totalArticles / paging.getCountPerPage());
        }
    }

    public PageVO getPaging() {
        return paging;
    }

    public void setPaging(PageVO paging) {
        this.paging = paging;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(int totalArticles) { //조회한 총 게시물을 주입한후 계산
        this.totalArticles = totalArticles;
        calc();
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPage() {
        return displayPage;
    }

}
