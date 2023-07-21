package com.belajar.session.util;

public class DataResponsePagination<E, U> extends DataResponseList<E> {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Long totalRowCount;
    private boolean lastPage;

    public DataResponsePagination(PaginationList<E, U> paginationList) {
        super(paginationList.getData());
        this.page = paginationList.getPage();
        this.size = paginationList.getSize();
        this.totalPages = paginationList.getTotalPages();
        this.totalRowCount = paginationList.getTotalRowCount();
        this.lastPage = (this.totalPages - 1) == this.page ? true : false;
    }
}
