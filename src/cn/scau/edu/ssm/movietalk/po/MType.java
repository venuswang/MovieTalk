package cn.scau.edu.ssm.movietalk.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.scau.edu.ssm.movietalk.validator.ValidGroup5;

public class MType {
	@NotNull(message="{mtype.id.null.error}", groups={ValidGroup5.class})
    private Integer id;

	@NotNull(message="{mtype.typename.null.error}", groups={ValidGroup5.class})
	@Size(min=1, max=20, message="{mtype.typename.length.error}", groups={ValidGroup5.class})
    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}