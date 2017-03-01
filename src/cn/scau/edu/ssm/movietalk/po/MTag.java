package cn.scau.edu.ssm.movietalk.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.scau.edu.ssm.movietalk.validator.ValidGroup4;

public class MTag {
	@NotNull(message="{mtag.id.null.error}", groups={ValidGroup4.class})
    private Integer id;
	
	@NotNull(message="{mtag.tagname.null.error}", groups={ValidGroup4.class})
	@Size(min=1, max=20, message="{mtag.tagname.length.error}", groups={ValidGroup4.class})
    private String tagname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}