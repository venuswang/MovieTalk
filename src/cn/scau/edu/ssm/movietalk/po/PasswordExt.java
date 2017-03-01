package cn.scau.edu.ssm.movietalk.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.scau.edu.ssm.movietalk.validator.ValidGroup3;

/**
 * 密码的拓展类
 * @author Administrator
 *
 */
public class PasswordExt {
	@NotNull(message="{password.original.null.error}",groups={ValidGroup3.class})
	@Size(min=1,max=50,message="{password.original.size.error}",groups={ValidGroup3.class})
	private String originalPassword;
	
	@NotNull(message="{password.current.null.error}",groups={ValidGroup3.class})
	@Size(min=1,max=50,message="{password.current.size.error}",groups={ValidGroup3.class})
	private String currentPassword;
	
	@NotNull(message="{password.confirm.null.error}",groups={ValidGroup3.class})
	@Size(min=1,max=50,message="{password.confirm.size.error}",groups={ValidGroup3.class})
	private String confirmPassword;
	private String username;
	
	public String getOriginalPassword() {
		return originalPassword;
	}
	
	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "PasswordExt [originalPassword=" + originalPassword
				+ ", currentPassword=" + currentPassword + ", confirmPassword="
				+ confirmPassword + ", username=" + username + "]";
	}

}
