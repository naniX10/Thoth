package thoth.spring.project.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;

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

    public void removeImage(BookImage b) {

        String item1=b.getFnames().split("[/]")[0];
        String item2=b.getFnames().split("[/]")[1];
        String item3=b.getFnames().split("[/]")[2];

        // 삭제할 파일명 재조립
        int pos = item1.lastIndexOf(".");
        String fname = item1.substring(0,pos)
                +b.getUuid()+"."+item1.substring(pos+1);
        File f = new File(uploadPath,fname);
        f.delete();

        // 삭제할 파일명 재조립2
        // 첨부파일이 없을 경우 -가 들어가는데 떄문에 .으로 나눌 수가 없어 에러가 발생
        // 따라서, 예외를 무시하고 넘어가도록 하는 코드가 필요
        try {
            pos = item2.lastIndexOf(".");
            fname = item2.substring(0, pos)
                    + b.getUuid() + "." + item2.substring(pos + 1);
            f = new File(uploadPath,fname);
            f.delete();
        }catch(Exception ex) {}

        try {
            pos = item3.lastIndexOf(".");
            fname = item3.substring(0, pos)
                    + b.getUuid() + "." + item3.substring(pos + 1);
            f = new File(uploadPath,fname);
            f.delete();
        }catch(Exception ex) {}


    }
}