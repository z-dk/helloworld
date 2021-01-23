package com.zhudengkui.helloworld.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


/**
 * @author z_dk
 */
public class ExcelUploadUtil {
	

	/**
	 * POI获取不同类型的单元格值的方法
	 */
	public static String getCellValue(Cell cell) throws Exception{
		String value;
        // 判断单元格不存在
		if(cell==null){
			return null;
		}
		switch (cell.getCellTypeEnum()) {
            case NUMERIC:
				//如果为时间格式的内容
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					value=sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
					break;
				}else {
					value = new DecimalFormat("##########.##########").format(cell.getNumericCellValue());
				}
				break;
            case STRING:
		      value = cell.getStringCellValue();
		      break;
		  case BOOLEAN:
		      value = cell.getBooleanCellValue() + "";
		      break;
		  case FORMULA:
			  try{
				  if(cell.getNumericCellValue()!=0){
					  DecimalFormat df = new DecimalFormat("#.00000");
					  value = df.format(cell.getNumericCellValue());
				  }else{
					  value="0";
				  }
				  
              }catch(IllegalStateException e){
            	  e.printStackTrace();
				  if(cell.getNumericCellValue()!=0){
					  DecimalFormat df = new DecimalFormat("#.00000");
					  value = df.format(cell.getRichStringCellValue());
				  }else{
					  value="0";
				  }
              }
		      break;
		  case BLANK:
		      value = "";
		      break;
		  case ERROR:
		      value = "非法字符";
		      break;
		  default:
		      value = "未知类型";
		          break;
		}
		return value;
	}
	
	/**
	 * 获取出现错误的提示行数
	 */
	public static StringBuilder getPromptMsg(int rowNum, int cellNum) throws Exception{
        return new StringBuilder().append("第").append(rowNum+1).append("行,第")
                .append(cellNum).append("个单元格:");
	}
	
	/**
	 * 获取出现错误的提示行数
	 */
	public static StringBuilder getPromptRowMsg(int rowNum) throws Exception{
        return new StringBuilder().append("第").append(rowNum+1).append("行:");
	}
	
	/**
	 * 验证整数的长度
	 */
	public static boolean regexpInt(String number) throws Exception{
		int length = number.length();
        return length <= 9;
    }
    
    
    //	public static Map<String,String> getCodeList(PCode pCodeVo) throws Exception{
//		/*PCodeService codeService = AppContainer.getBean(PCodeService.class);
//		pCodeVo.setTableNameOfCode("epc_p_code");
//		//根据码表类型获取码表集合
//		List<PCode> codeList = codeService.getPCodeList(pCodeVo);//电压等级的码表集合
//		Map<String,String> map = new HashMap<String,String>();
//		if(codeList != null && codeList.size()>0){
//			for (PCode pCode : codeList) {
//				map.put(pCode.getName(), pCode.getValue());
//			}
//		}*/
//
//		PCode pCode = new PCode();
//		BeanUtils.copyProperties(pCodeVo, pCode);
//
//		EcUntil bean = AppContainer.getBean(EcUntil.class);
//
//		Map<String, String> map = bean.getCodeList(pCode);
//
//		return map;
//	}
//
//	/**
//	 * 根据表类型获取码表集合
//	 */
//	public static Map<String,String> getMPCodeList(PCodeVo pCodeVo) throws Exception{
//		PCodeService codeService = AppContainer.getBean(PCodeService.class);
//		pCodeVo.setTableNameOfCode("m_p_code");
//		//根据码表类型获取码表集合
//		List<PCode> codeList = codeService.getPCodeList(pCodeVo);//电压等级的码表集合
//		Map<String,String> map = new HashMap<String,String>();
//		if(codeList != null && codeList.size()>0){
//			for (PCode pCode : codeList) {
//				map.put(pCode.getName(), pCode.getValue());
//			}
//		}
//		return map;
//	}
	
}
