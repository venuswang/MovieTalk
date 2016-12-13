package cn.scau.edu.ssm.movietalk.po;

public class MUser {
    private Integer id;

    private String uname;

    private String realname;

    private String pword;

    private Boolean disable;

    private Integer sex;

    private String email;

    private Integer score;

    private String image;

    private String addtime;

    private String loginTime;

    private String loginIp;

    private Boolean status;

    private Integer repnum;

    private Integer rewrong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword == null ? null : pword.trim();
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime == null ? null : loginTime.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRepnum() {
        return repnum;
    }

    public void setRepnum(Integer repnum) {
        this.repnum = repnum;
    }

    public Integer getRewrong() {
        return rewrong;
    }

    public void setRewrong(Integer rewrong) {
        this.rewrong = rewrong;
    }
}