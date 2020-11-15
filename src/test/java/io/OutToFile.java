package io;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * <b>类 名 称</b> :  OutToFile<br/>
 * <b>类 描 述</b> :  输出内容到文件<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/13 16:47<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/13 16:47<br/>
 * <b>修改备注</b> :
 */
public class OutToFile {
    
    public static void main(String[] args) throws IOException {
        output("123456","hello.txt");
    }
    
    public void insertUser(List<CsUserRole> userRoleList) throws Exception {
        /**
         * INSERT INTO `user`(`id`, `login_name`, `user_name`, `password`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('000089', '000089', '丁燕', '123456',NULL, '000089', '2019-11-07 09:59:58', '2020-10-21 13:52:22');
         */
        String userBase = "INSERT INTO `user`(`id`, `login_name`, `user_name`, `password`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES (";
        StringBuilder insertSql = new StringBuilder();
        for (CsUserRole csUserRole : userRoleList){
            String loginName = pinyin(csUserRole.getUserName());
            String sql = userBase + "'','"+loginName+"','"+csUserRole.getUserName()+"','123456', NULL, NULL, '2019-11-13 20:00:00', '2020-10-21 20:00:00');";
            insertSql.append(sql);
            insertSql.append("\n");
        }
        try {
            output(insertSql.toString(),"insertUser.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(List<CsUserRole> userRoleList){
        /**
         * UPDATE `user` SET `mobile` = '15886667788', `update_time` = '2020-11-13 20:00:00' WHERE `id` = '123456';
         */
        String userBase = "UPDATE `user` SET `mobile` = '";
        StringBuilder updateSql = new StringBuilder();
        for (CsUserRole csUserRole : userRoleList){
            String sql = userBase + csUserRole.getPhone()+"', `update_time` = '2020-11-13 20:00:00' WHERE `id` = '"+csUserRole.getUserId()+"' limit 1;";
            updateSql.append(sql);
            updateSql.append("\n");
        }
        try {
            output(updateSql.toString(),"updateUser.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void insertUserOrg(List<CsUserRole> userRoleList){
        /**
         * INSERT INTO `user_org`(`id`, `user_id`, `org_id`, `type`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('123456', '123456', '51005', 0, '123456', '123456', '2020-09-11 19:36:25', '2020-09-11 19:36:25');
         */
        String userBase = "INSERT INTO `user_org`(`id`, `user_id`, `org_id`, `type`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES (";
        StringBuilder insertSql = new StringBuilder();
        for (CsUserRole csUserRole : userRoleList){
            String sql = userBase + "'"+csUserRole.getUserId()+"','"+csUserRole.getUserId()+"','"+csUserRole.getOrgId()+"','0', '123456', '123456', '2019-11-13 20:00:00', '2020-11-13 20:00:00');";
            insertSql.append(sql);
            insertSql.append("\n");
        }
        try {
            output(insertSql.toString(),"insertUserOrg.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void insertUserRole(List<CsUserRole> userRoleList){
        /**
         * INSERT INTO `user_role`(`id`, `user_id`, `role_id`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES ('123456', '123456', '123456', '123456', '123456', '2020-09-29 16:30:48', '2020-09-29 16:30:48');
         */
        String userBase = "INSERT INTO `user_role`(`id`, `user_id`, `role_id`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES (";
        StringBuilder insertSql = new StringBuilder();
        for (CsUserRole csUserRole : userRoleList){
            String sql = userBase + "'"+csUserRole.getUserId()+"','"+csUserRole.getUserId()+"','"+csUserRole.getRoleIds()+"', '123456', '123456', '2019-11-13 20:00:00', '2020-11-13 20:00:00');";
            insertSql.append(sql);
            insertSql.append("\n");
        }
        try {
            output(insertSql.toString(),"insertUserRole.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void output(String sql,String fileName) throws IOException {
        File insertFile = new File("C:\\Users\\z_dk\\Desktop\\test\\"+fileName);
    
        if (!insertFile.getParentFile().exists() || insertFile.getParentFile().mkdirs()){
            FileWriter fileWriter = new FileWriter(insertFile);
            fileWriter.write(sql);
            fileWriter.close();
        }
        
    }
    
    /**
     * 方法描述:汉字转拼音
     * @param [text]       
     * <br/>
     * java.lang.String
     * <br/><b>创 建 人:</b>zdk
     * <br/><b>创建时间:</b>2020/11/13 18:23
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/13 18:23
     * @since  1.0.0
     */
    private static String pinyin(String text) throws BadHanyuPinyinOutputFormatCombination {
        char[] chars = text.replaceAll(" ","").toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 设置大小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 设置声调表示方法
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // 设置字母u表示方法
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    
        StringBuilder result = new StringBuilder();
        for (char i : chars){
            String[] charStr = PinyinHelper.toHanyuPinyinStringArray(i, format);
            result.append(charStr[0]);
        }
        System.out.println(result.toString());
        return result.toString();
    }
    
    
}
