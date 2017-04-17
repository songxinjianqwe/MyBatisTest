package me.newsong.domain.common;

import me.newsong.exception.PageOutOfBoundsException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SinjinSong on 2017/3/19.
 */
public class PageBean<T> implements Serializable{
    private List<T> data;// 当前页记录数, 需要传递
    private final int totalRecord;// 总记录数, 需要传递
    private final int currPage;// 当前页码, 需要传递
    private final int pageSize;// 每页记录数, 需要传递
    private int totalPage;// 总页数, 计算
    private int currPageBeginIndex; // 需要计算

    public PageBean(int currPage, int totalRecord, int pageSize) {
        this.currPage = currPage;
        this.totalRecord = totalRecord;
        this.pageSize = pageSize;
        init();
    }

    /**
     * 页数从0开始
     */
    private void init() {
        this.totalPage = totalRecord / pageSize;
        if (totalRecord % pageSize != 0) {
            this.totalPage++;
        }
        if(currPage >= totalPage){
            System.out.println("当前页码:"+currPage+"  总页码:"+totalPage);
            throw new PageOutOfBoundsException(totalPage);
        }
        this.currPageBeginIndex = this.currPage * this.pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrPageBeginIndex() {
        return currPageBeginIndex;
    }


    public int getCurrPage() {
        return currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", totalRecord=" + totalRecord +
                ", currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", currPageBeginIndex=" + currPageBeginIndex +
                '}';
    }
}
