package cn.scau.edu.ssm.movietalk.po;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.scau.edu.ssm.movietalk.validator.ValidGroup1;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup2;

public class MAdmin {
    private Integer id;

    @NotBlank(message="{madmin.uname.null.error}", groups={ValidGroup1.class,ValidGroup2.class})
    @Size(min=1, max=32, message="{madmin.uname.length.error}", groups={ValidGroup1.class,ValidGroup2.class})
    private String uname;
    
    @Size(max=50, message="{madmin.fullname.length.error}",groups={ValidGroup2.class})
    private String fullname;

    @Size(min=1, max=64, message="{madmin.email.length.error}",groups={ValidGroup2.class})
    @Email(message="{madmin.email.format.error}",groups={ValidGroup2.class})
    private String email;
   
    @Size(max=16, message="{madmin.phone.length.error}",groups={ValidGroup2.class})
    private String phone;

    @NotBlank(message="{madmin.pword.null.error}", groups={ValidGroup1.class})
    @Size(min=1, max=50, message="{madmin.pword.length.error}", groups={ValidGroup1.class})
    private String pword;

    private String loginTime;

    private String loginIp;

    private Boolean status;

    private Boolean loginmethod;

    private Boolean isSuper;

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword == null ? null : pword.trim();
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

    public Boolean getLoginmethod() {
        return loginmethod;
    }

    public void setLoginmethod(Boolean loginmethod) {
        this.loginmethod = loginmethod;
    }

    public Boolean getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Boolean isSuper) {
        this.isSuper = isSuper;
    }
}