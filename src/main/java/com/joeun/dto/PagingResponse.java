package com.joeun.dto;

import com.joeun.service.Pagination;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

    @Getter
    public class PagingResponse<T> {  //T는 Type을 의미
        private List<T> list = new ArrayList<>();
        private Pagination pagination;

        public PagingResponse(List<T> list, Pagination pagination) {
            this.list.addAll(list);
            this.pagination = pagination;
        }

    }

