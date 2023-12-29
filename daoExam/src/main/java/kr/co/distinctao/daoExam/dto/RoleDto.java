package kr.co.distinctao.daoExam.dto;

public class RoleDto {
	private int roleId;
	private String description;
	
	public int getRoleId() {
		return roleId;
	}
	public String getDescription() {
		return description;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", description=" + description + "]";
	}
	
	
}
