package cn.smbms.pojo;

public class MyFile {

    private Integer id;
    private String fileTitle;
    private String fileUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileTitle(String fileTitle) {
        return this.fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileUrl(String newFileName) {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "id=" + id +
                ", fileTitle='" + fileTitle + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
