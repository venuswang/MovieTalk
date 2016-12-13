package cn.scau.edu.ssm.movietalk.po;

public class MDairyWithBLOBs extends MDairy {
    private String content;

    private String apname;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getApname() {
        return apname;
    }

    public void setApname(String apname) {
        this.apname = apname == null ? null : apname.trim();
    }
}