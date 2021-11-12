package hosting.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tbl_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long article_id;
    @NotNull
    @Column(length = 255)
    String article_title;
    @NotNull
    String article_content;
    @NotNull
    Date updated_date;
    @NotNull
    Integer is_approve;

    public Tbl_data(Long article_id, String article_title, String article_content, Date updated_date, Integer is_approve) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_content = article_content;
        this.updated_date = updated_date;
        this.is_approve = is_approve;
    }

    public Tbl_data() {
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getIs_approve() {
        return is_approve;
    }

    public void setIs_approve(Integer is_approve) {
        this.is_approve = is_approve;
    }

}
