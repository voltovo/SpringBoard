package com.rubypaper.board.domain;

import lombok.Data;

// getter, setter, toString 모두 포함 = data
@Data
public class Search {
    private String searchCondition;
    private String searchKeyword;
}
