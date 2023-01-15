package com.rg.homeinventory.utils;

import org.springframework.data.domain.Sort;

public class Constants {

    public interface HttpHeaderValues {
        long MAX_AGE = 86400;

    }

    public interface PAGE_CONSTANTS {
        int DEFAULT_PAGE_SIZE = 10;
        int DEFAULT_PAGE_NO = 0;
        Sort.Direction DEFAULT_SORT_ORDER = Sort.Direction.ASC;
        String DEFAULT_ALL_FILTER = "_";
    }
}
