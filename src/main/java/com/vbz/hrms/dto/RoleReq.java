package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class RoleReq {
private String RoleName;

public String getRoleName() {
	return RoleName;
}

public void setRoleName(String roleName) {
	RoleName = roleName;
}

}
