package cardstore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
/**
 * ResponseEntity:作為控制器方法的返回值 表示響應到瀏覽器的完整響應報文
 * 文件上傳的必要條件
 * 1.form表單的請求方式必須為 method="post" 
 * 2.form表單必須設置enctype屬性  enctype="multipart/form-data"
 * 3.配置MultipartFile 解析器
 */
@Controller
public class FileController {
	@RequestMapping("/test/upload")
	//MultipartFile photo參數名要與前端input標籤的name一致 <input type="file" name="photo">
	public String testUp(MultipartFile photo , HttpSession session) throws IOException {
		//獲取上傳的檔案名稱
		String fileName = photo.getOriginalFilename();
		System.out.println("上傳檔案:"+fileName);
		//獲取上傳的檔案的後綴名 ex. jpg
		String typeName = fileName.substring(fileName.lastIndexOf("."));
		//獲取UUID
		String uuid = UUID.randomUUID().toString();
		//拼接新檔名避免重複檔名問題
		fileName = uuid + typeName;
		//獲取ServletContext物件
        ServletContext servletContext = session.getServletContext();
		//獲取當前專案下photo目錄的真實路徑
        String photoPath = servletContext.getRealPath("photo");
        //創建photoPath所對應的file物件
        File file = new File(photoPath);
        //判斷file對應的目錄是否存在 不存在就建立對應目錄
        if (!file.exists()) {
        	//建立file對應的目錄
			file.mkdir();
		}
        String finalPath = photoPath + File.separator + fileName;
        System.out.println("上傳文件路徑:"+finalPath);
        //上傳文件
        photo.transferTo(new File(finalPath));
		return "success";
	}
	
	
	@RequestMapping("/test/download")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //獲取ServletContext物件
        ServletContext servletContext = session.getServletContext();
        //獲取伺服器內文件的真實路徑
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "1.jpg";
        System.out.println(realPath);
        //創建輸入流
        InputStream is = new FileInputStream(realPath);
        //創建byte陣列，is.available()獲取輸入流所對應文件的byte位元組 
        byte[] bytes = new byte[is.available()];
        //將輸入流讀到byte陣列中
        is.read(bytes);
        //創建HttpHeaders物件設置響應頭資訊
        MultiValueMap<String, String> headers = new HttpHeaders();
        //設定下載方式與下載文件名  attachment;filename=(1.jpg可更改) :以附件方式下載,預設檔案名為1.jpg
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //設置響應狀態碼
        HttpStatus statusCode = HttpStatus.OK;
        //建立ResponseEntity物件
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //關閉輸入流
        is.close();
        return responseEntity;
    }
}
