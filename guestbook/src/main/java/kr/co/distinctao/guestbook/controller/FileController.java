package kr.co.distinctao.guestbook.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	// get 방식으로 요청 올 경우 업로드 폼을 보여줌
	@GetMapping ("/uploadform")
	public String uploadform() {
		return "uploadform";
	}
	
	
	@PostMapping("/upload")
	public String upload (@RequestParam("file") MultipartFile file) {
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 크기 : " + file.getSize());

        try(
                // 맥일 경우
                FileOutputStream fos = new FileOutputStream("/tmp/" + file.getOriginalFilename());
                // 윈도우일 경우
//                FileOutputStream fos = new FileOutputStream("c:/tmp/" + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        		
        ){
        	    int readCount = 0;
        	    byte[] buffer = new byte[1024];
            while((readCount = is.read(buffer)) != -1){
                fos.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
        
		return "uploadok";
	}
	
	
	@GetMapping("/download")
	public void download(HttpServletResponse response) {

        // 직접 파일 정보를 변수에 저장해 놨지만, 이 부분이 db에서 읽어왔다고 가정한다.
		String fileName = "celsius.png";
//		String saveFileName = "c:/tmp/connect.png";
		String saveFileName = "/tmp/celsius.png"; // 맥일 경우

		String contentType = "image/png";
		int fileLength = 1116303;

        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try(
                FileInputStream fis = new FileInputStream(saveFileName);
                OutputStream out = response.getOutputStream();
        ){
        	    int readCount = 0;
        	    byte[] buffer = new byte[1024];
            while((readCount = fis.read(buffer)) != -1){
            		out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
	}

}
