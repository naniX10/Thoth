package thoth.spring.project.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component("imgutil")
public class ImgUploadUtil {
    // 이미지 업로드 경로 설정 : 책이미지의 경우 nginx의 book폴더로 지정
    //private String uploadPath = "C:/Program Files/Java/nginx-1.21.0/html/book/";
    private String uploadPath = "D:/nginx-1.21.0/html/book/";

    // 첨부된 이미지가 있는지 확인
    public boolean checkImageFiles(MultipartFile[] img) {
        boolean isFiles = false;

        for (MultipartFile f : img) {
            // 파일이 존재한다면
            if (!f.getOriginalFilename().isEmpty()) {
                isFiles = true;
                break;
            }
        }
        return isFiles;
    }

    // 이미지업로드
    public String ImageUpload(MultipartFile f, String uuid) {
        // uuid : 알파벳 1개 + 숫자 13개 (원래는 바코드값으로 해야하지만 임시로 이렇게 함)
        String ofname = f.getOriginalFilename(); // 파일이름 받아옴
        int pos = ofname.lastIndexOf("."); // 확장자이전까지
        String nfname = ofname.substring(0,pos)+uuid + "." + ofname.substring(pos + 1); //파일명 생성
        //String nfname = ofname.substring(0,pos)+uuid+"."+ofname.substring(pos+1); //파일명 생성

        try {
            f.transferTo(new File(uploadPath + nfname)); //이미지 저장
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ofname + "/" + (f.getSize() / 1024);
    }

    // uuid 생성
    public String makeUUID() {
        String[] suuid = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // Math.random()*10
        // Math.random() *10+48
        // Math.random() *10
        String uuid = suuid[(int)(Math.random() * 10)]+String.valueOf((int)(Math.random()*100000));

        return uuid;
    }

}