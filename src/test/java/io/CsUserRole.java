package io;

import java.util.List;

/**
 * <b>类 名 称： </b>CsUserRole<br/>
 * <b>类 描 述： </b><br/>
 * <b>创 建 人： </b>zdk<br/>
 * <b>创建时间： </b>2020/11/13 17:08<br/>
 * <b>修 改 人： </b>zdk<br/>
 * <b>修改时间： </b>2020/11/13 17:08<br/>
 * <b>修改备注： </b><br/>
 */
public class CsUserRole {
    private String id;
    private String userId;
    private String userName;
    private List<String> roleIds;
    private String roleName;
    private String orgId;
    private String orgName;
    private String phone;
    private String sqlFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSqlFlag() {
        return sqlFlag;
    }

    public void setSqlFlag(String sqlFlag) {
        this.sqlFlag = sqlFlag;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "CsUserRole{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", roleIds=" + roleIds +
                ", roleName='" + roleName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", phone='" + phone + '\'' +
                ", sqlFlag='" + sqlFlag + '\'' +
                '}';
    }
}
