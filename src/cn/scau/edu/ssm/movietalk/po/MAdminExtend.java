package cn.scau.edu.ssm.movietalk.po;
/**
 * 后台管理员的拓展类
 * @author Administrator
 *
 */
public class MAdminExtend extends MAdmin {

	@Override
	public String toString() {
		return "MAdminExtend [getId()=" + getId() + ", getUname()="
				+ getUname() + ", getFullname()=" + getFullname()
				+ ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone()
				+ ", getPword()=" + getPword() + ", getLoginTime()="
				+ getLoginTime() + ", getLoginIp()=" + getLoginIp()
				+ ", getStatus()=" + getStatus() + ", getLoginmethod()="
				+ getLoginmethod() + ", getIsSuper()=" + getIsSuper() + "]";
	}
	
}
