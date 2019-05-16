package util;

import java.util.List;

//分页属性类
public class Page {
    //页号
    private int pageNo;
    //每页的条数
    private int pageSize=3;
    //总条数
    private int count;
    //总页数
    private int pages;
    //起始行
    private int start;
    //上一页
    private int pre;
    //下一页
    private int next;
    //一页的数据
    private List list;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    //设置总条数
    public void setCount(int count) {
        this.count = count;
        //计算总页数
        setPages(count%pageSize==0?count/pageSize:count/pageSize+1);
        //验证页号
        if(pageNo<1){
            pageNo=1;
        }else if(pageNo>pages){
            pageNo=pages;
        }
        //计算start
        start=(pageNo-1)*pageSize;
        //计算上下页
        if(pageNo>1){
            pre=pageNo-1;
        }
        else{
            pre=1;
        }

        if(pageNo<pages){
            next=pageNo+1;
        }
        else{
            next=pages;
        }


    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
