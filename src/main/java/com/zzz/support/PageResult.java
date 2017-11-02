package com.zzz.support;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 要加入getter，setter才能正确的被转换为json
 * @author hushengjun
 * @date 2017/11/2
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -2101017243893880821L;

    private int curPage;
    private int totalPages;
    private long totalElements;
    private List<T> content;

}
