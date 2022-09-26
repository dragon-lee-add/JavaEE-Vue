package cn.smbms.pojo;

import java.util.Date;

public class Informations {
    private int id;
    private String title;
    private String hf_ck;
    private Date fb_date;
    private Date zxhf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHf_ck() {
        return hf_ck;
    }

    public void setHf_ck(String hf_ck) {
        this.hf_ck = hf_ck;
    }

    public Date getFb_date() {
        return fb_date;
    }

    public void setFb_date(Date fb_date) {
        this.fb_date = fb_date;
    }

    public Date getZxhf() {
        return zxhf;
    }

    public void setZxhf(Date zxhf) {
        this.zxhf = zxhf;
    }

    @Override
    public String toString() {
        return "Informations{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", hf_ck='" + hf_ck + '\'' +
                ", fb_date=" + fb_date +
                ", zxhf=" + zxhf +
                '}';
    }
}
